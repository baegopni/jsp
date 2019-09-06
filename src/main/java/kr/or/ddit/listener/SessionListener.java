package kr.or.ddit.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;

public class SessionListener implements HttpSessionAttributeListener {
	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//사용자가 정상적으로 로그인 했을 때 session에 추가되는 S_USERVO값은 기준으로
		// S_USERVO 속성이 세션에 추가 될 때 application객체에 사용자를 추가해서
		// 현재 접속한 사용자 리스트를 보여주는 화면을 개발
		String attrName = event.getName(); //session 추가된 속성 이름
		if(attrName.equals("S_USERVO")) {
			ServletContext sc = event.getSession().getServletContext();
			List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST");
			s_uservo_list.add((User) event.getValue());
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		//새롭게 변경된 사용자 세션 정보
		HttpSession session = (HttpSession) event.getSource();
		User user = (User) session.getAttribute("S_USERVO");
		//기존 세션 정보
		User oldUser = (User) event.getValue();
		
		ServletContext sc = event.getSession().getServletContext();
		List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST");
		
		
		s_uservo_list.remove(oldUser);
		s_uservo_list.add(user);
	}

}
