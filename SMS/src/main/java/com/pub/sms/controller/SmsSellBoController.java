package com.pub.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.service.SmsSellBoService;

@Controller
public class SmsSellBoController {
	@Autowired
	private SmsSellBoService ssbs;
	
	@RequestMapping("sellBoList")
	public String sellBoList() {
		return "/sellBo/sellBoList";
	}
}
