package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsReqReplyDao;
import com.pub.sms.model.SmsReqReply;

@Service
public class SmsReqReplyServiceImpl implements SmsReqReplyService{
	@Autowired
	private SmsReqReplyDao srrd;

	@Override
	public Collection<SmsReqReply> list(int rq_no) {
		return srrd.list(rq_no);
	}

	@Override
	public void insert(SmsReqReply rb) {
		srrd.insert(rb);
	}

	@Override
	public void delete(int rq_re_no) {
		srrd.delete(rq_re_no);
	}

	@Override
	public void update(SmsReqReply rb) {
		srrd.update(rb);
	} 
}
