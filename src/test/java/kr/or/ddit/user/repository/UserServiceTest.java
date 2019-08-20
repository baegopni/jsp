package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import util.MybatisUtil;

public class UserServiceTest {
	private IUserService userService;
	
	@Before
	public void setup() {
		userService = new UserService();
	}
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		
	}
	
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
		
		/***When***/
		List<User> userList = userService.getUserList();
		
		/***Then***/ //기대하는 결과
		assertEquals(105, userList.size());
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

		/***When***/
		User user = userService.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", user.getUserNm());
		assertEquals("brown1234", user.getPass());
		
	}
	
	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/

		/***When***/
		List<User> userListOnlyHalf = userService.getUserListOnlyHalf();
		
		/***Then***/
		assertEquals(50, userListOnlyHalf.size());
	}

}
