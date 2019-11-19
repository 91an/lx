
package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.vo.CartVO;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月25日 上午11:29:23 

* 类说明 

*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {
	
	@Autowired
	private ICartService service;
	
	@Test
	public void addToCart(){
		try {
			Integer uid = 6;
			String username = "zhengqian";
			Integer pid = 10000009;
			Integer num = 10;
			service.addToCart(uid, username, pid, num);
		} catch (Exception e) {
			e.getClass();
			e.getMessage();
		}
	}
	
	@Test
	public void getVOByUid() {
		Integer uid = 6;
		List<CartVO> list = service.getVOByUid(uid);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void addNum(){
		Integer cid = 2;
		Integer uid = 3;
		String username = "zhengqian";
		service.addNum(cid, uid, username);
		System.err.println("OK.");
		
	}
	
	@Test
	public void getVOByCids() {
		Integer uid = 6;
		Integer[] cids = {4,5,6,7,8};
		List<CartVO> list = service.getVOByCids(cids, uid);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
}

