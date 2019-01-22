package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

		////글쓴이 정보 가져오기
		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
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
	@RequestMapping("insert")
	public String insert(SmsReq smsReq, Model model) {
		////세션 로그인 정보 가져오고
		//insert
		smsReq.setMem_no(1);
		
		int result=srs.insert(smsReq);
		model.addAttribute("result", result);
		return "req/insert";
	}
	@RequestMapping("view")
	public String view(int num, String pageNum, Model model) {
		srs.updateReadcount(num);
		SmsReq smsReq = srs.select(num);
		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("smsReq", smsReq);
		model.addAttribute("pageNum", pageNum);
		return "req/view";
	}
	
	@RequestMapping("condition")
	public String condition(int num, String pageNum, Model model) {
		srs.updateCondition(num);
		SmsReq smsReq = srs.select(num);
		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("smsReq", smsReq);
		model.addAttribute("pageNum", pageNum);
		return "req/view";
	}
	@RequestMapping("updateForm")
	public String updateForm(int num, String pageNum, Model model) {
		SmsReq smsReq = srs.select(num);
		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);

		model.addAttribute("smsReq", smsReq);
		model.addAttribute("pageNum", pageNum);

		return "req/updateForm";
	}
	@RequestMapping("update")
	public String update(SmsReq smsReq, String pageNum, Model model) {
		////세션 로그인 정보 가져오고
		//insert
		int result=srs.update(smsReq);
		model.addAttribute("result", result);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("smsReq", smsReq);
		
		return "req/update";
	}
	@RequestMapping("delete")
	public String delete(int num, String pageNum, Model model) {
		int result = srs.delete(num);
		model.addAttribute("result", result);
		
		model.addAttribute("pageNum", pageNum);
		return "req/delete";
	}
}
