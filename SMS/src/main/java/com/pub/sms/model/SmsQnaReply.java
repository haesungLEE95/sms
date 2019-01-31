package com.pub.sms.model;

import java.sql.Date;

public class SmsQnaReply {
    private int qna_rep;          
    private int qna_no;          
    private String qna__re_cont;     
    private int mem_no;          
    private Date regdate;         
    private Date updatedate;     
    private String del;
	//nickname
	private String nickname;
    
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getQna_rep() {
		return qna_rep;
	}
	public void setQna_rep(int qna_rep) {
		this.qna_rep = qna_rep;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna__re_cont() {
		return qna__re_cont;
	}
	public void setQna__re_cont(String qna__re_cont) {
		this.qna__re_cont = qna__re_cont;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}           
    
}