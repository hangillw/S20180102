package oracle.java.s20180102.model;

import java.sql.Date;

public class GuideDto {
	private String memberId;
	private int gNo;
	private String gImg;
	private String gTel;
	private String kakaoId;
	private String gInfo;
	private String gPage;
	private Date gCredate;
	private String gAccount;
	private int gGrade;
	private int totalCost;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public String getgImg() {
		return gImg;
	}
	public void setgImg(String gImg) {
		this.gImg = gImg;
	}
	public String getgTel() {
		return gTel;
	}
	public void setgTel(String gTel) {
		this.gTel = gTel;
	}
	public String getKakaoId() {
		return kakaoId;
	}
	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}
	public String getgInfo() {
		return gInfo;
	}
	public void setgInfo(String gInfo) {
		this.gInfo = gInfo;
	}
	public String getgPage() {
		return gPage;
	}
	public void setgPage(String gPage) {
		this.gPage = gPage;
	}
	public Date getgCredate() {
		return gCredate;
	}
	public void setgCredate(Date gCredate) {
		this.gCredate = gCredate;
	}
	public String getgAccount() {
		return gAccount;
	}
	public void setgAccount(String gAccount) {
		this.gAccount = gAccount;
	}
	public int getgGrade() {
		return gGrade;
	}
	public void setgGrade(int gGrade) {
		this.gGrade = gGrade;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}
