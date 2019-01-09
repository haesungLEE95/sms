package com.pub.sms.model;

import java.sql.Date;

public class SmsCha {
	private int cha_no; 
    private int mem_no;       
    private String cha_title; 
    private String cha_cont; 
    private Date cha_date; 
    private String cha_id;
	private int cha_count ;
    public int getCha_count() {
		return cha_count;
	}
	public void setCha_count(int cha_count) {
		this.cha_count = cha_count;
	}
	public int getCha_no() {
		return cha_no;
	}
	public void setCha_no(int cha_no) {
		this.cha_no = cha_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getCha_title() {
		return cha_title;
	}
	public void setCha_title(String cha_title) {
		this.cha_title = cha_title;
	}
	public String getCha_cont() {
		return cha_cont;
	}
	public void setCha_cont(String cha_cont) {
		this.cha_cont = cha_cont;
	}
	public Date getCha_date() {
		return cha_date;
	}
	public void setCha_date(Date cha_date) {
		this.cha_date = cha_date;
	}
	public String getCha_id() {
		return cha_id;
	}
	public void setCha_id(String cha_id) {
		this.cha_id = cha_id;
	}
    
}
