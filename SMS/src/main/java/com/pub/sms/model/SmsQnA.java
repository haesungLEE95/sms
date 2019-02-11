package com.pub.sms.model;

import java.sql.Date;

public class SmsQnA {
    private int sb_no;  //판매글번호     
    private int mem_no; //회원번호(작성자)     
    private String qna_cont;   
    private Date qna_date;    
    private String sms_qna; //제목   
    private int qna_no;     
	// paging용
	private int startRow;
	private int endRow;
	//닉네임용
	private String nickname;
	//판매회원조회용
	private int ssb_no;
	
	
	public int getSsb_no() {
		return ssb_no;
	}
	public void setSsb_no(int ssb_no) {
		this.ssb_no = ssb_no;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSms_qna() {
		return sms_qna;
	}
	public void setSms_qna(String sms_qna) {
		this.sms_qna = sms_qna;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public int getSb_no() {
		return sb_no;
	}
	public void setSb_no(int sb_no) {
		this.sb_no = sb_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getQna_cont() {
		return qna_cont;
	}
	public void setQna_cont(String qna_cont) {
		this.qna_cont = qna_cont;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
}
