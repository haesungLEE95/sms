package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsReviewDao;
import com.pub.sms.model.SmsReview;

@Service
public class SmsReviewServiceImpl implements SmsReviewService{
	@Autowired
	private SmsReviewDao srd;

	@Override
	public Collection<SmsReview> list(int sb_no) {
		return srd.list(sb_no);
	}
	@Override
	public void insert(SmsReview rb) {
		srd.insert(rb);
	}

	@Override
	public void delete(int re_no) {
		srd.delete(re_no);
	}

	@Override
	public void update(SmsReview rb) {
		srd.update(rb);
	}
}
