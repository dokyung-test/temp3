package spring.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.MemDto;

public class MemDao extends SqlSessionDaoSupport{

	public int insert(MemDto dto) {
		int i = 0;
		i = getSqlSession().insert("member.addMember", dto);
		return i;	
	}
	
}




