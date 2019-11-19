
package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月18日 下午3:13:48 

* 类说明 

*/
public interface AddressMapper {
	Integer insert(Address address);
	
	Integer countByUid(Integer uid);
	
	List<Address> findByUid(Integer uid);
	
	/**
	 * 将指定的收货地址数据设置为默认
	 */
	Integer updateDefaultByAid(
			@Param("aid") Integer aid,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 将某用户的所有收货地址全部设置为非默认
	 * @param uid 用户的id
	 */
	Integer updateNonDefaultByUid(Integer uid);
	
	/**
	 * 根据收货地址数据的id，查询收货地址详情
	 */
	Address findByAid(Integer aid);
	
	/**
	 * 根据aid删除数据
	 * @return 返回SQL语句修改的行数
	 */
	Integer deleteByAid(Integer aid);
	/**
	 * 根据uid判断用户删除的是否为最后一条收货地址
	 * @return 返回最后一条修改的收货地址
	 */
	Address findLastModifiedByUid(Integer uid);
}

