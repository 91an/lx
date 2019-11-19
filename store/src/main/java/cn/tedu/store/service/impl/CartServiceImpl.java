
package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.exception.AccessDeniedException;
import cn.tedu.store.service.exception.CartNotFoundException;
import cn.tedu.store.service.exception.InsertFaultException;
import cn.tedu.store.service.exception.UpdateFaultException;
import cn.tedu.store.vo.CartVO;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月25日 上午11:23:11 

* 类说明 

*/
@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private CartMapper mapper;
	
	@Autowired
	private IProductService service;
	
	@Override
	public void addToCart(Integer uid, String username, Integer pid, Integer num) {
		// 创建时间对象
		Date date = new Date();
		Cart result = findByUidAndPid(uid, pid);
		System.err.println("result=" + result);
		if(result == null) {
			Cart data = new Cart();
			data.setUid(uid);
			data.setPid(pid);
			data.setNum(num);
			System.err.println("1");
			data.setCreatedUser(username);
			data.setCreatedTime(date);
			data.setModifiedUser(username);
			data.setModifiedTime(date);
			System.err.println("2");
			Product product = service.getById(pid);
			data.setPrice(product.getPrice());
			
			addNew(data);
			System.err.println("3");
		} else {
			Integer cid = result.getCid();
			Integer newNum = result.getNum() + num; 
			updateNumByCid(cid, newNum,username,date);
		}
	}
	
	@Override
	public List<CartVO> getVOByUid(Integer uid) {
		return findVOByUid(uid);
	}
	
	@Override
	public Integer addNum(Integer cid, Integer uid, String username) {
		Cart result = findByCid(cid);
		if(result == null) {
			throw new CartNotFoundException("购物车不存在");
		}
		
		if(!result.getUid().equals(uid)) {
			throw new AccessDeniedException("非法访问！");
		}
		Integer newNum = result.getNum() + 1;
		updateNumByCid(cid, newNum, username, new Date());
		return newNum;
	}
	
	@Override
	public List<CartVO> getVOByCids(Integer[] cids, Integer uid) {
		List<CartVO> carts = findVOByCids(cids);
		Iterator<CartVO> it = carts.iterator();
		while(it.hasNext()){
			CartVO cart = it.next();
			if(!cart.getUid().equals(uid)){
				it.remove();
			}
		}
		return null;
	}

	/**
	 * 查询多个购物车数据
	 * @param cids 多个购物车数据的id
	 * @return 匹配的购物车数据列表
	 */
	private List<CartVO> findVOByCids(Integer[] cids) {
		return mapper.findVOByCids(cids);
	}
	
	/**
	 * 根据参数cid查询购物车商品数据
	 */
	private Cart findByCid(Integer cid){
		return mapper.findByCid(cid);
	}
	
	/**
	 * 查询某用户的购物车数据
	 * @param uid 用户id
	 * @return 该用户的购物车数据的列表
	 */
	private List<CartVO> findVOByUid(Integer uid) {
		return mapper.findVOByUid(uid);
	}
	
	private Cart findByUidAndPid(Integer uid, Integer pid){
		return mapper.findByUidAndPid(uid, pid);
	}
	
	private void addNew(Cart cart){
		Integer rows = mapper.addNew(cart);
		if(rows < 1){
			throw new InsertFaultException("添加购物车失败！");
		}
	}
	
	private void updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime){
		Integer rows = mapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
		if(rows < 1){
			throw new UpdateFaultException("更改数量失败！");
		}
	}

	
	

	
}

