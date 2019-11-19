
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月15日 下午1:32:48 

* 类说明 

*/

public class UpdateFaultException extends ServiceException{

	private static final long serialVersionUID = -4544713582165993020L;

	public UpdateFaultException() {
		super();
		
	}

	public UpdateFaultException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UpdateFaultException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UpdateFaultException(String message) {
		super(message);
		
	}

	public UpdateFaultException(Throwable cause) {
		super(cause);
		
	}

	
	
}

