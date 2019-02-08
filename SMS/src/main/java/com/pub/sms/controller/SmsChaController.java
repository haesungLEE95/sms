package com.pub.sms.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pub.sms.model.SmsCha;
import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsMem;
 import com.pub.sms.model.SmsSubCate;
import com.pub.sms.service.SmsChaPagingBean;
import com.pub.sms.service.SmsChaService;
import com.pub.sms.service.SmsMCateService;
import com.pub.sms.service.SmsMemService;
import com.pub.sms.service.SmsSCateService;

@Controller
public class SmsChaController {
	@Autowired
	private SmsMCateService smcs;
	@Autowired
	private SmsSCateService sscs;
	@Autowired
	private SmsChaService scs;
	@Autowired
	private SmsMemService sms;
	@RequestMapping("smsChaList")
	public String smsChaList(String pageNum, SmsCha smscha, Model model) {
		if (pageNum==null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage  = 10;
		int total = scs.getTotal(smscha);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow   = startRow + rowPerPage - 1;
		smscha.setStartRow(startRow);
		smscha.setEndRow(endRow);
		Collection<SmsCha> list = scs.list(smscha);
		for(SmsCha sr : list) {
			SmsMem sm = sms.memNick(sr.getMem_no());
			sr.setNickname(sm.getNickname());			
		}
		SmsChaPagingBean pb=new SmsChaPagingBean(currentPage,rowPerPage,total);
		Collection<SmsMainCate> mcateList = smcs.list();
		Collection<SmsSubCate> scateList = sscs.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		model.addAttribute("list", list);
		model.addAttribute("smscha", smscha);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pb", pb);
		return "/cha/smsChaList";
	}
	
	@RequestMapping("smsInsertForm")
	public String smsInsertForm(String pageNum ,SmsCha smscha, Model model) {
		SmsMem memNick = sms.memNick(1);
		model.addAttribute("memNick", memNick);
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
		SmsCha smscha = scs.selectno(num);
		SmsMem sm = sms.memNick(smscha.getMem_no());
		Collection<SmsMainCate> mcateList = smcs.list();
		Collection<SmsSubCate> scateList = sscs.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		model.addAttribute("sm", sm);
		model.addAttribute("smscha", smscha);
		model.addAttribute("pageNum", pageNum);
		return "/cha/smsView";
	}
	
	@RequestMapping("smsUpdateForm")
	public String smsUpdateForm(int num, String pageNum, Model model) {
		SmsMem memNick = sms.memNick(1);
		SmsCha sc = scs.selectno(num);
		model.addAttribute("memNick", memNick);
		model.addAttribute("sc", sc);
		model.addAttribute("pageNum", pageNum);
		return "/cha/smsUpdateForm";
	}
	
	@RequestMapping("smsUpdate")
	public String smsUpdate(SmsCha smscha, Model model) {
		int result = scs.update(smscha); 
		model.addAttribute("result", result);
		model.addAttribute("smscha", smscha);
		return "/cha/smsUpdate";
	}
	
	@RequestMapping("smsDelete")
	public String smsDelete(int num, String pageNum, Model model) {
		int result = scs.delete(num);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "/cha/smsDelete";
	}
	
}

