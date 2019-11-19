
package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.ProductMapper;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.exception.ProductNotFoundException;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月24日 下午2:22:33 

* 类说明 

*/
@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> getHostList() {
		List<Product> products = findHostList();
		for (Product product : products) {
			product.setStatus(null);
			product.setPriority(null);
			product.setCreatedUser(null);
			product.setCreatedTime(null);
			product.setModifiedUser(null);
			product.setModifiedTime(null);
		}
		return products;
	}
	
	@Override
	public Product getById(Integer id) {
		Product product = findById(id);
		if (product == null){
			throw new ProductNotFoundException("没有找到该商品!");
		}
		// 补全数据
		product.setPriority(null);
		product.setCreatedUser(null);
		product.setCreatedTime(null);
		product.setModifiedUser(null);
		product.setModifiedTime(null);
		
		return product;
	}
	
	private Product findById(Integer id) {
		return productMapper.findById(id);
	}
	
	/**
	 * 获取热销排行的前4个商品
	 * @return 热销排行的前4个商品
	 */
	private List<Product> findHostList(){
		return productMapper.findHostList();
	}

	




	
}

