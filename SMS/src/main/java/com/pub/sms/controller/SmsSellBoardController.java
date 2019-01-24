package com.pub.sms.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.model.SmsSubCate;
import com.pub.sms.service.SmsMCateService;
import com.pub.sms.service.SmsReqPagingBean;
import com.pub.sms.service.SmsSCateService;
import com.pub.sms.service.SmsSellBoardService;

@Controller
public class SmsSellBoardController {
	@Autowired
	private SmsMCateService sms;
	@Autowired
	private SmsSCateService sss;
	@Autowired
	private SmsSellBoardService ssbs;
	
	@RequestMapping("smsSellBoardList")
	public String smsSellBoardList(String pageNum,SmsSellBoard smssel, String mno, String sno, Model model) {
		if (pageNum==null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage  = 4;
		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow   = startRow + rowPerPage - 1;
		smssel.setStartRow(startRow);
		smssel.setEndRow(endRow);
		// Collection<Board> list = bs.list(startRow, endRow);
		int total;
		Collection<SmsSellBoard> list;
		if(mno==null) { //게시판 전체 선택시				mno = null, sno = null
			total = ssbs.getTotal(smssel);
			list = ssbs.list(smssel);
		}
		else if(sno==null) { //메인카테고리 전체 선택시		mno = 4, sno = null
			int mNum=Integer.parseInt(mno);
			smssel.setMcate_no(mNum);
			total = ssbs.getMCateTotal(mNum);
			list = ssbs.mCateList(smssel);
		}
		else { //서브 카테고리 선택시						mno = 4, sno = 20
			int mNum=Integer.parseInt(mno);
			int sNum=Integer.parseInt(sno);
			smssel.setMcate_no(mNum);
			smssel.setScate_no(sNum);
			total = ssbs.getSCateTotal(sNum);
			list = ssbs.sCateList(smssel);
		}



		SmsReqPagingBean pb=new SmsReqPagingBean(currentPage,rowPerPage,total);

		////글쓴이 정보 가져오기
		

		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("list", list);
		model.addAttribute("smssel", smssel);
		
		model.addAttribute("pb", pb);
		return "sellBoard/smsSelList";
	}
	
	@RequestMapping("smsSellBoardInsertForm")
	public String smsSellBoardInsertForm(String pageNum, Model model) {
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		return "sellBoard/smsSelInsertForm";
	}
	
	@RequestMapping("smsSellBoardinsert")
	public String smsSellBoardinsert(SmsSellBoard smssel, Model model) {
		////세션 로그인 정보 가져오고
		//insert
		smssel.setMem_no(1);
		
		int result=ssbs.insert(smssel);
		model.addAttribute("result", result);
		return "sellBoard/smsSelInsert";
	}
	//smsSellBoardView
	@RequestMapping("smsSellBoardView")
	public String smsSellBoardView(int num, String pageNum, Model model) {
		SmsSellBoard smssel = ssbs.select(num);

		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("smssel", smssel);
		model.addAttribute("pageNum", pageNum);
		return "sellBoard/smsSelView";
	}
	@RequestMapping("smsSellBoardUpdateForm")
	public String smsSellBoardUpdateForm(int num, String pageNum, Model model) {
		SmsSellBoard smssel = ssbs.select(num);
		
		Collection<SmsMainCate> mcateList = sms.list();
		Collection<SmsSubCate> scateList = sss.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);

		model.addAttribute("smssel", smssel);
		model.addAttribute("pageNum", pageNum);

		return "sellBoard/smsSelUpdateForm";
	}
	@RequestMapping("smsSellBoardUpdate")
	public String smsSellBoardUpdate(SmsSellBoard smssel, String pageNum, Model model) {
		////세션 로그인 정보 가져오고
		//insert
		System.out.println("제목 : "+smssel.getSb_title());
		int result=ssbs.update(smssel);
		model.addAttribute("result", result);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("smssel", smssel);
		
		return "sellBoard/smsSelUpdate";
	}
	@RequestMapping("smsSellBoardDelete")
	public String smsSellBoardDelete(int num, String pageNum, Model model) {
		int result = ssbs.delete(num);
		model.addAttribute("result", result);
		
		model.addAttribute("pageNum", pageNum);
		return "sellBoard/smsSelDelete";
	}

}
