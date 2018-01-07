package oracle.java.s20180102.model;

import java.sql.Date;

public class SearchDto {
	private String srch_title;
	private Date srch_date;
	
	public String getSrch_title() {
		return srch_title;
	}
	public void setSrch_title(String srch_title) {
		this.srch_title = srch_title;
	}
	public Date getSrch_date() {
		return srch_date;
	}
	public void setSrch_date(Date srch_date) {
		this.srch_date = srch_date;
	}
	
	
}
