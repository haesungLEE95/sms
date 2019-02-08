package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsQnAReplyDao;
import com.pub.sms.model.SmsQnaReply;

@Service
public class SmsQnAReplyServiceImpl implements SmsQnAReplyService{
	@Autowired
	private SmsQnAReplyDao sqrd;

	@Override
	public Collection<SmsQnaReply> list(int qna_no) {
		return sqrd.list(qna_no);
	}

	@Override
	public void insert(SmsQnaReply sqr) {
		sqrd.insert(sqr);
	}

	@Override
	public void delete(int qna_no) {
		sqrd.delete(qna_no);
	}

	@Override
	public void update(SmsQnaReply sqr) {
		sqrd.update(sqr);
	}
}
