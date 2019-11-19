
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月14日 下午7:15:40 

* 类说明 

*/

public class PasswordFaultException extends ServiceException{

	private static final long serialVersionUID = 1131411604383919509L;

	public PasswordFaultException() {
		super();
		
	}

	public PasswordFaultException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PasswordFaultException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PasswordFaultException(String message) {
		super(message);
		
	}

	public PasswordFaultException(Throwable cause) {
		super(cause);
		
	}
	
	
	

}

