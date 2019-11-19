
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月22日 上午11:23:09 

* 类说明 

*/

public class AccessDeniedException extends ServiceException{

	private static final long serialVersionUID = 4824127345066239432L;

	public AccessDeniedException() {
		super();
		
	}

	public AccessDeniedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccessDeniedException(String message) {
		super(message);
		
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
		
	}
	
	
}

