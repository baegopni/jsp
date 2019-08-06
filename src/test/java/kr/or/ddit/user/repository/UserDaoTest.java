package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {
	/**
	 * 
	 * Method   : getUserListTest
	 * 작성자 : PC-19
	 * 변경이력 :  
	 * Method 설명 : getUserList테스트
	 */
	@Test
	public void getUserListTest() {
		/***Given***/ //내가 주어진 상황
		IUserDao userDao = new UserDao();
		
		/***When***/
		List<UserVo> userList = userDao.getUserList();
		
		/***Then***/ //기대하는 결과
		assertEquals(5, userList.size());
	}
	
	/**
	 * 
	 * Method   : getUserTest
	 * 작성자 : PC-19
	 * 변경이력 :  
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		IUserDao userDao = new UserDao();

		/***When***/
		UserVo userVo = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		assertEquals("brown1234", userVo.getPass());
		
	}

}
