
package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月28日 下午5:12:56 

* 类说明 

*/
@Component
@Aspect
public class TimerAspect {
	// .*.*(..)  .*所有类的  .*所有方法(..为所有参数)
	@Around("execution(* cn.tedu.store.service.impl.*.*(..)")
	public void a(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		// 执行连接点方法，即调用业务中的某个方法
		pjp.proceed();
		long end = System.currentTimeMillis();
		System.err.println("执行耗时：" + (end - start));
	}
}

