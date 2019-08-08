package kr.or.ddit.user.model;

public class User {
	private String userNm; //사용자 이름
	private String pass;
	private String userId;
	
	//생성자
	public User() {
		
	}
	
	//생성자
	public User(String userNm) {
		this.userNm = userNm;
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

	@Override
	public String toString() {
		return "UserVo [userNm=" + userNm + ", pass=" + pass + ", userId=" + userId + "]";
	}
	
	public boolean checkLoginValidate(String userId, String pass) {
		if(userId.equals(this.userId) && pass.equals(this.pass))
			return true;
		
		return false;
	}
	

	
}
