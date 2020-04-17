package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import spring.model.BookDto;
import spring.service.BookDao;

@Controller
public class BookController {
	
	@Autowired
	private BookDao dao;
	
	@RequestMapping(value="/book/bookInfo.do", method = RequestMethod.GET)
	public String bookForm() throws Exception {
		return "/book/bookInfo";
	}
	
	@RequestMapping(value = "/book/bookSearch.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String bookName(String bname) {
		List<BookDto> list = dao.BookNameSelect(bname);
		Gson json = new Gson();
		System.out.println(json.toJson(list));
		return json.toJson(list);
	}
	
	@RequestMapping(value = "/book/custSearch.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String custName(String name) {
		List<BookDto> list = dao.CustNameSelect(name);
		Gson json = new Gson();
		System.out.println(json.toJson(list));
		return json.toJson(list);
	}

}
