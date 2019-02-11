package com.pub.sms.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsMem;
import com.pub.sms.model.SmsQnA;
import com.pub.sms.model.SmsReq;
import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.model.SmsSubCate;
import com.pub.sms.service.SmsMCateService;
import com.pub.sms.service.SmsMemService;
import com.pub.sms.service.SmsQnAPagingBean;
import com.pub.sms.service.SmsQnAService;
import com.pub.sms.service.SmsReqPagingBean;
import com.pub.sms.service.SmsSCateService;
import com.pub.sms.service.SmsSellBoardService;
//거래문의
@Controller
public class SmsQnAController {
	@Autowired
	private SmsQnAService sqs;
	@Autowired
	private SmsMCateService sms;
	@Autowired
	private SmsSCateService sss;
	@Autowired
	private SmsMemService smsi;
	@Autowired
	private SmsSellBoardService ssbs;
	@RequestMapping("smsQnAList")
	public String smsQnAList(HttpSession session, String pageNum,SmsQnA smssqa,Model model) {
		int mem_no=(Integer) session.getAttribute("mem_no");
		smssqa.setMem_no(mem_no);
		if (pageNum==null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage  = 10;
		int total = sqs.getTotal(smssqa);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow   = startRow + rowPerPage - 1;
		smssqa.setStartRow(startRow);
		smssqa.setEndRow(endRow);
		Collection<SmsQnA> list = sqs.list(smssqa);
		for(SmsQnA sqa : list) {
			SmsMem sm = smsi.memNick(sqa.getMem_no());
			sqa.setNickname(sm.getNickname());			
			SmsSellBoard ss =  ssbs.select(sqa.getSb_no());	
			sqa.setSsb_no(ss.getMem_no());;
		}
		SmsReqPagingBean pb = new SmsReqPagingBean(currentPage,rowPerPage,total);
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		model.addAttribute("pb", pb);
		model.addAttribute("list", list);
		model.addAttribute("smssqa", smssqa);
		return "qna/smsQnAList";
	}
/*	@RequestMapping("smsQnAMyList")
	public String smsQnAMyList(HttpSession session, String pageNum,SmsQnA smssqa,Model model) {
		//판매자 입장에서 받는 의뢰게시판 게시물
		int mem_no=(Integer) session.getAttribute("mem_no"); //session mem_no로 들어와서 쓴 글인지 확인하고
		//Collection<SmsSellBoard> ssb = ssbs.selectno(mem_no); // mem_no로 다 가져옴
		//sellboard에 있는 sb_no랑 qna에 있는 sb_no랑 비교해서  
		smssqa.setMem_no(mem_no);
		
		if (pageNum==null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage  = 10;
		
		int total = sqs.getMyTotal(smssqa);
		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow   = startRow + rowPerPage - 1;
		smssqa.setStartRow(startRow);
		smssqa.setEndRow(endRow);
		Collection<SmsQnA> list = sqs.myList(smssqa);
		for(SmsQnA sqa : list) {
			SmsMem sm = smsi.memNick(sqa.getMem_no());
			sqa.setNickname(sm.getNickname());			
			SmsSellBoard ss =  ssbs.select(sqa.getSb_no());	
			sqa.setSsb_no(ss.getMem_no());
		}
		
		SmsReqPagingBean pb = new SmsReqPagingBean(currentPage,rowPerPage,total);
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		model.addAttribute("pb", pb);
		model.addAttribute("list", list);
		model.addAttribute("smssqa", smssqa);
		return "qna/smsQnAMyList";
	}*/
	@RequestMapping("smsQnAInsertForm")
	public String smsQnAInsertForm(int sb_no, String pageNum, Model model) {
		// 판매게시글 번호로 문의하기 위한 sb_no
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("sb_no", sb_no);
		return "qna/smsQnAInsertForm";
	}
	@RequestMapping("smsQnAInsert")
	public String smsQnAInsert(HttpSession session, String pageNum, SmsQnA smsqna, Model model) {
		SmsMem sm = smsi.select((String)session.getAttribute("mem_id"));
		smsqna.setMem_no(sm.getMem_no());
		int result=sqs.insert(smsqna);

		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("smsqna", smsqna);
		return "qna/smsQnAInsert";
	}
	@RequestMapping("smsQnaView")
	public String smsQnaView(int num, String pageNum, Model model) {
		SmsQnA smsqna = sqs.select(num);
		SmsMem sm = smsi.memNick(smsqna.getMem_no());
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		model.addAttribute("smsqna", smsqna);
		model.addAttribute("sm", sm);
		return "qna/smsQnaView";
	}
}
