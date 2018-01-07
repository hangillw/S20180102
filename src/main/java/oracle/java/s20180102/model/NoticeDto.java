package oracle.java.s20180102.model;

import java.sql.Date;

public class NoticeDto {
	private int noticeNo;
	private String nTitle;
	private String nContent;
	private String nImg;
	private int nReadCount;
	private Date nCredate;
	
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnImg() {
		return nImg;
	}
	public void setnImg(String nImg) {
		this.nImg = nImg;
	}
	public int getnReadCount() {
		return nReadCount;
	}
	public void setnReadCount(int nReadCount) {
		this.nReadCount = nReadCount;
	}
	public Date getnCredate() {
		return nCredate;
	}
	public void setnCredate(Date nCredate) {
		this.nCredate = nCredate;
	}
	
	
}
