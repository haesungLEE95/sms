package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsReview;
import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.service.SmsReviewService;
import com.pub.sms.service.SmsSellBoardService;

@Controller
public class SmsReviewController {
	@Autowired
	private SmsSellBoardService ssbs;
	@Autowired
	private SmsReviewService srvs;
	
	@RequestMapping("smsReviewList")
	public String smsReviewList(int sb_no, Model model) {
		SmsSellBoard smssel = ssbs.select(sb_no);
		Collection<SmsReview> rbdList = srvs.list(sb_no);
		
		model.addAttribute("smssel", smssel);
		model.addAttribute("rbdList", rbdList);
		return "sellBoard/smsSelReplyList";
	}
	
	@RequestMapping("smsReviewInsert")
	public String smsReviewInsert(SmsReview rb) {
		srvs.insert(rb);
		return "redirect:smsReviewList.do?sb_no="+rb.getSb_no();
	}
	@RequestMapping("smsReviewDelete")
	public String smsReviewDelete(SmsReview rb) {
		srvs.delete(rb.getRe_no());
		return "redirect:smsReviewList.do?sb_no="+rb.getSb_no();
	}

	@RequestMapping("smsReviewUpdate")
	public String smsReviewUpdate(SmsReview rb) {
		srvs.update(rb);
		return "redirect:smsReviewList.do?sb_no="+rb.getSb_no();
	}
}
