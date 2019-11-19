
package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.tedu.store.entity.User;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午3:08:09 

* 类说明 
* 处理用户数据的持久层接口

*/
public interface UserMapper {
	/**
	 * 插入用户数据
	 */
	Integer insert(User user);
	/**
	 * 根据用户名查询用户数据
	 * @param return 匹配用户数据，匹配到返回数据，匹配不到返回null
	 */
	User findByUsername(String username);
	
	User findByUid(Integer uid);
	
	Integer updatePassword(@Param("uid")Integer uid,
						@Param("password") String password,
						@Param("modifiedUser")String modifiedUser,
						@Param("modifiedTime")Date modifiedTime);
	/**
	 * 更新用户资料
	 */
	Integer updateInfoByUid(User user);
	
	@Update("update t_user set avatar=#{avatar},modified_user=#{modifiedUser},modified_Time=#{modifiedTime} where uid=#{uid}")
	Integer updateAvatarByUid(
		@Param("uid") Integer uid,
		@Param("avatar") String avatar,
		@Param("modifiedUser") String modifiedUser,
		@Param("modifiedTime") Date modifiedTime);
}

