package com.pub.sms.model;

import java.sql.Date;

public class SmsQnaReply {
    private int qna_rep;        //거래댓글번호  
    private int qna_no;          //거래글번호
    private String qna_re_cont;  //댓글내용   
    private int mem_no;          //회원번호
    private Date regdate;         //작성일
    private Date updatedate;     //수정날짜
    private String del;			//삭제여부
	//nickname
	private String nickname;
    
	public String getQna_re_cont() {
		return qna_re_cont;
	}
	public void setQna_re_cont(String qna_re_cont) {
		this.qna_re_cont = qna_re_cont;
	}
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