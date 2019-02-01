package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsQnaReply;

public interface SmsQnAReplyService {

	Collection<SmsQnaReply> list(int qna_no);

	void insert(SmsQnaReply sqr);

	void delete(int qna_no);

	void update(SmsQnaReply sqr);

}
