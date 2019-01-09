package com.pub.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.service.SmsChaService;

@Controller
public class SmsChaController {
	@Autowired
	private SmsChaService scs;
	@RequestMapping("smsChaList")
	public String smsChaList() {
		return "/cha/smsChaList";
	}
}
