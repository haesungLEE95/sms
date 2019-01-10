package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsCha;
import com.pub.sms.service.SmsChaService;

@Controller
public class SmsChaController {
	@Autowired
	private SmsChaService scs;
	@RequestMapping("smsChaList")
	public String smsChaList(SmsCha smscha, Model model) {
		Collection<SmsCha> list = scs.list(smscha);
		model.addAttribute("list", list);
		return "/cha/smsChaList";
	}
	@RequestMapping("smsInsertForm")
	public String smsInsertForm(SmsCha smscha, Model model) {
		SmsCha cha = scs.select(smscha);
		model.addAttribute("cha", cha);
		return "/cha/smsInsertForm";
	}
	@RequestMapping("smsInsert")
	public String smsInsert(SmsCha smscha, Model model) {
		int result = 0;
		result = scs.insert(smscha);
		
		model.addAttribute("result", result);
		return "/cha/smsInsert";
	}
}

