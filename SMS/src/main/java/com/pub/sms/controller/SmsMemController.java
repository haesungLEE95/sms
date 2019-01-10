package com.pub.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMem;
import com.pub.sms.service.SmsMemService;

@Controller
public class SmsMemController {
	@Autowired
	private SmsMemService sms;
	
	@RequestMapping("joinForm")
	public String joinForm() {
		return "/mem/joinForm";
	}
	
	@RequestMapping("joinForm2")
	public String join(SmsMem mem, Model model) {
		int result = 0;
		System.out.println("1:"+mem);
		SmsMem smem = sms.select(mem.getMem_id());
		System.out.println("2:"+mem+",  "+smem);
		if(smem == null) result = sms.insert(mem);
		else result = -1;
		System.out.println("3:"+mem+",  result:"+result);
		model.addAttribute("result", result);
		return "/mem/joinForm2";
	}
}
