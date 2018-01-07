package oracle.java.s20180102.model;

import java.sql.Date;

public class ReservDto {
	private String memberId;
	private int gServNo;
	private int gNo;
	private String payCode;
	private Date reservDate;
	private Date tourDate;
	private String pay_yn;
	private int reMemSize;
	private String cancle_yn;
	private String success_yn;
	private String confirm;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getgServNo() {
		return gServNo;
	}
	public void setgServNo(int gServNo) {
		this.gServNo = gServNo;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public Date getReservDate() {
		return reservDate;
	}
	public void setReservDate(Date reservDate) {
		this.reservDate = reservDate;
	}
	public Date getTourDate() {
		return tourDate;
	}
	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}
	public String getPay_yn() {
		return pay_yn;
	}
	public void setPay_yn(String pay_yn) {
		this.pay_yn = pay_yn;
	}
	public int getReMemSize() {
		return reMemSize;
	}
	public void setReMemSize(int reMemSize) {
		this.reMemSize = reMemSize;
	}
	public String getCancle_yn() {
		return cancle_yn;
	}
	public void setCancle_yn(String cancle_yn) {
		this.cancle_yn = cancle_yn;
	}
	public String getSuccess_yn() {
		return success_yn;
	}
	public void setSuccess_yn(String success_yn) {
		this.success_yn = success_yn;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	
}	
