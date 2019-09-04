package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectLocale")
public class SelectLocaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locale = request.getParameter("locale");
		if(locale==null) locale = "ko";
		request.setAttribute("locale", locale);
		
		//추가 코드가 필요하면 작업하기
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
		
	}
}
