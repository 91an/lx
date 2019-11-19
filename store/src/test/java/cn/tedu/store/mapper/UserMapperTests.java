
package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午3:49:13 

* 类说明 

*/
@MapperScan("cn.tedu.store.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void insert(){
		User user = new User();
		user.setUsername("顺哥");
		user.setPassword("sss");
		Integer rows = userMapper.insert(user);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUsername(){
		String username = "骚强";
		User user = userMapper.findByUsername(username);
		System.err.println("user=" + user);
	}
	
	@Test
	public void getByUid(){
		User user = userMapper.findByUid(2);
		System.err.println("user=" + user);
		
	}
	
	@Test
	public void updateInfoByUid(){
		User user = new User();
		user.setUid(2);
		user.setPhone("13345127081");
		user.setEmail("qiangpi111@qq.com");
		user.setGender(1);
		user.setModifiedUser("root");
		user.setModifiedTime(new Date());
		
		Integer rows = userMapper.updateInfoByUid(user);
		System.err.println("rows= " + rows);
	}
	
	
	
	
}

