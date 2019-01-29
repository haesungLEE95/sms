package com.pub.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsQnA;
import com.pub.sms.model.SmsQuest;
import com.pub.sms.service.SmsQuestService;

@Controller
public class SmsQuestController {
	@Autowired
	private SmsQuestService sqs;
	
	
	@RequestMapping("smsQuestBuy")
	public String smsQuestBuy(SmsQuest smsqst, int sb_no, String pageNum, Model model) {
		////세션 로그인 정보 가져오고
		//insert
		smsqst.setMem_no(1);
		smsqst.setSb_no(sb_no);
		int result=sqs.insert(smsqst);
		model.addAttribute("result", result);
		model.addAttribute("sb_no", sb_no);
		model.addAttribute("pageNum", pageNum);
		return "qst/smsQuestBuy";
	}
}
