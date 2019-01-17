package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsReq;
import com.pub.sms.model.SmsReqReply;
import com.pub.sms.service.SmsReqReplyService;
import com.pub.sms.service.SmsReqService;



@Controller
public class ReplyBoardController {
	@Autowired
	private SmsReqService srs; 
	@Autowired
	private SmsReqReplyService srrs; 
	
	@RequestMapping("replyList")
	public String replyList(int rq_no, Model model) {
		SmsReq smsReq = srs.select(rq_no);
		Collection<SmsReqReply> rbdList = srrs.list(rq_no);
		
		model.addAttribute("smsReq", smsReq);
		model.addAttribute("rbdList", rbdList);
		return "req/replyList";
	}
	
	@RequestMapping("rInsert")
	public String rInsert(SmsReqReply rb) {
		srrs.insert(rb);
		return "redirect:replyList.do?rq_no="+rb.getRq_no();
	}
	@RequestMapping("rDelete")
	public String rDelete(SmsReqReply rb) {
		srrs.delete(rb.getRq_re_no());
		return "redirect:replyList.do?rq_no="+rb.getRq_no();
	}
	
	@RequestMapping("rUpdate")
	public String rUpdate(SmsReqReply rb) {
		srrs.update(rb);
		return "redirect:replyList.do?rq_no="+rb.getRq_no();
	}
}
