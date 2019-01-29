package com.pub.sms.model;
import java.sql.Date;

public class SmsReqReply {
	private int rq_no;
	private int rq_re_no;
	private String rq_re_cont;
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
	public int getRq_no() {
		return rq_no;
	}
	public void setRq_no(int rq_no) {
		this.rq_no = rq_no;
	}
	public int getRq_re_no() {
		return rq_re_no;
	}
	public void setRq_re_no(int rq_re_no) {
		this.rq_re_no = rq_re_no;
	}
	public String getRq_re_cont() {
		return rq_re_cont;
	}
	public void setRq_re_cont(String rq_re_cont) {
		this.rq_re_cont = rq_re_cont;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
}
