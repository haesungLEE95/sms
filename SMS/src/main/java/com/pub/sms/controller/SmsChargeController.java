package com.pub.sms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SmsChargeController {

	@ModelAttribute("mnyMap")
	protected Map mnyListMap(HttpServletRequest request) throws Exception {
		Map mnyMapp = new LinkedHashMap();
		mnyMapp.put("2,500", "2,500원");
		mnyMapp.put("5,000", "5,000원");
		mnyMapp.put("10,000", "10,000원");
		mnyMapp.put("30,000", "30,000원");
		mnyMapp.put("50,000", "50,000원");
		mnyMapp.put("100,000", "100,000원");

		Map mnyMap = new HashMap();
		mnyMap.put("mnyMap", mnyMapp);
		return mnyMap;
	}
}	

