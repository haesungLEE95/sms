package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsReview;
public interface SmsReviewDao {

	Collection<SmsReview> list(int sb_no);

	void insert(SmsReview rb);

	void delete(int re_no);

	void update(SmsReview rb);
}
