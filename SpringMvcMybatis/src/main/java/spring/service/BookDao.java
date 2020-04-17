package spring.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import spring.model.BookDto;

@Service
public class BookDao extends SqlSessionDaoSupport{

	public List<BookDto> BookNameSelect(String bname) {
		return getSqlSession().selectList("book.bookName", bname);
	}
	
	public List<BookDto> CustNameSelect(String name){
		return getSqlSession().selectList("book.custName", name);
	}
}
