package demo.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SpringBootHandleInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
      
	  System.out.println("[preHandle calling][" + request.getMethod() + "]" 
			  + request.getRequestURI());
      return true;
   }
   
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
      Object handler, ModelAndView modelAndView) throws Exception {
      
	  System.out.println("[postHandle calling][" + request.getMethod() + "]" 
			  + request.getRequestURI());
   }
   
   @Override
   public void afterCompletion
      (HttpServletRequest request, HttpServletResponse response, Object 
      handler, Exception exception) throws Exception {
      
	  System.out.println("[afterCompletion][" + request.getMethod() + "]" 
			  + request.getRequestURI() + " [exception: " + exception + "]");
	  
      System.out.println("Request and Response is completed");
   }
}