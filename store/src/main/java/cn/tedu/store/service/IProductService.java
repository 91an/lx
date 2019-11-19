
package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Product;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月24日 下午2:21:59 

* 类说明 

*/

public interface IProductService {
	/**
	 * 获取前四件热销
	 */
	List<Product> getHostList();
	/**
	 * 根据id匹配商品详情
	 */
	Product getById(Integer id);
}

