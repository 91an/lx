
package cn.tedu.store.controller.exception;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月17日 下午4:34:55 

* 类说明 

*/

public class FileEmptyException extends FileUploadException{

	private static final long serialVersionUID = 7473259255005119050L;

	public FileEmptyException() {
		super();
		
	}

	public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public FileEmptyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileEmptyException(String message) {
		super(message);
		
	}

	public FileEmptyException(Throwable cause) {
		super(cause);
		
	}
	
	
	

}

