package com.pub.sms.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsMem;
import com.pub.sms.model.SmsQuest;
import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.model.SmsSubCate;
import com.pub.sms.service.SmsMCateService;
import com.pub.sms.service.SmsMemService;
import com.pub.sms.service.SmsQuestService;
import com.pub.sms.service.SmsSCateService;
import com.pub.sms.service.SmsSellBoardService;

@Controller
public class SmsQuestController {
	@Autowired
	private SmsQuestService sqs;
	@Autowired
	private SmsSellBoardService ssbs;	
	@Autowired
	private SmsSCateService sss;
	@Autowired
	private SmsMCateService sms;
	@Autowired
	private SmsMemService smsi;
	
	//구매내역
	@RequestMapping("smsQuestBuy")
	public String smsQuestBuy(int sb_no, int price, String pageNum, Model model,SmsQuest smsqst, HttpSession session) {
		////세션 로그인 정보 가져오고
		//insert
		int mem_no = (Integer) session.getAttribute("mem_no"); 
		
		smsqst.setMem_no(mem_no);
		smsqst.setSb_no(sb_no);
		smsqst.setQst_price(price);
		
		SmsMem mem = smsi.memNick(mem_no);
		SmsQuest sq = sqs.select(smsqst);
		if(mem.getMny()>=price) {
			// select 로그인 아이디, 게시글, comp==0
			if(sq!=null) { //구매한적있지만 완료하지 못했을때
				// 완료 전입니다.
				model.addAttribute("sb_no", sb_no);
				model.addAttribute("pageNum", pageNum);
				return "qst/smsQuestAlready";
			}
			else {
			//else if(sq==null) { //구매한적 없거나, 구매한적 있어도 완료했을 때
				// 바로 구매
	
				//세션 멤버 돈 빼기
				smsi.buyItem(smsqst);
	
				int result=sqs.insert(smsqst);
				model.addAttribute("result", result);
				model.addAttribute("sb_no", sb_no);
				model.addAttribute("price", price);
				model.addAttribute("pageNum", pageNum);
				return "qst/smsQuestBuy";
			}
		}
		else {
			model.addAttribute("result", 2);
			model.addAttribute("sb_no", sb_no);
			model.addAttribute("pageNum", pageNum);
			return "qst/smsQuestAlready";
		}
	}
	
	@RequestMapping("smsBuyQuestList")
	public String smsBuyQuestList(Model model, HttpSession session) {
		////세션 로그인 정보 가져오고
		//insert
		int mem_no = (Integer) session.getAttribute("mem_no");
		Collection<SmsQuest> list = sqs.buyList(mem_no);  //로그인 세션(회원번호)
		for(SmsQuest sq : list) {
			SmsSellBoard sb = ssbs.select(sq.getSb_no());
			sq.setSb_title(sb.getSb_title());
			/* 구매한 사람 닉네임 가져오기
			SmsMem sm = sms.select(sq.getMem_no());
			sq.setNickName(sm.getNickname());
*/		}
		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("list", list);
		return "qst/smsBuyQuestList";
	}

	@RequestMapping("smsSelQuestList")
	public String smsSelQuestList(Model model, HttpSession session) {
		////세션 로그인 정보 가져오고
		//insert
		int mem_no = (Integer) session.getAttribute("mem_no");
		Collection<SmsQuest> list = sqs.selList(mem_no);  //로그인 세션(회원번호)
		for(SmsQuest sq : list) {
			SmsSellBoard sb = ssbs.select(sq.getSb_no());
			sq.setSb_title(sb.getSb_title());
		}
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		model.addAttribute("list", list);
		return "qst/smsSelQuestList";
	}
	
	@RequestMapping("smsBuyCondition")
	public String smsBuyCondition(int sb_no, int price, String pageNum, Model model,SmsQuest smsqst, HttpSession session) {
		////세션 로그인 정보 가져오고
		//insert
		int mem_no = (Integer) session.getAttribute("mem_no");
		smsqst.setMem_no(mem_no);
		smsqst.setSb_no(sb_no);
		int result = sqs.comp(smsqst);
		
		//smsqst의 게시글번호
		SmsSellBoard sb = ssbs.select(smsqst.getSb_no());
		//sellboard의 게시글번호의 작성자
		smsi.selItem(sb);
		//판매자에게 price 지급
		//
		
		Collection<SmsQuest> list = sqs.buyList(mem_no);  //로그인 세션(회원번호)
		for(SmsQuest sq : list) {
			SmsSellBoard sbd = ssbs.select(sq.getSb_no());
			sq.setSb_title(sbd.getSb_title());
			/* 구매한 사람 닉네임 가져오기
			SmsMem sm = sms.select(sq.getMem_no());
			sq.setNickName(sm.getNickname());
*/		}		
		

		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("list", list);
		return "qst/smsBuyQuestList";
	}
		
}
