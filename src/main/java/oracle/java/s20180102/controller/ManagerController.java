package oracle.java.s20180102.controller;


import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.service.GServService;
import oracle.java.s20180102.service.MemberService;
import oracle.java.s20180102.service.Paging;

import java.util.List;

//import org.rosuda.JRI.REXP;
//import org.rosuda.JRI.Rengine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
	@Autowired
	private GServService gss;
//	@Autowired
//	private MemberService es;

/*	@RequestMapping(value="list")
	public String list(Model model) {
		return "";
	}*/
//태욱----------------------------------------------------------------------------------------------------	
	@RequestMapping(value="service_manager")
	public String service_manager(String searchServ, GServDto gsDto, String currentPage, Model model) {
		int total = 0;
			gsDto.setgNo(0);
			gsDto.setgServNo(0);
			System.out.println("searchServ = "+searchServ);
		if (searchServ != null && !searchServ.equals("")) {
			if (searchServ.length() == 5) {
				total = gss.total(Integer.parseInt(searchServ));
				gsDto.setgNo(Integer.parseInt(searchServ));
				System.out.println("gsDto.getgNo in Controller = "+gsDto.getgNo());
			} else if(searchServ.length() > 5){
				gsDto.setgServNo(Integer.parseInt(searchServ));
				total = gss.total(Integer.parseInt(searchServ));
				System.out.println("gsDto.getgServ in Controller = "+gsDto.getgServNo());
			}
		}else {
			total = gss.total();
		}
//		System.out.println("total=>" + total);
//		System.out.println("currentPage=>" + currentPage);
		Paging pg = new Paging(total, currentPage);
//		System.out.println("pg.getStart() = " + pg.getStart());
//		System.out.println("pg.getEnd() = " + pg.getEnd());
		gsDto.setStart(pg.getStart());
		gsDto.setEnd(pg.getEnd());
		/*if(searchServ!=null) {
		gsDto.setgNo(Integer.parseInt(searchServ));
		}*/
		List<GServDto> list = gss.selGServ(gsDto);
		model.addAttribute("list", list);
		System.out.println("list.length = " + list.size());
		model.addAttribute("pg",pg);
		model.addAttribute("searchServ", searchServ);
		
		return "service_manager";
	}
//태욱----------------------------------------------------------------------------------------------------
}