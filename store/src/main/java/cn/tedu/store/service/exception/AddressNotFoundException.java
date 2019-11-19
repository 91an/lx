
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月22日 上午11:21:16 

* 类说明 

*/

public class AddressNotFoundException extends ServiceException{

	private static final long serialVersionUID = -3400551490425826026L;

	public AddressNotFoundException() {
		super();
		
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddressNotFoundException(String message) {
		super(message);
		
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
}

