
package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Product;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月24日 下午2:48:35 

* 类说明 

*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {
	
	@Autowired
	private IProductService service;
	
	@Test
	public void getHostList() {
		List<Product> list = service.getHostList();
		System.err.println("count=" + list.size());
		for (Product item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void getById(){
		Integer id = 10000013;
		Product result = service.getById(id);
		System.err.println(result);
	}
}

