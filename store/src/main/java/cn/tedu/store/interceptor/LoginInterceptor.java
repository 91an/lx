
package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/** 
 * @author 作者 Your-Name: Bard
 * @version 创建时间：2019年10月16日 上午9:09:08 

 * 类说明 
 * 拦截未登录的请求的拦截器

 */

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("uid") == null){
			response.sendRedirect("/web/login.html");
			return false;
		}
		return true;
	}


}

