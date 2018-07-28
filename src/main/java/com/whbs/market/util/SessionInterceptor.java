/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
public class SessionInterceptor implements HandlerInterceptor{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		// 不拦击if里面内容
		if (request.getRequestURI().equals("/login")||request.getRequestURI().equals("/index")
				||request.getRequestURI().equals("/")||request.getRequestURI().equals("/search")
				||request.getRequestURI().equals("/show/**")||request.getRequestURI().equals("/about")
				||request.getRequestURI().equals("/registerFrom")||request.getRequestURI().equals("/register")
				||request.getRequestURI().equals("/phonePassword")||request.getRequestURI().equals("/phoneAndPassword")
				||request.getRequestURI().equals("/findPas")
				) {
			return true;
		}
		if (request.getRequestURI().equals("/error")) {
			response.sendRedirect("http://www.auceo.cn/static/404.png");
			return false;
		}
		Object object2=request.getSession().getAttribute("user");
		if (object2==null) {
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}

}
