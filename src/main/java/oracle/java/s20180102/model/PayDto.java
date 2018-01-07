package oracle.java.s20180102.model;

public class PayDto {
	private String payCode;
	private String memberId;
	private int gServNo;
	private int amount;
	private String pay_method;
	private String buyer_name;
	private String buyer_email;
	private String buyer_tel;
	private String buyer_addr;
	private String buyer_postCode;
	private String pComplete;
	
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_email() {
		return buyer_email;
	}
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	public String getBuyer_tel() {
		return buyer_tel;
	}
	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}
	public String getBuyer_addr() {
		return buyer_addr;
	}
	public void setBuyer_addr(String buyer_addr) {
		this.buyer_addr = buyer_addr;
	}
	public String getBuyer_postCode() {
		return buyer_postCode;
	}
	public void setBuyer_postCode(String buyer_postCode) {
		this.buyer_postCode = buyer_postCode;
	}
	public String getpComplete() {
		return pComplete;
	}
	public void setpComplete(String pComplete) {
		this.pComplete = pComplete;
	}
	
	
}
