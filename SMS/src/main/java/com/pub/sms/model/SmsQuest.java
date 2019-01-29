package com.pub.sms.model;

import java.sql.Date;

public class SmsQuest {
    private int mem_no; 
    private int sb_no; 
    private Date qst_dar;
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
