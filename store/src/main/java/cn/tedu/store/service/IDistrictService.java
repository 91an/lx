
package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月21日 上午10:33:59 

* 类说明 

*/

public interface IDistrictService {
	List<District> getByParent(String parent);
	
	District getByCode(String code);
}

