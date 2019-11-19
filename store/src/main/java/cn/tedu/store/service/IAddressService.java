
package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月18日 下午4:26:38 

* 类说明 

*/

public interface IAddressService {
	/**
	 * 增加新的收货地址数据
	 */
	void addnew(Integer uid, String username, Address address);
	/**
	 * 获取某用户的收货地址列表
	 */
	List<Address> getByUid(Integer uid);
	/**
	 * 设置默认值
	 */
	void setDefault(Integer aid, Integer uid, String username);
	
	void delete(Integer aid, Integer uid, String username);
	
	Address getByAid(Integer aid);
}

