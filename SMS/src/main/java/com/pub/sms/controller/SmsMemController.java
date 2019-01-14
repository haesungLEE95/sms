package com.pub.sms.controller;

import javax.servlet.http.HttpSession;

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
		SmsMem smem = sms.select(mem.getMem_id());
		if(smem == null) result = sms.insert(mem);
		else result = -1;
		model.addAttribute("result", result);
		model.addAttribute("mem", mem);
		model.addAttribute("mem_id", mem.getMem_id());
		return "/mem/joinForm2";
	}
	@RequestMapping("joinResult")
	public String joinResult(SmsMem mem, Model model) {
		int result = 0;
		SmsMem smem = sms.select(mem.getMem_id());
		System.out.println("1:"+smem);
		System.out.println("1 smem:"+smem+"2 mem:"+mem);
		if(smem != null) result = sms.firstUpdate(mem);		
		model.addAttribute("result", result);
		return "/mem/joinResult";
	}
	@RequestMapping("loginForm")
	public String loginForm() {
		return "/mem/loginForm";
	}
	
	@RequestMapping("login")
	public String login(SmsMem mem,Model model,HttpSession session) {
		int result = 0;
		SmsMem smem = sms.select(mem.getMem_id());
		if (smem==null) result = -1;
		else if (smem.getPasswd().equals(mem.getPasswd())) {
			result = 1;
			session.setAttribute("mem_id", mem.getMem_id());
		}			
		model.addAttribute("result", result);
		return "login";
	}
}
