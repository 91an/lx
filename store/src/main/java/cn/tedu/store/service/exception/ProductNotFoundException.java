
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月24日 下午3:59:34 

* 类说明 

*/

public class ProductNotFoundException extends ServiceException{

	
	private static final long serialVersionUID = -7669243976559815146L;

	public ProductNotFoundException() {
		super();
		
	}

	public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ProductNotFoundException(String message) {
		super(message);
		
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);
		
	}
	

}

