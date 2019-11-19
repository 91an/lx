
package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.District;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.util.JsonResult;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月21日 下午2:04:37 

* 类说明 

*/
@RequestMapping("/district")
@RestController
public class DistrictController extends BaseController{
	@Autowired
	private IDistrictService districtService;
	
	@GetMapping({"/",""})
	public JsonResult<List<District>> getByPerent(String parent){
		// 查询
		List<District> data = districtService.getByParent(parent);
		// 返回
		return new JsonResult<List<District>>(SUCCESS, data);
		
	}
}

