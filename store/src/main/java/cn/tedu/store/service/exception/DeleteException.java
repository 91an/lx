
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月22日 下午6:23:52 

* 类说明 

*/

public class DeleteException extends ServiceException{

	private static final long serialVersionUID = 4443953246778514588L;

	public DeleteException() {
		super();
		
	}

	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DeleteException(String message) {
		super(message);
		
	}

	public DeleteException(Throwable cause) {
		super(cause);
		
	}
	
	

}

