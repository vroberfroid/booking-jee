package be.bo.user.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import be.bo.user.annotation.Logged;

@Logged
@Interceptor
public class LoggingInterceptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2811019129401571399L;

	@AroundInvoke
	public Object logMethodEntry(InvocationContext invocationContext) throws Exception {

		// Log for operation starting
		String className = invocationContext.getTarget().getClass().getName();
		String operation = className + '.' + invocationContext.getMethod().getName();
		Object[] params = invocationContext.getParameters();

		long startTime = System.currentTimeMillis();

		// Execute the operation
		Object result = invocationContext.proceed();

		long delta = System.currentTimeMillis() - startTime;

		System.out.println("*** Time spent in '" + operation + "' is " + delta + " ms");
		return result;

	}

}
