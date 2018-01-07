package oracle.java.s20180102.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.service.GServService;
import oracle.java.s20180102.service.GuideService;
import oracle.java.s20180102.service.Paging;

@Controller
public class GuideController {
	@Autowired
	private GServService gss;
	
//	@Autowired
//	private GuideService gs;

//	@RequestMapping(value="list")
//	public String list(Model model) {
//		return "";
//	}
	
	@RequestMapping(value="service_guide")
	public String service_guide(String gNo, GServDto gsDto, String currentPage, Model model) {
		int total = 0;
		if(gNo!=null) {
			total = gss.total(Integer.parseInt(gNo)); 
		}else {
			total = gss.total();
		}
		System.out.println("total=>" + total);
		System.out.println("currentPage=>" + currentPage);
		Paging pg = new Paging(total, currentPage);
		gsDto.setStart(pg.getStart());
		gsDto.setEnd(pg.getEnd());
		List<GServDto> list = gss.selGServ(gsDto);
		model.addAttribute("list", list);
		model.addAttribute("pg",pg);
		
		return "service_guide";
	}

	
	/*
	@RequestMapping(value="list")
	public String list(Emp emp, String currentPage, Model model) {
		int total = es.total();
		System.out.println("total=>" + total);
		System.out.println("currentPage=>" + currentPage);
		Paging pg = new Paging(total, currentPage);
		emp.setStart(pg.getStart());
		emp.setEnd(pg.getEnd());
		List<Emp> list = es.list(emp);
	//	model.addAttribute("k33","k33333");
		model.addAttribute("list",list);
		model.addAttribute("pg",pg);
		return "list";
	}
	 
	 */
}