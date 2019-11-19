
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月25日 下午10:06:47 

* 类说明 

*/

public class CartNotFoundException extends ServiceException{

	private static final long serialVersionUID = -1445408879848594743L;

	public CartNotFoundException() {
		super();
		
	}

	public CartNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CartNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CartNotFoundException(String message) {
		super(message);
		
	}

	public CartNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
	

}

