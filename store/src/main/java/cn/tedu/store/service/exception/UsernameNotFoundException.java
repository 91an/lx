
package cn.tedu.store.service.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月14日 下午7:12:12 

* 类说明 

*/

public class UsernameNotFoundException extends ServiceException{

	private static final long serialVersionUID = 6190577024562206571L;

	public UsernameNotFoundException() {
		super();
		
	}

	public UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UsernameNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UsernameNotFoundException(String message) {
		super(message);
		
	}

	public UsernameNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
}

