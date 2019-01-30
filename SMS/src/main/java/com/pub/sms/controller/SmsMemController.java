package com.pub.sms.controller;

import java.io.File;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsMem;
import com.pub.sms.model.SmsSubCate;
import com.pub.sms.service.SmsMCateService;
import com.pub.sms.service.SmsMemService;
import com.pub.sms.service.SmsSCateService;

@Controller
public class SmsMemController {
	@Autowired
	private SmsMCateService smcs;
	@Autowired
	private SmsSCateService sscs;
	@Autowired
	private SmsMemService sms;
	@Autowired
	private UploadController upc;
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping("joinForm")
	public String joinForm(Model model) {
		Collection<SmsMainCate> mcateList = smcs.list();
		Collection<SmsSubCate> scateList = sscs.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		return "/mem/joinForm";
	}
	
	@RequestMapping("joinForm2")
	public String join(SmsMem mem, Model model, HttpSession session) {
		int result = 0;
		SmsMem smem = sms.select(mem.getMem_id());
		String encPass = pwEncoder.encode(mem.getPasswd());
		mem.setPasswd(encPass);
		//스프링 시큐리티의 패스워드 인코더로 패스워드를 암호화하여 DB에 저장함
		
		if(smem == null) result = sms.insert(mem);
		else result = -1;
		
		Collection<SmsMainCate> mcateList = smcs.list();
		Collection<SmsSubCate> scateList = sscs.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		
		model.addAttribute("result", result);
		model.addAttribute("mem", mem);
		model.addAttribute("mem_id", mem.getMem_id());
		System.out.println("@2 : "+encPass);
		smem = sms.select(mem.getMem_id());
		session.setAttribute("mem_id", mem.getMem_id());
		System.out.println("@3 : "+smem);
		return "/mem/joinForm2";
	}
	@RequestMapping("joinResult")
	public String joinResult(SmsMem mem, Model model, HttpSession session) {
		int result = 0;
		try {
			SmsMem smem = sms.select(mem.getMem_id());
			/*smem = sms.select(mem.getMem_id());*/
			if(smem != null) result = sms.firstUpdate(mem);		
			model.addAttribute("result", result);
			model.addAttribute("mem", mem);	
			model.addAttribute("smem", smem);	
		} catch (Exception e) {
			mem = sms.select((String) session.getAttribute("mem_id"));
			model.addAttribute("mem", mem);	
		}  
		
		Collection<SmsMainCate> mcateList = smcs.list();
		Collection<SmsSubCate> scateList = sscs.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);
		return "/mem/joinResult";
	}
	
	@RequestMapping(value="idChk",
			produces="text/html;charset=utf8")
	//id체크용 ajax 파트
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
	//닉네임 중복체크용 ajax 파트
	@ResponseBody
	public String nickChk(String nickname) {
		String msg = "";
		SmsMem mem = sms.nickSelect(nickname);
		if (mem==null) msg="<br>사용가능합니다";
		else msg="<br>다른 닉네임을 선택하세요";
		return msg;
	}
	
	@RequestMapping("loginForm")
	public String loginForm(Model model) {
		Collection<SmsMainCate> mcateList = smcs.list();
		Collection<SmsSubCate> scateList = sscs.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);

		return "/mem/loginForm";
	}
	
	@RequestMapping("login")
	public String login(SmsMem mem, Model model, HttpSession session) {
		
		int result = 0;
		try {
			SmsMem smem = sms.select(mem.getMem_id());
			String dbPw = smem.getPasswd();
			String rawPw = mem.getPasswd();
			//dbPw : db에 저장된 암호화된 패스워드
			//rawPw : 입력창에 입력된 실제 패스워드
			if (smem==null) result = -1;
			//멤버id가 매칭되지 않으면 result -1을 반환한다.
			else if (pwEncoder.matches(rawPw, dbPw)) {
				//matches메소드는 입력된 패스워드를 해독해서 암호화된 패스워드와 비교한다
				//rawPw를 암호화한 값이 dbPw와 매치된다면 result 1을 반환한다
				mem.setPasswd(dbPw);
				result = 1;
				session.setAttribute("mem_id", mem.getMem_id());
				session.setAttribute("nickname", smem.getNickname());
				session.setAttribute("mem_no", smem.getMem_no());
				//session.setAttribute("mem", mem);
				System.out.println("Mem login session : "+session);
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = -1;
		}
		model.addAttribute("result", result);
		System.out.println("Mem login session model : "+session.getId());
		return "/mem/login";
	}
	@RequestMapping("myPage")
	public String myPage(Model model, HttpSession session, SmsMem mem) {
		SmsMem smem = new SmsMem();
		System.out.println("session is "+session);
		/*if (session==null) {
			
			smem = sms.select(mem.getMem_id());
			
			login(smem, model, session);
		}
		else {*/
			String mem_id = (String) session.getAttribute("mem_id");
		mem = sms.select(mem_id); //}
		Collection<SmsMainCate> mcateList = smcs.list();
		Collection<SmsSubCate> scateList = sscs.list();
		model.addAttribute("mcateList", mcateList);
		model.addAttribute("scateList", scateList);

		model.addAttribute("mem", mem);
		return "/mem/myPage";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/mem/logout";
	}
}
