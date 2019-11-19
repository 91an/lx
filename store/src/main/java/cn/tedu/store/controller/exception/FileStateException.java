
package cn.tedu.store.controller.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月17日 下午4:39:12 

* 类说明 

*/

public class FileStateException extends FileUploadException{

	private static final long serialVersionUID = 8437252966192994436L;

	public FileStateException() {
		super();
		
	}

	public FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FileStateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileStateException(String message) {
		super(message);
		
	}

	public FileStateException(Throwable cause) {
		super(cause);
		
	}

	
}

