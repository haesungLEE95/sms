package com.pub.sms.model;

import java.sql.Date;

public class SmsSellBoard {
    private int sb_no; 
    private String sb_title; 
    private String sb_desc; 
    private String sb_price; 
    private String sb_img; 
    private int mem_no; 
    private int mcate_no; 
    private int scate_no; 
    private Date sb_date; 
    
	// paging용
	private int startRow;
	private int endRow;
	
	
	public int getSb_no() {
		return sb_no;
	}
	public void setSb_no(int sb_no) {
		this.sb_no = sb_no;
	}
	public String getSb_title() {
		return sb_title;
	}
	public void setSb_title(String sb_title) {
		this.sb_title = sb_title;
	}
	public String getSb_desc() {
		return sb_desc;
	}
	public void setSb_desc(String sb_desc) {
		this.sb_desc = sb_desc;
	}
	public String getSb_price() {
		return sb_price;
	}
	public void setSb_price(String sb_price) {
		this.sb_price = sb_price;
	}
	public String getSb_img() {
		return sb_img;
	}
	public void setSb_img(String sb_img) {
		this.sb_img = sb_img;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
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
	public Date getSb_date() {
		return sb_date;
	}
	public void setSb_date(Date sb_date) {
		this.sb_date = sb_date;
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
}
