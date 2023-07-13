package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.controller.MemberController;

// MemberController 에서 발생하는 예외만 별도로 처리하는 클래스 (스프링 빈)

@ControllerAdvice(assignableTypes = MemberController.class)
public class MemberControllerAdvice {

	@ExceptionHandler(TooShortPasswordException.class)
	public ModelAndView tooShortPassword(TooShortPasswordException e) {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", e.toString());
		return mav;
	}
}
