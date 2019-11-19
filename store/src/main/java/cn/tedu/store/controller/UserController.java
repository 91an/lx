
package cn.tedu.store.controller;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.controller.exception.FileEmptyException;
import cn.tedu.store.controller.exception.FileSizeException;
import cn.tedu.store.controller.exception.FileTypeException;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.util.JsonResult;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月14日 下午2:16:01 

* 类说明 
* 处理用户相关请求的控制器

*/
@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
	
	public static final List<String> AVATAR_TYPE = new ArrayList<>();
	
	static {
		AVATAR_TYPE.add("image/jpeg");
		AVATAR_TYPE.add("image/png");
		AVATAR_TYPE.add("image/gif");
		AVATAR_TYPE.add("image/bmp");
	}
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/reg")
	public JsonResult<Void> reg(User user){
		userService.reg(user);
		return new JsonResult<>(SUCCESS);
	}
	
	@RequestMapping("/login")
	public JsonResult<User> login(String username,String password){
		User data = userService.login(username, password, session);
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		return new JsonResult<>(SUCCESS, data);
	}	
	
	@RequestMapping("/update_password")
	public JsonResult<Void> update(@RequestParam("old_pwd") String oldPwd,
									@RequestParam("new_pwd")String newPwd,
														HttpSession session){
		
		System.err.println("haha"+oldPwd);
		userService.updatePassword(getUidFromSession(session), 
				oldPwd, newPwd);
		return new JsonResult<>(SUCCESS);
		
	}
	
	@GetMapping("/show_info")
	public JsonResult<User> showInfo(){
		User data = userService.getByUid(getUidFromSession(session));
		return new JsonResult<>(SUCCESS, data);
		
	}
	
	@RequestMapping("/update_info")
	public JsonResult<User> updateInfo(User user, HttpSession session){
		userService.updateInfo(getUidFromSession(session), getUsernameFromSession(session), user);
		return new JsonResult<>(SUCCESS);
	}
	
	@GetMapping("/logout")
	public JsonResult<Void> logout(HttpSession session){
		session.invalidate();
		return null;
	}
	
	@PostMapping("/update_avatar")
	public JsonResult<String> updateAvatar(@RequestParam("avatar") MultipartFile avatar, HttpSession session){
		// 检查上传的文件是否为空
		if (avatar.isEmpty()){
			throw new FileEmptyException("文件为空！");
		}
		
		// 检查上传的文件是否超过限制的文件大小
		if (avatar.getSize() > AVATAR_MAXSIZE){
			throw new FileSizeException("文件过大！不得超过" + AVATAR_MAXSIZE);
		}
		
		if (!AVATAR_TYPE.contains(avatar.getContentType())) {
			throw new FileTypeException("上传的文件类型错误！");
		}
		// 保存客户端上传的文件
		// 获取原始文件名
		String originalFilename = avatar.getOriginalFilename();
		
		String parentPath = session.getServletContext().getRealPath("upload");
		File parent = new File(parentPath);
		if(!parent.exists()){
			parent.mkdirs();
		}
		String suffix = "";
		int beginIndex = originalFilename.lastIndexOf(".");
		if(beginIndex > 0){
			suffix = originalFilename.substring(beginIndex);
		}
		String filename = UUID.randomUUID().toString() + suffix;
		
		// 用于保存上传的文件的对象
		File dest = new File(parentPath, filename);
		
		// 保存客户端上传的文件
		try {
			avatar.transferTo(dest);
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// 将文件的路径存储到数据表中
		String avatarPath = "/upload/"+filename;
		userService.updateAvatar(getUidFromSession(session), getUsernameFromSession(session), avatarPath);
		// 响应 OK, 头像路径
		return new JsonResult<>(SUCCESS, avatarPath);
	}
	
}

