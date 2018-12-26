package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Component
public class MyAspect {
	
	//https://stackoverflow.com/questions/10247116/spring-aop-pointcut-for-annotated-argument
	
	@Pointcut("execution(* javax.servlet.http.HttpServletResponse.sendError(..)) && args(sc,msg) ")
	public void someMethod(int sc, String msg){
	}
	
	@Around("someMethod(sc,msg)")
	//@SuppressAjWarnings({"adviceDidNotMatch"})
	public void otherMethod(ProceedingJoinPoint pjp, int sc, String msg) throws Throwable{
		
		System.out.println("AspectJ: " + pjp.toLongString() + " Error Code: "+ sc+ " ErrorMessage: " + msg);
				
		Object[] args = pjp.getArgs();
		
	    for (int i = 0; i < args.length; i++) {
	        if (args[i].equals(sc)) {
	            if(sc==401)
	            	args[i] = 403;
	        }
	    }
	    
	    pjp.proceed(args);
	    
	}

}
