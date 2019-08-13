package kr.or.ddit.lprod.model;

public class LprodVo {
	private String lprodId;
	private String lprodGu;
	private String lprodNm;
	
	
	public String getLprodId() {
		return lprodId;
	}
	public void setLprodId(String lprodId) {
		this.lprodId = lprodId;
	}
	public String getLprodGu() {
		return lprodGu;
	}
	public void setLprodGu(String lprodGu) {
		this.lprodGu = lprodGu;
	}
	public String getLprodNm() {
		return lprodNm;
	}
	public void setLprodNm(String lprodNm) {
		this.lprodNm = lprodNm;
	}
	
	@Override
	public String toString() {
		return "LprodVo [lprodId=" + lprodId + ", lprodGu=" + lprodGu + ", lprodNm=" + lprodNm + "]";
	}
	
	
}
