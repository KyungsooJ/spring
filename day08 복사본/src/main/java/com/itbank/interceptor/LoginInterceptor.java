package com.itbank.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	// 스프링에서 제공하는 인터셉터 클래스를 상속하여 오버라이딩으로 구성한다
	// handler : 컨트롤러
	@Override		// 컨트롤러에 요청이 도달하기 전에 가로채서 수행하는 내용
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		System.out.println("handler : " + handler);
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null) {	// 세션에 로그인이 있으면
			System.out.println("로그인 되어있으므로 handler로 넘겨서 예정된 처리를 계속 진행한다");
			return true;							// true를 반환 (계속 진행해도 좋다)
		}
		String requestURL = request.getRequestURL().toString();
		System.out.println("원래 이동하려 했던 주소 : " + requestURL);
		requestURL = URLEncoder.encode(requestURL, "UTF-8");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/member/login?url=" + requestURL);
		System.out.println("로그인되어있지 않아서, 예정된 처리를 중단하고 로그인 페이지로 이동시킨다");
		return false;	// handler에게 넘기지 않고 인터셉터가 직접 응답을 만들어서 전송한다
						// 응답은 이중으로 클라이언트에게 넘어가면 안된다
	}
	
	@Override		// 컨트롤러에서 처리된 후 요청을 가로챈다
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}
	
	@Override		// view가 클라이언트에게 전달된 후 처리한다
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion\n");
	}

}
