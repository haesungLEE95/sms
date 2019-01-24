package com.pub.sms.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.service.PagingBean;
import com.pub.sms.model.SmsAdmin;
import com.pub.sms.model.SmsMem;
import com.pub.sms.service.SmsAdminService;
@Controller
public class SmsAdminController {
	@Autowired
	private SmsAdminService sas;
	@RequestMapping("smsMemList")
	public String smsMemList(String pageNum, Model model, SmsMem smsMem) {
		int rowPerPage = 10;
		if (pageNum==null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1)*rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int total = sas.total(smsMem); 
		PagingBean pb=new PagingBean(currentPage,rowPerPage,total);
		int no = total - startRow + 1;
		smsMem.setStartRow(startRow);
		smsMem.setEndRow(endRow);
		Collection<SmsMem> list = sas.list(smsMem);
		model.addAttribute("pb", pb);
		model.addAttribute("no", no);
		model.addAttribute("list", list);
		
		String[] ops = {"이름","닉네임","이름+닉네임"};
		model.addAttribute("keyword",smsMem.getKeyword());
		model.addAttribute("search", smsMem.getSearch());
		model.addAttribute("ops",ops);
		return "admin/smsMemList";
	}
	
	@RequestMapping("adminMain")
	public String adminMain() {
		return "/admin/adminMain";
	}
	
	@RequestMapping("adminDelMem")
	public String adminDelMem(Model model, String pageNum, HttpServletRequest request) {
		String[] chk = request.getParameterValues("checkbox");
		SmsMem smsMem = null;
		for(int i = 0; i < chk.length; i++) {
			smsMem = sas.adminDelMem(chk[i]);
		}
		model.addAttribute("msg", "탈퇴처리되었습니다");
		SmsMem sm1 = new SmsMem();
		
		int rowPerPage = 10;
		if (pageNum==null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1)*rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int total = sas.total(smsMem); 
		PagingBean pb=new PagingBean(currentPage,rowPerPage,total);
		int no = total - startRow + 1;
		sm1.setStartRow(startRow);
		sm1.setEndRow(endRow);
		Collection<SmsMem> list = sas.list(sm1);
		
		String[] ops = {"이름","닉네임","이름+닉네임"};
		model.addAttribute("ops", ops);
		model.addAttribute("pb", pb);
		model.addAttribute("no", no);
		model.addAttribute("list", list);
		return "admin/smsMemList";
	}

	@RequestMapping("adminLoginForm")
	public String adminLoginForm() {
		return "/admin/adminLoginForm";
	}
	
	@RequestMapping("adminLogin")
	public String login(SmsAdmin smsAdmin, Model model, HttpSession session) {	
		SmsAdmin sa = sas.select(smsAdmin.getAdmin_id());
		int result = 0;
		
		if(sa==null) result = -1;
		else if (sa.getPasswd().equals(smsAdmin.getPasswd())) {
			result = 1;	
			session.setAttribute("admin_id", smsAdmin.getAdmin_id());
		}
		model.addAttribute("sa",sa);
		model.addAttribute("result",result);
		return "admin/adminLogin";
	}
	
}