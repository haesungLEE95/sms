package com.pub.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMem;
import com.pub.sms.service.SmsMemService;

@Controller
public class SmsMemController {
	@Autowired
	private SmsMemService sms;
	@RequestMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
}
