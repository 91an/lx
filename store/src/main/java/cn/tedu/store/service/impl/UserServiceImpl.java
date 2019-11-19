
package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.exception.InsertFaultException;
import cn.tedu.store.service.exception.PasswordFaultException;
import cn.tedu.store.service.exception.UpdateFaultException;
import cn.tedu.store.service.exception.UsernameDuplicateException;
import cn.tedu.store.service.exception.UsernameNotFoundException;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午5:40:44 

* 类说明 

*/
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void reg(User user) {
		String username = user.getUsername();
		
		User result = userMapper.findByUsername(username);
		if (result != null) {
			throw new UsernameDuplicateException("尝试注册的用户名" + "(" + username + ")" + "已存在");
		}
		
		// 补全数据
		// 1.生成盐值
		String salt = UUID.randomUUID().toString();
		// 2.获得用户提交的原始密码
		String password = user.getPassword();
		// 3.执行加密
		String md5Password = getMd5Password(password, salt);
		// 4.将盐值和加密后的密码补全到user对象中
		user.setPassword(md5Password);
		user.setSalt(salt);
		user.setIsDelete(0);
		Date now = new Date();
		user.setCreatedUser(username);
		user.setCreatedTime(now);
		user.setModifiedUser(username);
		user.setModifiedTime(now);
		
		Integer rows = userMapper.insert(user);
		if (rows != 1) {
			throw new InsertFaultException("插入用户数据时出现未知错误！");
		}
	}

	@Override
	public User login(String username, String password,HttpSession session){
		//根据用户名在数据库内查找
		User result = userMapper.findByUsername(username);
		
		//判断用户名是否存在于数据库
		if(result == null){
			throw new UsernameNotFoundException("用户名不存在！");
		}
		
		//判断该用户是否为删除状态
		if (result.getIsDelete().equals(1)){
			throw new UsernameNotFoundException("用户名不存在！");
		}
		
		//对密码进行加盐
		String md5Password = getMd5Password(password, result.getSalt());
		
		//判断加盐密码是否正确
		if (!result.getPassword().equals(md5Password)){
			throw new PasswordFaultException("密码错误！");
		}
		
		User userShow = new User(result.getUid(),result.getUsername(),result.getGender(),result.getPhone(),result.getAvator());
		
		return userShow;
	}
	

	@Override
	public void updatePassword(Integer uid, String oldPwd, String newPwd) throws UsernameNotFoundException,UpdateFaultException {
		User result = userMapper.findByUid(uid);
		if (result == null || result.getIsDelete().equals(1)) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		String oldMd5Pwd = getMd5Password(oldPwd, result.getSalt());
		
		if (!oldMd5Pwd.equals(result.getPassword())) {
			throw new PasswordFaultException();
		}
		String newMd5Pwd = getMd5Password(newPwd, result.getSalt());
		String modifiedUser = result.getUsername();
		Date now = new Date();
		Integer rows = userMapper.updatePassword(uid, newMd5Pwd, modifiedUser, now);
		if (!rows.equals(1)) {
			throw new UpdateFaultException("修改密码失败, 请联系管理员！");
		}
	}
	
	@Override
	public User getByUid(Integer uid) {
		User result = userMapper.findByUid(uid);
		if (result == null || result.getIsDelete().equals(1)) {
			throw new UsernameNotFoundException();
		}
		return result;
	}

	@Override
	public void updateInfo(Integer uid, String username, User user) throws UsernameNotFoundException {
		User result = getByUid(uid);
		if (result == null || result.getIsDelete().equals(1)) {
			throw new UsernameNotFoundException();
		}
		user.setModifiedUser(username);
		user.setModifiedTime(new Date());
		user.setUid(uid);
		user.setUsername(username);
		Integer rows = userMapper.updateInfoByUid(user);
		if (!rows.equals(1)) {
			throw new UpdateFaultException("修改失败，请联系管理员！");
		}
	}
	
	@Override
	public void updateAvatar(Integer uid, String username, String avatar) throws UpdateFaultException {
		User result = userMapper.findByUid(uid);
		if(result == null || result.getIsDelete().equals(1)){
			throw new UsernameNotFoundException();
		}
		Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
		if(!rows.equals(1)){
			throw new UpdateFaultException();
		}
		
	}
	
	/**
	 * 多重加密
	 */
	private String getMd5Password(String password,String salt){
		// 加密标准: 将盐拼在原始密码的左右两侧，循环加密3次
		for (int i = 0; i < 3; i++){
			password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes());
		}
		return password;
	}

	

	
	
}

