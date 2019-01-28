package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsChaReply;
import com.pub.sms.model.SmsMem;

@Repository
public class SmsMemDaoImpl implements SmsMemDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	
	public SmsMem select(String mem_id) {
		SmsMem mem = (SmsMem) sst.selectOne("smsMemns.select", mem_id);
		return mem;
	}

	public int insert(SmsMem mem) {
		int result = 0;
		try {
			sst.insert("smsMemns.insert",mem);
			result = 1;
		} catch (Exception e) {	System.out.println(e.getMessage());	}
		return result;
	}

	@Override
	public int firstUpdate(SmsMem mem) {
		int result = 0;
		try {
			sst.update("smsMemns.firstUpdate",mem);
			result = 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public SmsMem memNick(int mem_no) {
		//멤버 넘버로 회원목록을 조회하는 SQL
		//신고게시판에서 멤버 넘버를 이용하여 닉네임을 불러오기 위한 목적으로 만듬
		return (SmsMem) sst.selectOne("smsMemns.selectnick", mem_no);
	}

	@Override
	public SmsMem nickSelect(String nickname) {
		//닉네임으로 회원목록을 조회하는 SQL
		return (SmsMem) sst.selectOne("smsMemns.nickselect", nickname);
	}

	@Override
	public int updateImg(SmsMem mem) {
		int result = 0;
		try {
			sst.update("smsMemns.updateImg",mem);
			result = 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
