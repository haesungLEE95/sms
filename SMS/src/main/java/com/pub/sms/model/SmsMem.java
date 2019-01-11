package com.pub.sms.model;

import java.sql.Date;

public class SmsMem {
	private int mem_no; 
	private String mem_name; 
    private String mem_id; 
    private String nickname; 
    private String email; 
    private String passwd; 
    private String mem_img; 
    private String addr; 
    private String tel; 
    private int mny; 
    private int mem_del; 
    private String mem_account;
    private Date mem_reg;
    
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMem_img() {
		return mem_img;
	}
	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getMny() {
		return mny;
	}
	public void setMny(int mny) {
		this.mny = mny;
	}
	public int getMem_del() {
		return mem_del;
	}
	public void setMem_del(int mem_del) {
		this.mem_del = mem_del;
	}
	public String getMem_account() {
		return mem_account;
	}
	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	} 
	public Date getMem_reg() {
		return mem_reg;
	}
	public void setMem_reg(Date mem_reg) {
		this.mem_reg = mem_reg;
	}
}
