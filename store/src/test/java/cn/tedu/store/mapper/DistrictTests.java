
package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月21日 上午10:48:24 

* 类说明 

*/
@MapperScan("cn.tedu.store.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictTests {
	@Autowired
	private DistrictMapper districtMapper;

	@Test
	public void getByParent(){
		String parent = "86";
		List<District> lists = districtMapper.findByParent(parent);
		System.err.println("count=" + lists.size());
		for (District item : lists) {
			System.err.println(item);
		}
	}
	@Test
	public void findByCode() {
		String code = "130000";
		District district = districtMapper.findByCode(code);
		System.err.println(district);
	}
	
	
}

