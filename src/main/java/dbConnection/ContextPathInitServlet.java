package dbConnection;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextPathInitServlet")
public class ContextPathInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
