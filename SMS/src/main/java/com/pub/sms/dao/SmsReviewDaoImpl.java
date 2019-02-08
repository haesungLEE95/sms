package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsReview;

@Repository
public class SmsReviewDaoImpl implements SmsReviewDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Collection<SmsReview> list(int sb_no) {
		return sst.selectList("smsreviewns.list", sb_no);
	}

	@Override
	public void insert(SmsReview rb) {
		sst.insert("smsreviewns.insert", rb);
	}
	@Override
	public void delete(int re_no) {
		sst.delete("smsreviewns.delete", re_no);
	}
	@Override
	public void update(SmsReview rb) {
		sst.update("smsreviewns.update", rb);
	}
}
