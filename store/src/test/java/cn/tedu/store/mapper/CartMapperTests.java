
package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月25日 上午11:07:13 

* 类说明 

*/
@MapperScan("cn.tedu.store.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
	
	@Autowired
	private CartMapper mapper;
	
	@Test
	public void addNew(){
		Cart result = new Cart();
		result.setPrice(2000);
		result.setPid(10000054);
		result.setNum(1);
		result.setUid(6);
		Integer rows = mapper.addNew(result);
		System.err.println("rows= " + rows);
	}
	
	@Test
	public void updateNumByCid(){
		Integer cid = 1;
		Integer num = 10;
		String modifiedUser = "骚强";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUidAndPid(){
		Integer uid = 2;
		Integer pid = 10000001;
		Cart result = mapper.findByUidAndPid(uid, pid);
		System.err.println("result=" + result);
	}
	
	@Test
	public void findVOByUid(){
		Integer uid = 2;
		List<CartVO> lists = mapper.findVOByUid(uid);
		System.err.println("lists=" + lists);
	}
	
	@Test
	public void findByCid(){
		Cart result = mapper.findByCid(1);
		System.err.println("result=" + result);
	}
	
	@Test
	public void findVOByCids() {
		Integer[] cids = {4,5,6,8};
		List<CartVO> list = mapper.findVOByCids(cids);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
	
	
}

