package com.pub.sms.model;

import java.sql.Date;

public class SmsQnA {
    private int sb_no;       
    private int mem_no;      
    private String qna_cont;   
    private Date qna_date;    
    private String sms_qna;    
    private int qna_no;     
    
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
