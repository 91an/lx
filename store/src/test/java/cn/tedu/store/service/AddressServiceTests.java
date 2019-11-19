
package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.exception.ServiceException;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月21日 下午11:56:51 

* 类说明 

*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
	@Autowired
	private IAddressService service;

	@Test
	public void addnew() {
		try {
			Integer uid = 1;
			String username = "HAHAHA";
			Address address = new Address();
			address.setName("小刘同学");
			service.addnew(uid, username, address);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void setDefault() {
		try {
			Integer aid = 10;
			Integer uid = 5;
			String username = "HAHAHA";
			service.setDefault(aid, uid, username);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
}

