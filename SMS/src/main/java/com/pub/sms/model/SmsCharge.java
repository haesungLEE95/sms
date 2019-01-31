package com.pub.sms.model;

import java.sql.Date;

public class SmsCharge {
	private int mem_no;
	private int chg_mny;
	private Date chg_date;
	
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public int getChg_mny() {
		return chg_mny;
	}
	public void setChg_mny(int chg_mny) {
		this.chg_mny = chg_mny;
	}
	public Date getChg_date() {
		return chg_date;
	}
	public void setChg_date(Date chg_date) {
		this.chg_date = chg_date;
	}
	
}
