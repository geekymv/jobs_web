package com.heike.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.heike.base.SysCode;
import com.heike.domain.pojo.Employer;


/**
 * 用工单位身份验证
 * @author Geek_ymv
 */
public class EmployerInterceptor implements HandlerInterceptor {
	/**
	 * 不要要拦截的url
	 */
	private List<String> excludeUrls;
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		System.out.println("uri = " + uri);
		
		if(excludeUrls != null){
			for (String excludeUrl : excludeUrls) {
				if(uri.endsWith(excludeUrl) || uri.contains("/resources/")) {
					System.out.println("url 不需要拦截...");
					return true;
				}
			}
		}
		
		HttpSession session =  request.getSession();
		Object obj = session.getAttribute("user");
		
		if(obj == null) {
			System.out.println("session拦截木有通过...");
			
			String contextPath = request.getContextPath();
//			System.out.println("contextPath = " + contextPath);
			response.sendRedirect(contextPath); // 跳转到/ccms
			
			return false;
		}else {
			System.out.println("session拦截通过...");
			if(obj instanceof Employer) { 
				Employer e = (Employer)obj;
				if(SysCode.EmployerCode.ADMIN_AUTHORITY == e.getAuthority()) { 	// 管理员
					return true;
				}
			}
			
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath); // 跳转到/jobs
			
			return false;
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}


}

















