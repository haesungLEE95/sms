package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsQnA;
import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.service.SmsQnAService;

@Controller
public class SmsQnAController {
	@Autowired
	private SmsQnAService sqs;
	
	@RequestMapping("smsQnAInsertForm")
	public String smsQnAInsertForm(int sb_no, String pageNum, Model model) {
		model.addAttribute("sb_no", sb_no);
		model.addAttribute("pageNum", pageNum);
		return "qna/smsQnAInsertForm";
	}
	@RequestMapping("smsQnAInsert")
	public String smsQnAInsert(String pageNum, SmsQnA smsqna, Model model) {
		////세션 로그인 정보 가져오고
		//insert
		smsqna.setMem_no(1);
		int result=sqs.insert(smsqna);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("smsqna", smsqna);
		return "qna/smsQnAInsert";
	}
}