package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {
	/**
	 * 
	 * Method   : test
	 * 작성자 : PC-19
	 * 변경이력 :  
	 * Method 설명 :
	 */
	@Test
	public void test() {
		/***Given***/
		String cookieString = "userId=brown; rememberMe=Y; test=testValue";
		
		/***When***/
		String userIdCookieValue = CookieUtil.getCookie(cookieString, "userId");
		String rememberMeCookieValue = CookieUtil.getCookie(cookieString, "rememberMe");
		String testCookieValue = CookieUtil.getCookie(cookieString, "test");
		String notExistsCookieValue = CookieUtil.getCookie(cookieString, "notExists");
		
		
		/***Then***/
		assertEquals("brown", userIdCookieValue);
	}

}
