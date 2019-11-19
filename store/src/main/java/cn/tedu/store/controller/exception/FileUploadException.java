
package cn.tedu.store.controller.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月17日 下午4:34:04 

* 类说明 

*/

public class FileUploadException extends RuntimeException{

	private static final long serialVersionUID = 1354479758321480990L;

	public FileUploadException() {
		super();
		
	}

	public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileUploadException(String message) {
		super(message);
		
	}

	public FileUploadException(Throwable cause) {
		super(cause);
		
	}
	
	
}

