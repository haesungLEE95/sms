package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsChaReplyDao;
import com.pub.sms.model.SmsChaReply;

@Service
public class SmsChaReplyServiceImpl implements SmsChaReplyService {
	@Autowired
	private SmsChaReplyDao scrd;

	@Override
	public Collection<SmsChaReply> list(int rep_no) {
		return scrd.list(rep_no);
	}

	@Override
	public void insert(SmsChaReply scr) {
		scrd.insert(scr);
	}

	@Override
	public void delete(int rep_no) {
		scrd.delete(rep_no);
		
	}

	@Override
	public void update(SmsChaReply scr) {
		scrd.update(scr);
	}

	
}
