package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMem;
import com.pub.sms.model.SmsQnA;
import com.pub.sms.model.SmsQnaReply;
import com.pub.sms.model.SmsReqReply;
import com.pub.sms.model.SmsReview;
import com.pub.sms.service.SmsMCateService;
import com.pub.sms.service.SmsMemService;
import com.pub.sms.service.SmsQnAReplyService;
import com.pub.sms.service.SmsQnAService;
import com.pub.sms.service.SmsReqService;
import com.pub.sms.service.SmsSCateService;
@Controller
public class SmsQnaReplyController {
	@Autowired
	private SmsMCateService sms;
	@Autowired
	private SmsSCateService sss;
	@Autowired
	private SmsReqService srs;
	@Autowired
	private SmsMemService smsi;
	@Autowired
	private SmsQnAService sqs;
	@Autowired
	private SmsQnAReplyService sqars;
	@RequestMapping("qnaReplyList")
	public String qnaReplyList(int qna_no, Model model) {
		SmsQnA smsqna = sqs.select(qna_no);
		Collection<SmsQnaReply> rbdList = sqars.list(qna_no);
		for(SmsQnaReply sqr : rbdList) {
			SmsMem sm = smsi.memNick(sqr.getMem_no());
			sqr.setNickname(sm.getNickname());
		}
		model.addAttribute("smsqna", smsqna);
		model.addAttribute("rbdList", rbdList);
		return "qna/qnaReplyList";
	}
	@RequestMapping("qnaReplyInsert")
	public String qnaReplyInsert(SmsQnaReply sqr) {
		System.out.println(sqr.getQna_rep());
		sqars.insert(sqr);
		return "redirect:qnaReplyList.do?qna_no="+sqr.getQna_no();
	}
	@RequestMapping("qnaReplyDelete")
	public String qnaReplyDelete(SmsQnaReply sqr) {
		sqars.delete(sqr.getQna_no());
		return "redirect:qnaReplyList.do?qna_no="+sqr.getQna_no();
	}
	
	@RequestMapping("qnaReplyUpdate")
	public String qnaReplyUpdate(SmsQnaReply sqr) {
		sqars.update(sqr);
		return "redirect:qnaReplyList.do?qna_no="+sqr.getQna_no();
	}
}
