package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.MemDto;

@Service
public class InsertService {

	MemDao dao;
	
	@Autowired
	public void setDao(MemDao dao) {
		this.dao = dao;
	}
	
	public int insertMem(MemDto dto) {
		
		return dao.insert(dto);
	}
	
	
}







