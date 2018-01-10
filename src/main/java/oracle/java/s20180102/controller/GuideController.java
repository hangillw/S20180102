package oracle.java.s20180102.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.java.s20180102.model.ContentsDto;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.service.GServService;
import oracle.java.s20180102.service.Paging;
import oracle.java.s20180102.vo.GServConTentsVo;

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
		gsDto.setgNo(Integer.parseInt(gNo));
		List<GServDto> list = gss.selGServ(gsDto);
		model.addAttribute("list", list);
		model.addAttribute("pg",pg);
		
		return "service_guide";
	}
	
	@RequestMapping(value="selGServForm")
	public String selGServForm(String gServNo, Model model) {
		GServDto gsDto = gss.oneGServ(Integer.parseInt(gServNo));
		//System.out.println("gsDto = " + gsDto);
		List<ContentsDto> cDtoList = gss.selCont(Integer.parseInt(gServNo));
		//System.out.println("cDtoList = " + cDtoList);
		System.out.println("수정 페이지로 넘어갈때 gNo = "+gsDto.getgNo());
		model.addAttribute("gsDto", gsDto);
		model.addAttribute("cDtoList", cDtoList);
		return "selGServForm";
	}
	@RequestMapping(value="selGServPro", method=RequestMethod.POST)
	public String selGServPro(GServConTentsVo gsctVO, Model model) {
		//List<ContentsDto> ctDtoList,
		System.out.println("gsDto = " + gsctVO);
		System.out.println("gsDto.gServNo = " + gsctVO.getgServGps());
		//System.out.println("csDtoList = " + ctDtoList.get(0).getgServIntro());
		//System.out.println("csDtoList = " + ctDtoList.get(1).getgServIntro());
		//gss.update(gsDto);
		
		
		model.addAttribute("gNo", gsctVO.getgNo());
		return "redirect:service_guide.do";
	}
}