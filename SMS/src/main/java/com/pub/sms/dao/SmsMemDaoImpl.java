package com.pub.sms.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsMem;

@Repository
public class SmsMemDaoImpl implements SmsMemDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	
	public SmsMem select(String mem_id) {
		System.out.println("dao mem_id : "+mem_id);
		SmsMem mem = (SmsMem) sst.selectOne("smsMemns.select", mem_id);
		System.out.println( "dao mem = "+mem );
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
		return (SmsMem) sst.selectOne("smsMemns.selectnick", mem_no);
	}

	@Override
	public SmsMem nickSelect(String nickname) {
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
