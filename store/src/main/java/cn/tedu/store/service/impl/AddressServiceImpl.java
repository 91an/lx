
package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.exception.AccessDeniedException;
import cn.tedu.store.service.exception.AddressCountBeyondException;
import cn.tedu.store.service.exception.AddressNotFoundException;
import cn.tedu.store.service.exception.DeleteException;
import cn.tedu.store.service.exception.InsertFaultException;
import cn.tedu.store.service.exception.UpdateFaultException;

/** 
 * @author 作者 Your-Name: Bard
 * @version 创建时间：2019年10月18日 下午4:32:30 

 * 类说明 

 */
@Service
public class AddressServiceImpl implements IAddressService{

	@Value("${project.address.max-count}")
	private Integer addressMaxCount;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private IDistrictService districtService;

	@Override
	public void addnew(Integer uid, String username, Address address) {
		// 根据参数uid查询该用户的收货地址数量
		Integer count = countByUid(uid);
		// 判断该用户的收货地址数量是否已经达到上线: count >= 10;
		if (count >= addressMaxCount) {
			// 是: 抛出地址数量过多异常
			throw new AddressCountBeyondException("地址数量过多");
		}
		// 补全收货地址数据
		String provinceName = getDistrictName(address.getProvinceId());
		String cityName = getDistrictName(address.getCityId());
		String areaName = getDistrictName(address.getAreaId());

		address.setProvinceName(provinceName);
		address.setCityName(cityName);
		address.setAreaName(areaName);
		// 判断查询到的收货地址数量是否为0, 得到isDefault
		Integer isDefault = count == 0 ? 1 : 0; 
		// 补全数据
		address.setIsDefault(isDefault);
		address.setUid(uid);
		// 创建当前时间对象，并补偿4个日志数据
		Date date = new Date();
		address.setCreatedUser(username);
		address.setCreatedTime(date);
		address.setModifiedUser(username);
		address.setModifiedTime(date);
		// 调用持久层对象插入数据
		insert(address);
	}

	@Override
	@Transactional
	public void setDefault(Integer aid, Integer uid, String username) {
		// 根据 aid 查询数据，判断查询结果是否为 null
		Address result = findByAid(aid);
		if (result == null){
			throw new AddressNotFoundException("尝试访问的收货地址数据不存在！");
		}
		// 检查归属是否正确，判断查询结果中的 uid 与当前登录的用户 uid(参数uid)是否不同
		if (!result.getUid().equals(uid)) {
			throw new AccessDeniedException("非法访问！");
		}
		// 将该用户的所有地址设置为非默认，获取返回值
		updateNonDefaultByUid(uid);
		// 将指定地址设置为默认，获取返回值
		updateDefaultByAid(aid, username, new Date());
	}

	/**
	 * 以下属性不返回给页面，所以设置为null
	 */
	@Override
	public List<Address> getByUid(Integer uid) {
		List<Address> list = findByUid(uid);
		for (Address address : list) {
			address.setUid(null);
			address.setProvinceId(null);
			address.setCityId(null);
			address.setAreaId(null);
			address.setCreatedUser(null);
			address.setCreatedTime(null);
			address.setModifiedUser(null);
			address.setModifiedTime(null);
		}
		return list;
	}

	@Override
	public void delete(Integer aid, Integer uid, String username) {
		// 根据参数aid查询数据
		Address result = findByAid(aid);
		// 判断查询结果是否为null
		if (result == null) {
			throw new AddressNotFoundException("尝试访问的收货地址数据不存在！");
		}
		// 判断查询结果中的uid与参数uid是否不同
		if (!result.getUid().equals(uid)) {
			throw new AccessDeniedException("非法访问！");
		}
		// 根据参数aid执行删除地址
		deleteByAid(aid);

		// 判断查询结果中的isDefault是否为0
		if (result.getIsDefault() == 0) {
			return;
		}
		// 通过countByUid(uid)统计还有多少收货地址
		Integer count = addressMapper.countByUid(uid);
		// 判断统计结果是否为0
		if (count == 0) {
			return;
		}
		// 通过findLastModifiedByUid(uid)找出最后修改的收货地址
		Address Lastaddress = findLastModifiedByUid(uid);
		// 取出这条收货地址的aid
		Integer lastAid = Lastaddress.getAid();
		// 执行设置默认收货地址
		updateDefaultByAid(lastAid, username, new Date());
	}
	
	@Override
	public Address getByAid(Integer aid) {
		Address address = findByAid(aid);
		if (address == null) {
			throw new AddressNotFoundException(
				"尝试访问的收货地址数据不存在");
		}
		
		address.setCreatedUser(null);
		address.setCreatedTime(null);
		address.setModifiedUser(null);
		address.setModifiedTime(null);
		return address;
	}

	/**
	 * 功能性方法，与业务方法分隔开，仅处理删除地址的功能
	 */
	private void deleteByAid(Integer aid){
		// 根据参数aid执行删除，获取返回值
		Integer rows = addressMapper.deleteByAid(aid);
		// 判断返回值是否不为1
		if (rows != 1) {
			throw new DeleteException("删除失败！");
		}
	}
	
	/**
	 * 功能性方法，与业务方法分隔开，仅处理更新默认地址的功能
	 */
	private void updateDefaultByAid(Integer aid, String username, Date date){
		// 通过updateDefaultByAid(aid, username, date)以上找到的收货地址设置为默认，获取返回值
		Integer rows = addressMapper.updateDefaultByAid(aid, username, date);
		// 判断返回值是否不为1
		if (rows != 1) {
			throw new UpdateFaultException("设置默认值失败！");
		}
	}
	
	/**
	 * 功能性方法，与业务方法分隔开，仅处理插入数据的功能
	 */
	private void insert(Address address){
		Integer rows = addressMapper.insert(address);
		if (rows != 1){
			throw new InsertFaultException("插入收货地址数据时出现未知错误，清联系系统管理员！");
		}
	}
	
	/**
	 * 功能性方法，与业务方法分隔开，仅处理将收获地址设为非空
	 */
	private void updateNonDefaultByUid(Integer uid){
		Integer rows = addressMapper.updateNonDefaultByUid(uid);
		if (rows < 1) {
			throw new UpdateFaultException("更新收货地址数据时出现未知错误，请联系系统管理员！");
		}
	}
	
	/**
	 * 根据省市区的代号，获取省市区的名称
	 */
	private String getDistrictName(String code){
		District district = districtService.getByCode(code);
		return district == null ? null : district.getName();
	}
	
	/**
	 * 统计某用户的收货地址数据的数量
	 * @param uid 用户的id
	 * @return 该用户的收货地址数据的数量
	 */
	private Integer countByUid(Integer uid) {
		return addressMapper.countByUid(uid);
	}
	
	/**
	 * 根据收货地址数据的id，查询收货地址详情
	 * @param aid 收货地址数据的id
	 * @return 匹配的收货地址详情，如果没有匹配的数据，则返回null
	 */
	private Address findByAid(Integer aid) {
		return addressMapper.findByAid(aid);
	}
	
	/**
	 * 查询某用户最后修改的收货地址详情
	 * @param uid 用户的id
	 * @return 匹配的收货地址详情，如果没有匹配的数据，则返回null
	 */
	private Address findLastModifiedByUid(Integer uid) {
		return addressMapper.findLastModifiedByUid(uid);
	}
	
	/**
	 * 获取某用户的收货地址列表
	 * @param uid 用户的id
	 * @return 该用户的收货地址列表
	 */
	private List<Address> findByUid(Integer uid) {
		return addressMapper.findByUid(uid);
	}

	









}

