package kr.or.ddit.util;

public class CookieUtil {
	/**
	 * 
	 * Method   : getCookie
	 * 작성자 : PC-19
	 * 변경이력 : 
	 * @param cookieString
	 * @param string
	 * @return 
	 * Method 설명 : 쿠키 문자열로부터 특정 쿠키의 값을 반화한다
	 */
	
	public static String getCookie(String cookieString, String cookieId) {
		
		String cookies[] = cookieString.split("; ");
		
		for(int i=0; i<cookies.length; i++) {
			String cookies2[] = cookies[i].split("=");
			if(cookieId.equals(cookies2[0])){
				return cookies2[1];
			}	
		}
		return null;
	}

}
