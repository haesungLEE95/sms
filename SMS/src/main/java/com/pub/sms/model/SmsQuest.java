package com.pub.sms.model;

import java.sql.Date;

public class SmsQuest {
    private int mem_no; 
    private int sb_no; 
    private Date qst_dar;
    private int qst_price;
    private int qst_comp;
    
    //제목
    private String sb_title;
    //구매자 닉네임
    private String nickName;
    
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSb_title() {
		return sb_title;
	}
	public void setSb_title(String sb_title) {
		this.sb_title = sb_title;
	}
	public int getQst_price() {
		return qst_price;
	}
	public void setQst_price(int qst_price) {
		this.qst_price = qst_price;
	}
	public int getQst_comp() {
		return qst_comp;
	}
	public void setQst_comp(int qst_comp) {
		this.qst_comp = qst_comp;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public int getSb_no() {
		return sb_no;
	}
	public void setSb_no(int sb_no) {
		this.sb_no = sb_no;
	}
	public Date getQst_dar() {
		return qst_dar;
	}
	public void setQst_dar(Date qst_dar) {
		this.qst_dar = qst_dar;
	}
    
    
}
