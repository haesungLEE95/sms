package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsChaReply;

public interface SmsChaReplyService {

	Collection<SmsChaReply> list(int rep_no);

	void insert(SmsChaReply scr);

	void delete(int rep_no);

	void update(SmsChaReply scr);
}
