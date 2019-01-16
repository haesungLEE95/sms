package com.pub.sms.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsCha;
import com.pub.sms.model.SmsMem;
import com.pub.sms.service.SmsChaPagingBean;
import com.pub.sms.service.SmsChaService;
import com.pub.sms.service.SmsMemService;

@Controller
public class SmsChaController {
	@Autowired
	private SmsChaService scs;
	@Autowired
	private SmsMemService sms;
	
	@RequestMapping("smsChaList")
	public String smsChaList(SmsMem sm ,String pageNum, SmsCha smscha, Model model) {
		if (pageNum==null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage  = 10;
		int total = scs.getTotal(smscha);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow   = startRow + rowPerPage - 1;
		smscha.setStartRow(startRow);
		smscha.setEndRow(endRow);
		
		Collection<SmsCha> list = scs.list(smscha);
		SmsMem memNick = sms.memNick(1);
		
		SmsChaPagingBean pb=new SmsChaPagingBean(currentPage,rowPerPage,total);
		
		//if (memNick != null) {
		model.addAttribute("memNick", memNick.getNickname());
		//}
		model.addAttribute("list", list);
		model.addAttribute("smscha", smscha);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pb", pb);
		return "/cha/smsChaList";
	}
	
	@RequestMapping("smsInsertForm")
	public String smsInsertForm(String pageNum ,SmsCha smscha, Model model) {
		//SmsCha cha = scs.select(smscha);
		SmsMem memNick = sms.memNick(1);
		//model.addAttribute("cha", cha);
		model.addAttribute("memNick", memNick.getNickname());
		model.addAttribute("pageNum", pageNum);
		return "/cha/smsInsertForm";
	}
	
	@RequestMapping("smsInsert")
	public String smsInsert(String pageNum, SmsCha smscha, Model model) {
		int result = 0;
		result = scs.insert(smscha);
		
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "/cha/smsInsert";
	}
	
	@RequestMapping("smsView")
	public String smsView(String pageNum,int num, Model model) {
		scs.updateReadcount(num);
		SmsMem memNick = sms.memNick(1);
		SmsCha smscha = scs.selectno(num);
		model.addAttribute("smscha", smscha);
		model.addAttribute("memNick", memNick.getNickname());
		model.addAttribute("pageNum", pageNum);
		return "/cha/smsView";
	}
	@RequestMapping("smsUpdateForm")
	public String smsUpdateForm(int num, SmsMem sm, String pageNum,SmsCha smscha, Model model) {
		SmsCha cha = scs.select(smscha);
		SmsMem memNick = sms.memNick(1);
		SmsCha sc = scs.selectno(num);
		SmsMem memEmail = sms.memEail(1);
		System.out.println("sc : "+sc);
		model.addAttribute("memNick", memNick.getNickname());
		model.addAttribute("memEmail", memEmail.getEmail());
		model.addAttribute("sc", sc);
		model.addAttribute("cha", cha);
		model.addAttribute("pageNum", pageNum);
		return "/cha/smsUpdateForm";
	}
	@RequestMapping("smsUpdate")
	public String smsUpdate() {
		//int result = scs.update(); 해야됨
		
		return "/cha/smsUpdate";
	}
}

