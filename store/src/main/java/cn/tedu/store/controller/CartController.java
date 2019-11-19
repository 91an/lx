
package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.service.ICartService;
import cn.tedu.store.util.JsonResult;
import cn.tedu.store.vo.CartVO;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月25日 下午3:03:45 

* 类说明 

*/
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController{
	
	@Autowired
	private ICartService service;
	
	@RequestMapping("/add_to_cart")
	public JsonResult<Void> addToCart(Integer pid, Integer num, HttpSession session){
		service.addToCart(getUidFromSession(session),
							getUsernameFromSession(session),
							pid, num);
		return new JsonResult<>(SUCCESS);
	}
	
	@RequestMapping({"/", ""})
	public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
		List<CartVO> data = service.getVOByUid(getUidFromSession(session));
		return new JsonResult<>(SUCCESS, data);
	}
	
	@RequestMapping("{cid}/num/add")
	public JsonResult<Void> addNum(@PathVariable("cid") Integer cid, HttpSession session){
		System.err.println("----cid=" + cid);
		service.addNum(cid, getUidFromSession(session),
							getUsernameFromSession(session));
		
		return new JsonResult<>(SUCCESS);
	}
}

