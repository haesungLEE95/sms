package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsCha;
import com.pub.sms.model.SmsChaReply;
import com.pub.sms.model.SmsMem;
import com.pub.sms.service.SmsChaReplyService;
import com.pub.sms.service.SmsChaService;
import com.pub.sms.service.SmsMemService;
@Controller
public class SmsChaReplyController {
	@Autowired
	private SmsChaReplyService scrl;
	@Autowired
	private SmsChaService scs;
	@Autowired
	private SmsMemService sms;
	
	@RequestMapping("replyList")
	public String replyList(int cha_no, Model model) {
		SmsCha smscha = scs.select(cha_no);
		Collection<SmsChaReply> rbdList = scrl.list(cha_no);
		SmsMem memNick = sms.memNick(1);
		model.addAttribute("memNick", memNick.getNickname());
		model.addAttribute("smscha", smscha);
		model.addAttribute("rbdList", rbdList);
		
		return "/cha/replyList";
	}
	@RequestMapping("rInsert")
	public String rInsert(SmsChaReply scr ) {
		scrl.insert(scr);
		
		return "redirect:replyList.do?cha_no="+scr.getCha_no();
	}
	@RequestMapping("rDelete")
	public String rDelete(SmsChaReply scr ) {
		scrl.delete(scr.getRep_no());
		return "redirect:replyList.do?cha_no="+scr.getCha_no();
	}
	@RequestMapping("rUpdate")
	public String rUpdate(SmsChaReply scr ) {
		scrl.update(scr);
		return "redirect:replyList.do?cha_no="+scr.getCha_no();
	}
	
}
