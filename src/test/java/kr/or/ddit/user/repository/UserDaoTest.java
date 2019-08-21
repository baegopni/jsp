package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import util.MybatisUtil;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IUserDao userDao;
	private SqlSession sqlSession;
	
	//junit 테스트 메소드 실행 순서
	//@Before -> @Test -> @After
	//@Test 테스트 메소드가 실행되기전에 @Before이 적용된 메소드를 먼저 실행하고,
	//@Test 메소드 실행후에 @After이 적용된 메소드를 실행한다
	
	
	//테스트에 공통적으로 필요한 자원을 생성/초기화
	@Before
	public void setup() {
		logger.debug("before");
		userDao = new UserDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		logger.debug("after");
		sqlSession.close();
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
		List<User> userList = userDao.getUserList(sqlSession);
		
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
		User user = userDao.getUser(sqlSession, userId);
		
		/***Then***/
		assertEquals("브라운", user.getUserNm());
		assertEquals("brown1234", user.getPass());
		
	}
	
	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/

		/***When***/
		List<User> userListOnlyHalf = userDao.getUserListOnlyHalf(sqlSession);
		
		/***Then***/
		assertEquals(50, userListOnlyHalf.size());
	}
	
	
	/**
	 * 
	 * Method   : getUserPagingList
	 * 작성자 : PC-19
	 * 변경이력 : 
	 * @param sqlSession
	 * @param page
	 * @return 
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);

		/***When***/
		List<User> userList = userDao.getUserPagingList(sqlSession, page);
		
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
	}
	
	@Test
	public void getUserTotalCnt() {
		/***Given***/
		

		/***When***/
		int totalCnt = userDao.getUserTotalCnt(sqlSession);
		
		/***Then***/
		assertEquals(105, totalCnt);
	}

}
