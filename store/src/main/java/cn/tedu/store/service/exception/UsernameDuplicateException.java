
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午5:32:08 

* 类说明 

*/

public class UsernameDuplicateException extends ServiceException{

	private static final long serialVersionUID = -1518513644351334930L;

	public UsernameDuplicateException() {
		super();
		
	}

	public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UsernameDuplicateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UsernameDuplicateException(String message) {
		super(message);
		
	}

	public UsernameDuplicateException(Throwable cause) {
		super(cause);
		
	}

	
}

