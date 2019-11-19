
package cn.tedu.store.mapper;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月18日 下午3:51:03 

* 类说明 

*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(1);
		address.setName("Tom");
		Integer rows = addressMapper.insert(address);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void countByUid() {
		Integer uid = 1;
		Integer count = addressMapper.countByUid(uid);
		System.err.println("count=" + count);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 1;
		List<Address> list = addressMapper.findByUid(uid);
		System.err.println("count=" + list.size());
		for (Address address : list) {
			System.err.println(address);
		}
	}
	@Test
	public void updateDefaultByAid() {
		Integer aid = 3;
		String modifiedUser = "王二麻子";
		Date modifiedTime = new Date();
		Integer rows = addressMapper.updateDefaultByAid(aid, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateNonDefaultByUid() {
		Integer uid = 5;
		Integer rows = addressMapper.updateNonDefaultByUid(uid);
		System.err.println("rows=" + rows);
	}
	@Test
	public void findByAid() {
		Integer aid = 4;
		Address address = addressMapper.findByAid(aid);
		System.err.println(address);
	}
}

