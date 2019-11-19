
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月18日 下午4:37:00 

* 类说明 

*/

public class AddressCountBeyondException extends RuntimeException{

	private static final long serialVersionUID = 4755241298669141880L;

	public AddressCountBeyondException() {
		super();
		
	}

	public AddressCountBeyondException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AddressCountBeyondException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddressCountBeyondException(String message) {
		super(message);
		
	}

	public AddressCountBeyondException(Throwable cause) {
		super(cause);
		
	}
	
	

}

