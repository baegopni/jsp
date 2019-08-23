package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	private String userNm; //사용자 이름
	private String pass;
	private String userId;
	private String alias;  //별명
	private Date reg_dt;	//등록일
	private String addr1;	//주소1
	private String addr2;	//주소2
	private String zipcode;	//우편번호
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	//생성자
	public User() {
		
	}
	
	//생성자
	public User(String userNm) {
		this.userNm = userNm;
	}

	
	public User(String userId, String userNm, String alias, Date reg_dt, String addr1, String addr2,
			String zipcode, String pass) {
		this.userId = userId;
		this.userNm = userNm;
		this.alias = alias;
		this.reg_dt = reg_dt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.pass = pass;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getReg_dt() {
		return reg_dt;
	}
	
	public String getReg_dt_fmt() {
		logger.debug("getReg_dt_fmt method call");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
	} 

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean checkLoginValidate(String userId, String pass) {
		if(userId.equals(this.userId) && pass.equals(this.pass))
			return true;
		
		return false;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	//toString
	@Override
	public String toString() {
		return "User [userNm=" + userNm + ", pass=" + pass + ", userId=" + userId + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + "]";
	}
	

	
}
