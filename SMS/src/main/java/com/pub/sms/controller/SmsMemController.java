package com.pub.sms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pub.sms.model.SmsMem;
import com.pub.sms.service.MediaUtils;
import com.pub.sms.service.SmsMemService;
import com.pub.sms.service.UploadFileUtils;

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
	
	@RequestMapping(value="idChk",
			produces="text/html;charset=utf8")
	@ResponseBody
	public String idChk(String mem_id) {
		String msg = "";
		SmsMem mem = sms.select(mem_id);
		if (mem==null) msg="<br>사용가능합니다";
		else msg="<br>다른 아이디를 선택하세요";
		return msg;
	}
	
	@RequestMapping(value="nickChk",
			produces="text/html;charset=utf8")
	@ResponseBody
	public String nickChk(String nickname) {
		String msg = "";
		SmsMem mem = sms.nickSelect(nickname);
		if (mem==null) msg="<br>사용가능합니다";
		else msg="<br>다른 닉네임을 선택하세요";
		return msg;
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
