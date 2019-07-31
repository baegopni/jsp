package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 1. J2EE 기반의 웹 어플리케이션 개발시 main method를 통해 실행하지 않는다.
 2. 우리가 작성한 웹 어플리케이션을(war) was(tomcat)의 webapps 폴더 밑에 이동을 시켜주면
 	서버가 기동할때 해당 어플리케이션을 자동으로 로딩
 3. 웹 어플리케이션의 폴더 명이 context path가 된다(웹 어플리케이션 이름)
 4. 서버 설정에 의해서 폴더명과 다른 context path를 부여하는게 가능
 	(하지만 우리는 서버 엔지니어가 아니기 때문에 해당 부분까지는 가진 않는다.)
 	
 5. 특정 url을 호출하면, url을 처리해줄수 있는 servlet을 호출하여 응답을 생성한다
 6. servlet 생성방법
 	(1)class를 생성 ->
 	(2)HttpServlet 클래스를 상속한다(J2EE spec을 따른다) ->
 	(3)어떤 url을 해당 서블릿에서 처리할지 매핑 ->
 	   (web.xml, servlet 3.0이후 부터는  servlet class 어노테이션으로 설정)
 	 
*/
public class HelloServlet extends HttpServlet{
	
	private Logger logger = LoggerFactory.getLogger(HelloServlet.class);
	
	
	@Override
	public void init() throws ServletException {
//		System.out.println("HelloServlet init()");
		logger.debug("HelloServlet init()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>helloServlet</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<h1>hello, world. 안녕ㅎ</h1>");
		pw.write("	</body>");
		pw.write("</html>");
	}
	
}
