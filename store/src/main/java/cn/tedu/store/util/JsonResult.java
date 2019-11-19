
package cn.tedu.store.util;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月14日 下午2:16:31 

* 类说明 
 * @param <T>
 * 封装服务器端向客户端响应的结果

*/

public class JsonResult<T> {
	private Integer state;
	private String message;
	private T data;
	
	public JsonResult() {
		super();
	}
	
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}

	public JsonResult(Throwable e) {
		super();
		this.message = e.getMessage();
	}
	

	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	
}

