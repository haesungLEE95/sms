package com.pub.sms.model;
import java.sql.Date;

public class SmsReq {
	private int mem_no; 
	private int rq_no; 
	private int mcate_no; 
	private int scate_no; 
    private String rq_title; 
    private String rq_cont; 
    private Date rq_date; 
    private int rq_price; 
    private int rq_cond;
    private int rq_count;
	// paging용
	private int startRow;
	private int endRow;
	
	private String nickname;
	
    
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRq_count() {
		return rq_count;
	}
	public void setRq_count(int rq_count) {
		this.rq_count = rq_count;
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
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public int getRq_no() {
		return rq_no;
	}
	public void setRq_no(int rq_no) {
		this.rq_no = rq_no;
	}
	public int getMcate_no() {
		return mcate_no;
	}
	public void setMcate_no(int mcate_no) {
		this.mcate_no = mcate_no;
	}
	public int getScate_no() {
		return scate_no;
	}
	public void setScate_no(int scate_no) {
		this.scate_no = scate_no;
	}
	public String getRq_title() {
		return rq_title;
	}
	public void setRq_title(String rq_title) {
		this.rq_title = rq_title;
	}
	public String getRq_cont() {
		return rq_cont;
	}
	public void setRq_cont(String rq_cont) {
		this.rq_cont = rq_cont;
	}
	public Date getRq_date() {
		return rq_date;
	}
	public void setRq_date(Date rq_date) {
		this.rq_date = rq_date;
	}
	public int getRq_price() {
		return rq_price;
	}
	public void setRq_price(int rq_price) {
		this.rq_price = rq_price;
	}
	public int getRq_cond() {
		return rq_cond;
	}
	public void setRq_cond(int rq_cond) {
		this.rq_cond = rq_cond;
	}
}
