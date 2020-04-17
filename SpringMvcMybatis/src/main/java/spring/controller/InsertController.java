package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.MemDto;
import spring.service.InsertService;

@Controller
@RequestMapping("/insert.do")
public class InsertController {

	InsertService service;
	@Autowired
	public void setService(InsertService service) {
		this.service = service;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String insertForm() {
		return "insertForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("mem")MemDto dto) {
		service.insertMem(dto);
		return "insertResult";
	}
	
}







