
package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.util.JsonResult;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月18日 下午4:57:31 

* 类说明 

*/
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping("/addnew")
	public JsonResult<Void> addNew(Address address,HttpSession session){
		
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		addressService.addnew(uid, username, address);
		
		return new JsonResult<>(SUCCESS);
	}
	
	@GetMapping({"/",""})
	public JsonResult<List<Address>> getByUid(HttpSession session){
		
		List<Address> data = addressService.getByUid(getUidFromSession(session));
		
		
		System.err.println(getUidFromSession(session));
		return new JsonResult<>(SUCCESS, data);
	}
	
	@RequestMapping("{aid}/set_default")
	public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session){
		addressService.setDefault(aid,
									getUidFromSession(session),
									getUsernameFromSession(session));
		return new JsonResult<>(SUCCESS);
	}
	
	@RequestMapping("{aid}/delete")
	public JsonResult<Void> deleteAddress(@PathVariable("aid") Integer aid, HttpSession session) {
		System.err.println("deleteAddress---执行");
		addressService.delete(aid,
								getUidFromSession(session),
								getUsernameFromSession(session));
		System.err.println("deleteAddress---OK.");
		return new JsonResult<>(SUCCESS);
		
	}
}

