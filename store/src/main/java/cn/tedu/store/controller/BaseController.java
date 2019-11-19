
package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.store.controller.exception.FileEmptyException;
import cn.tedu.store.controller.exception.FileIOException;
import cn.tedu.store.controller.exception.FileSizeException;
import cn.tedu.store.controller.exception.FileStateException;
import cn.tedu.store.controller.exception.FileTypeException;
import cn.tedu.store.controller.exception.FileUploadException;
import cn.tedu.store.service.exception.AccessDeniedException;
import cn.tedu.store.service.exception.AddressCountBeyondException;
import cn.tedu.store.service.exception.AddressNotFoundException;
import cn.tedu.store.service.exception.InsertFaultException;
import cn.tedu.store.service.exception.PasswordFaultException;
import cn.tedu.store.service.exception.ProductNotFoundException;
import cn.tedu.store.service.exception.ServiceException;
import cn.tedu.store.service.exception.UpdateFaultException;
import cn.tedu.store.service.exception.UsernameDuplicateException;
import cn.tedu.store.service.exception.UsernameNotFoundException;
import cn.tedu.store.util.JsonResult;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月14日 下午3:38:05 

* 类说明 
* 控制器的基类

*/

public class BaseController {
	static final long AVATAR_MAXSIZE = 750*1024;
	static final int SUCCESS = 2000;
	static final int FAULT = 4000;

	@ExceptionHandler({ServiceException.class, FileUploadException.class})
	public JsonResult<Void> handleException(Throwable e){
		JsonResult<Void> json = new JsonResult<>(e);
		
		if (e instanceof UsernameDuplicateException){
			json.setState(FAULT);
		} else if (e instanceof InsertFaultException){
			json.setState(FAULT);
		} else if (e instanceof UsernameNotFoundException){
			json.setState(FAULT);
		} else if (e instanceof PasswordFaultException){
			json.setState(FAULT);
		} else if (e instanceof UpdateFaultException){
			json.setState(FAULT);
		} else if (e instanceof FileEmptyException){
			json.setState(FAULT);
		} else if (e instanceof FileIOException){
			json.setState(FAULT);
		} else if (e instanceof FileTypeException){
			json.setState(FAULT);
		} else if (e instanceof FileStateException){
			json.setState(FAULT);
		} else if (e instanceof FileSizeException){
			json.setState(FAULT);
		} else if (e instanceof AccessDeniedException){
			json.setState(FAULT);
		} else if (e instanceof AddressCountBeyondException){
			json.setState(FAULT);
		} else if (e instanceof AddressNotFoundException){
			json.setState(FAULT);
		} else if (e instanceof ProductNotFoundException){
			json.setState(FAULT);
		} 
			
		return json;
	}
	
	protected Integer getUidFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
	protected String getUsernameFromSession(HttpSession session){
		return session.getAttribute("username").toString();
	}
}

