package com.pub.sms.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMem;
import com.pub.sms.model.SmsReview;
import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.service.SmsMemService;
import com.pub.sms.service.SmsReviewService;
import com.pub.sms.service.SmsSellBoardService;

@Controller
public class SmsReviewController {
	@Autowired
	private SmsSellBoardService ssbs;
	@Autowired
	private SmsReviewService srvs;
	@Autowired
	private SmsMemService smsi;
	
	@RequestMapping("smsReviewList")
	public String smsReviewList(HttpSession session, int sb_no, Model model) {
		SmsSellBoard smssel = ssbs.select(sb_no);
		Collection<SmsReview> rbdList = srvs.list(sb_no);
		//SmsMem sm = smsi.select((String)session.getAttribute("mem_id"));
		//SmsMem smwriter = smsi.select((String)session.getAttribute("mem_id"));
		//model.addAttribute("sm", sm);
		//model.addAttribute("smwriter", smwriter);
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
