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
		//SmsMem memNick = sms.memNick(smscha.getMem_no());
		int no = total - startRow + 1;
		SmsChaPagingBean pb=new SmsChaPagingBean(currentPage,rowPerPage,total);

		//model.addAttribute("memNick", memNick);
		model.addAttribute("list", list);
		model.addAttribute("smscha", smscha);
		model.addAttribute("no", no);
		model.addAttribute("pb", pb);
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
	
	@RequestMapping("smsView")
	public String smsView(int num, Model model) {
		scs.updateReadcount(num);
		SmsCha smscha = scs.selectno(num);
		model.addAttribute("smscha", smscha);
		return "/cha/smsView";
	}
}

