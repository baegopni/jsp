package login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		logger.debug("userId : {}", userId);
		logger.debug("password : {}", pass);
		
		//사용자가 입력한 계정정보와 DB에 있는 값이랑 비교
		//DB에서 조회해온 사용자 정보라고 가정하자.
		UserVo userVo = new UserVo();
		userVo.setUserNm("브라운");
		userVo.setUserId("brown");
		userVo.setPass("brown1234");
		
		//사용자가 입력한 파라미터 정보와 DB에서 조회해온 값이 동일할 경우 --> webapp/main.jsp
		//사용자가 입력한 파라미터 정보와 DB에서 조회해온 값이 다를 경우 --> webapp/login/login.jsp
		
		if(userId.equals(userVo.getUserId()) && pass.equals(userVo.getPass())) {
			HttpSession session = request.getSession();
			logger.debug("session.getId() : {}", session.getId());
			session.setAttribute("S_USERVO", userVo);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {
			//forward의 경우 request, response객체를 공유
			//request method도 같이 공유
			//request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			//request.setAttribute("userId", userId);
			doGet(request, response);
		}
	}

}
