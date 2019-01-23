package com.pub.sms.service;
import java.util.Collection;

import com.pub.sms.model.SmsReqReply;

public interface SmsReqReplyService {

	Collection<SmsReqReply> list(int rq_no);

	void insert(SmsReqReply rb);

	void delete(int rq_re_no);

	void update(SmsReqReply rb);

}
