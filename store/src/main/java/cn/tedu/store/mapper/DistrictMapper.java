
package cn.tedu.store.mapper;

import java.util.List;
import cn.tedu.store.entity.District;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月21日 上午10:41:15 

* 类说明 
* 处理省/市/区的持久层接口

*/
public interface DistrictMapper {
	/**
	 * 获取全国所有省/全省所有市/全市所有区的列表内容
	 */
	List<District> findByParent(String parent);
	
	District findByCode(String code);
}

