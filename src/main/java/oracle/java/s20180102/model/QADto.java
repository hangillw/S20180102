package oracle.java.s20180102.model;

import java.sql.Date;

public class QADto {
	private String memberId;
	private int gServNo;
	private int QAnumber;
	private String QAreceiver;
	private String QAtitle;
	private String QAcontent;
	private Date QAcredate;
	private int QAstep;
	private String QAcomplete;
	
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
	public int getQAnumber() {
		return QAnumber;
	}
	public void setQAnumber(int qAnumber) {
		QAnumber = qAnumber;
	}
	public String getQAreceiver() {
		return QAreceiver;
	}
	public void setQAreceiver(String qAreceiver) {
		QAreceiver = qAreceiver;
	}
	public String getQAtitle() {
		return QAtitle;
	}
	public void setQAtitle(String qAtitle) {
		QAtitle = qAtitle;
	}
	public String getQAcontent() {
		return QAcontent;
	}
	public void setQAcontent(String qAcontent) {
		QAcontent = qAcontent;
	}
	public Date getQAcredate() {
		return QAcredate;
	}
	public void setQAcredate(Date qAcredate) {
		QAcredate = qAcredate;
	}
	public int getQAstep() {
		return QAstep;
	}
	public void setQAstep(int qAstep) {
		QAstep = qAstep;
	}
	public String getQAcomplete() {
		return QAcomplete;
	}
	public void setQAcomplete(String qAcomplete) {
		QAcomplete = qAcomplete;
	}
	
	
}
