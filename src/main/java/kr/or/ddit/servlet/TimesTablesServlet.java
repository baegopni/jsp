package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimesTablesServlet extends HttpServlet{
	
	
	private static final Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("TimesTablesServlet doGet()");
		
		String method = req.getMethod();
		
		logger.trace("trace TimesTablesServlet doGet()");
		logger.debug("debug TimesTablesServlet doGet() {} {} {} ", method, method+"test");
		logger.info("info TimesTablesServlet doGet()");
		logger.warn("warn TimesTablesServlet doGet()");
		logger.error("error TimesTablesServlet doGet()");
		
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("<head>");
		pw.write("</head>");
		pw.write("	<body>");
		pw.write("<table border=1>");
		
		for(int j=1; j<10; j++) {
			pw.write("<tr>");
			for(int i=2; i<10; i++) {
				pw.write("<td>" + i + "*" + j + "=" + (j*i) + "</td>");
			}
			pw.write("</tr>");
		}
			
			
		pw.write("</table>");
		pw.write("  </body>");
		pw.write("</html>");
	}
}
