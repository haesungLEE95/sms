package com.pub.sms.service;
import java.util.Collection;

import com.pub.sms.model.SmsReview;

public interface SmsReviewService {

	Collection<SmsReview> list(int sb_no);

	void insert(SmsReview rb);

	void delete(int re_no);

	void update(SmsReview rb);

}
