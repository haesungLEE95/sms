package com.pub.sms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsQuest;
import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.model.SmsSubCate;
import com.pub.sms.service.SmsMCateService;
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
	//구매내역
	@RequestMapping("smsQuestBuy")
	public String smsQuestBuy(int sb_no, int price, String pageNum, Model model,SmsQuest smsqst) {
		////세션 로그인 정보 가져오고
		//insert
		smsqst.setMem_no(1);
		smsqst.setSb_no(sb_no);
		smsqst.setQst_price(price);
		
		
		SmsQuest sq = sqs.select(smsqst);
		
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
			//sms.buyItem(price);

			int result=sqs.insert(smsqst);
			model.addAttribute("result", result);
			model.addAttribute("sb_no", sb_no);
			model.addAttribute("price", price);
			model.addAttribute("pageNum", pageNum);
			return "qst/smsQuestBuy";
		}

	}
	
	@RequestMapping("smsBuyQuestList")
	public String smsBuyQuestList(Model model) {
		////세션 로그인 정보 가져오고
		//insert
		
		Collection<SmsQuest> list = sqs.buyList(1);  //로그인 세션(회원번호)
		for(SmsQuest sq : list) {
			SmsSellBoard sb = ssbs.select(sq.getSb_no());
			sq.setSb_title(sb.getSb_title());
			/* 구매한 사람 닉네임 가져오기
			SmsMem sm = sms.select(sq.getMem_no());
			sq.setNickName(sm.getNickname());
*/		}
		model.addAttribute("list", list);
		return "qst/smsBuyQuestList";
	}

	@RequestMapping("smsSelQuestList")
	public String smsSelQuestList(Model model) {
		////세션 로그인 정보 가져오고
		//insert
		Collection<SmsQuest> list = sqs.selList(1);  //로그인 세션(회원번호)
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
	public String smsBuyCondition(int sb_no, int price, String pageNum, Model model,SmsQuest smsqst) {
		////세션 로그인 정보 가져오고
		//insert
		smsqst.setMem_no(1);
		smsqst.setSb_no(sb_no);
		int result = sqs.comp(smsqst);
		
		//판매자에게 price 지급
		//
		
		Collection<SmsQuest> list = sqs.selList(1);  //로그인 세션(회원번호)
		for(SmsQuest sq : list) {
			SmsSellBoard sb = ssbs.select(sq.getSb_no());
			sq.setSb_title(sb.getSb_title());
		}
		
		model.addAttribute("list", list);
		return "qst/smsBuyQuestList";
	}
		
}