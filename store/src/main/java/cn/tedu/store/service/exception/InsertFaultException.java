
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 下午5:37:21 

* 类说明 

*/

public class InsertFaultException extends ServiceException{

	private static final long serialVersionUID = 271157203493445867L;

	public InsertFaultException() {
		super();
		
	}

	public InsertFaultException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InsertFaultException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InsertFaultException(String message) {
		super(message);
		
	}

	public InsertFaultException(Throwable cause) {
		super(cause);
		
	}
	
}

