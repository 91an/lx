
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午5:32:25 

* 类说明 

*/

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 3479587231040893413L;

	public ServiceException() {
		super();
		
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ServiceException(String message) {
		super(message);
		
	}

	public ServiceException(Throwable cause) {
		super(cause);
		
	}
	
	

}

