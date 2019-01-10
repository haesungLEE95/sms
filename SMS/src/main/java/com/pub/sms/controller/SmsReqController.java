package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsReq;
import com.pub.sms.model.SmsSubCate;
import com.pub.sms.service.SmsMCateService;
import com.pub.sms.service.SmsReqPagingBean;
import com.pub.sms.service.SmsReqService;
import com.pub.sms.service.SmsSCateService;

@Controller
public class SmsReqController {
	@Autowired
	private SmsMCateService sms;
	@Autowired
	private SmsSCateService sss;
	@Autowired
	private SmsReqService srs;
	
	@RequestMapping("list")
	public String list(String pageNum,SmsReq smsReq, Model model) {
		if (pageNum==null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage  = 10;
		int total = srs.getTotal(smsReq); 
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow   = startRow + rowPerPage - 1;
		smsReq.setStartRow(startRow);
		smsReq.setEndRow(endRow);
		// Collection<Board> list = bs.list(startRow, endRow);
		Collection<SmsReq> list = srs.list(smsReq);
		
		SmsReqPagingBean pb=new SmsReqPagingBean(currentPage,rowPerPage,total);
		
		model.addAttribute("list", list);
		model.addAttribute("smsReq", smsReq);
		
		model.addAttribute("pb", pb);
		return "req/list";
	}
	@RequestMapping("insertForm")
	public String insertForm(String pageNum, Model model) {
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		return "req/insertForm";
	}
}
