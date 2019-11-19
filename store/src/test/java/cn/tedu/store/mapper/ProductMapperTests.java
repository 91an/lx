
package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Product;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月24日 下午2:15:50 

* 类说明 

*/
@MapperScan("cn.tedu.store.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void findHostList() {
		List<Product> list = productMapper.findHostList();
		System.err.println("count=" + list.size());
		for (Product item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void findById(){
		Integer id = 10000013;
		Product result = productMapper.findById(id);
		System.err.println(result);
	}
}

