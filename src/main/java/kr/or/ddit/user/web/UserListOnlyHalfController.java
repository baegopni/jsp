package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.UserDao;
import util.MybatisUtil;

@WebServlet("/userListOnlyHalf")
public class UserListOnlyHalfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession sqlSession;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MybatisUtil.getSession();
		UserDao userDao = new UserDao();
		List<User> userListOnlyHalf= userDao.getUserListOnlyHalf(sqlSession);
		sqlSession.close();
		
		request.setAttribute("userListOnlyHalf", userListOnlyHalf);
		request.getRequestDispatcher("/user/userListOnlyHalf.jsp").forward(request, response);
	}

}
