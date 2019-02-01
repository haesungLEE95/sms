package com.pub.sms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMem;
import com.pub.sms.service.SmsMemService;

@Controller
public class SmsMemController {
	@Autowired
	private SmsMemService sms;
		
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping("joinForm")
	public String joinForm() {
		return "/mem/joinForm";
	}
	
	@RequestMapping("joinForm2")
	public String join(SmsMem mem, Model model) {
		int result = 0;
		SmsMem smem = sms.select(mem.getMem_id());
		String encPass = pwEncoder.encode(mem.getPasswd());
		mem.setPasswd(encPass);
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
		String dbPw = smem.getPasswd();
		String rawPw = mem.getPasswd();
		if (smem==null) result = -1;
		else if (pwEncoder.matches(rawPw, dbPw)) {
			mem.setPasswd(dbPw);
			result = 1;
			session.setAttribute("mem_id", mem.getMem_id());
		}			
		model.addAttribute("result", result);
		return "/mem/login";
	}
	@RequestMapping("myPage")
	public String myPage(Model model, HttpSession session) {
		String mem_id = (String) session.getAttribute("mem_id");
		SmsMem mem = sms.select(mem_id);
		model.addAttribute("mem", mem);
		return "/mem/myPage";
	}
	
}
