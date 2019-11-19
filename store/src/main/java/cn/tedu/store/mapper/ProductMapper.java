
package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Product;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月24日 下午2:10:19 

* 类说明 
* 处理商品数据的持久层接口

*/

public interface ProductMapper {
	/**
	 * 查询热销的前四个商品
	 */
	List<Product> findHostList();
	
	/**
	 * 根据id匹配对应的商品
	 */
	Product findById(Integer id);
}

