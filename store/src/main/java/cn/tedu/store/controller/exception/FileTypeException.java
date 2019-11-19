
package cn.tedu.store.controller.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月17日 下午4:37:24 

* 类说明 

*/

public class FileTypeException extends FileUploadException{

	private static final long serialVersionUID = -6548231635179857646L;

	public FileTypeException() {
		super();
		
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileTypeException(String message) {
		super(message);
		
	}

	public FileTypeException(Throwable cause) {
		super(cause);
		
	}
	
	
}

