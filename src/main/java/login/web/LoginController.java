package login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import util.MybatisUtil;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private static final long serialVersionUID = 1L;
 
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	
	/**
	 * 
	 * Method   : doGet
	 * 작성자 : PC-19
	 * 변경이력 : 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException 
	 * Method 설명 : 로그인 화면 요청 처리(forward)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//웹브라우저가 보낸 cookie 확인
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
						for(Cookie cookie : cookies) {
				logger.debug("cookie name : {}, cookie value : {}", 
						cookie.getName(), cookie.getValue());	
			}
		}
		
		//응답을 생성할때 웹브라우저에게 쿠키를 저장할것을 지시
		Cookie cookie = new Cookie("serverGen", "serverValue");
		cookie.setMaxAge(60*60*24*7); //7일의 유효기간을 갖는 쿠키
		//60초->60분->24시간->7일
		
		response.addCookie(cookie);
		
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		String remember = request.getParameter("remember");
		
		manageUserIdCookie(response, userId, remember);
		
		
		logger.debug("userId : {}", userId);
		logger.debug("password : {}", pass);
		
		//사용자가 입력한 계정정보와 DB에 있는 값이랑 비교
		//DB에서 조회해온 사용자 정보라고 가정하자.
//		IUserDao userDao = new UserDao(); 위에 오버라이드
		SqlSession sqlSession = MybatisUtil.getSession();
		User user = userService.getUser(userId);
		
		//사용자가 입력한 파라미터 정보와 DB에서 조회해온 값이 동일할 경우 --> webapp/main.jsp
		//사용자가 입력한 파라미터 정보와 DB에서 조회해온 값이 다를 경우 --> webapp/login/login.jsp
		
		//DB에 존재하지 않는 사용자 체크 --> 로그인 화면으로 이동
		if(user == null)
			doGet(request, response);
		
		else if(user.checkLoginValidate(userId, pass)) {
			
			HttpSession session = request.getSession();
			logger.debug("session.getId() : {}", session.getId());
			session.setAttribute("S_USERVO", user);
			request.setAttribute("elTest", "elTestValue");
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {
			//forward의 경우 request, response객체를 공유
			//request method도 같이 공유
			//request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			//request.setAttribute("userId", userId);
			doGet(request, response);
		}
	}

	private void manageUserIdCookie(HttpServletResponse response, String userId, String remember) {
		//remember 파라미터가 존재할 경우 userId를 cookie로 생성
		Cookie cookie = new Cookie("userId", userId);
		if(remember != null) {
			cookie.setMaxAge(60*60*24*30); //30일
		}else {
			cookie.setMaxAge(0); //삭제
		}
		response.addCookie(cookie);
	}

}
