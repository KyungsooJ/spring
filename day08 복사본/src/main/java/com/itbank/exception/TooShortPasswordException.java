package com.itbank.exception;

public class TooShortPasswordException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int length;
	
	public TooShortPasswordException(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		String msg = "비밀번호가 너무 짧습니다 : " + length;
		return msg;
	}

}
