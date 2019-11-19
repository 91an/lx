
package cn.tedu.store.controller.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月17日 下午4:36:29 

* 类说明 

*/

public class FileSizeException extends FileUploadException{

	private static final long serialVersionUID = 6923008785572628520L;

	public FileSizeException() {
		super();
		
	}

	public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FileSizeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileSizeException(String message) {
		super(message);
		
	}

	public FileSizeException(Throwable cause) {
		super(cause);
		
	}
	
	
	
}

