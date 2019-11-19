
package cn.tedu.store.service;


import javax.servlet.http.HttpSession;


import cn.tedu.store.entity.User;
import cn.tedu.store.service.exception.InsertFaultException;
import cn.tedu.store.service.exception.PasswordFaultException;
import cn.tedu.store.service.exception.UpdateFaultException;
import cn.tedu.store.service.exception.UsernameDuplicateException;
import cn.tedu.store.service.exception.UsernameNotFoundException;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午5:19:36 

* 类说明 

*/

public interface IUserService {
	
	void reg(User user) throws UsernameDuplicateException,InsertFaultException;
	
	User login(String username, String password,HttpSession session) throws PasswordFaultException, UsernameNotFoundException;
	
	void updatePassword(Integer uid, String oldPwd, String newPwd) throws UsernameNotFoundException,UpdateFaultException;
	
	User getByUid(Integer uid) throws UsernameNotFoundException;
	
	void updateInfo(Integer uid, String username, User user) throws UsernameNotFoundException;

	void updateAvatar(Integer uid, String username, String avatar) throws UpdateFaultException;
	
	
}

