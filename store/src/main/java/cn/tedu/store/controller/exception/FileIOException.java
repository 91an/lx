
package cn.tedu.store.controller.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月17日 下午4:39:56 

* 类说明 

*/

public class FileIOException extends FileUploadException{

	private static final long serialVersionUID = -2779902105960805918L;

	public FileIOException() {
		super();
		
	}

	public FileIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FileIOException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileIOException(String message) {
		super(message);
		
	}

	public FileIOException(Throwable cause) {
		super(cause);
		
	}
	
	

}

