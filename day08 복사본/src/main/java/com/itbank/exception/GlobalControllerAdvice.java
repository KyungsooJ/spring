package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 현재 프로젝트 내부의 모든 컨트롤러에서 발생하는 예외를 처리하는 클래스 (스프링 빈)

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView npe(NullPointerException e) {
		
		e.printStackTrace();
		
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", "서버에서 오류가 발생했습니다");
		mav.addObject("url", "/");
		return mav;
	}
}
