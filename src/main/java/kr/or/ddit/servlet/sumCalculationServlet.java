package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sumCalculation")
public class sumCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		int num = 0;
		if(start<end) {
			for(int i= start; i<=end; i++) {
				num += i;
			}
		}else {
			for(int i= end; i<=start; i++) {
				num += i;
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", num);
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}

}
