
package cn.tedu.store.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.store.interceptor.LoginInterceptor;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月16日 上午9:22:42 

* 类说明 

*/
@Configuration
public class LoginInterceptorConfigruation implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor = new LoginInterceptor();
		
		List<String> patterns = new ArrayList<>();
		patterns.add("/users/reg");
		patterns.add("/users/login");
		patterns.add("/web/register.html");
		patterns.add("/web/login.html");
		patterns.add("/css/**");
		patterns.add("/js/**");
		patterns.add("/images/**");
		patterns.add("/bootstrap3/**");
		patterns.add("/district/**");
		patterns.add("/products/**");
		patterns.add("/web/index.html");
		patterns.add("/web/product.html");
		
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
	}
}

