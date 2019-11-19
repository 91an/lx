
package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.exception.ServiceException;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午5:49:50 

* 类说明 

*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private IUserService services;
	
	@Test
	public void reg(){
		try {                                                                                                               
			User user = new User();
			user.setUsername("顺哥");
			user.setPassword("sss");
			services.reg(user);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
		}
	}
}

