package com.pub.sms.model;

import java.sql.Date;

public class SmsChaReply {
	private int rep_no; 
	private int cha_no; 
	private String cha_re_cont; // varchar2(255)
	private int mem_no;
	private Date regdate; //올린날짜
	private Date updatedate; //수정날짜 
	private String del; //삭제여부
	//nickname
	private String nickname;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRep_no() {
		return rep_no;
	}
	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}
	public int getCha_no() {
		return cha_no;
	}
	public void setCha_no(int cha_no) {
		this.cha_no = cha_no;
	}
	public String getCha_re_cont() {
		return cha_re_cont;
	}
	public void setCha_re_cont(String cha_re_cont) {
		this.cha_re_cont = cha_re_cont;
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
