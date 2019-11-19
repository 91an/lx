
package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.vo.CartVO;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月25日 上午11:21:32 

* 类说明 

*/

public interface ICartService {
	/**
	 * 为购物车插入新的数据
	 */
	void addToCart(Integer uid, String username, Integer pid, Integer num);
	
	List<CartVO> getVOByUid(Integer uid);
	
	Integer addNum(Integer cid, Integer uid, String username);
	
	List<CartVO> getVOByCids(Integer[] cids, Integer uid);
}

