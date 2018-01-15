package oracle.java.s20180102.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.s20180102.dao.ReservDao;
import oracle.java.s20180102.model.ContentsDto;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.ReservDto;
import oracle.java.s20180102.service.GServService;
import oracle.java.s20180102.service.Paging;
import oracle.java.s20180102.service.ReservService;

@Controller
public class GuideController {
	@Autowired
	private GServService gss;
	
	@Autowired
	private ReservService ress;
	
	
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
		System.out.println("gServNo = " + gServNo);
		GServDto gsDto = gss.oneGServ(Integer.parseInt(gServNo));
		//System.out.println("gsDto = " + gsDto);
		List<ContentsDto> cDtoList = gss.selCont(Integer.parseInt(gServNo));
		//System.out.println("cDtoList = " + cDtoList);
		System.out.println("수정 페이지로 넘어갈때 gNo = "+gsDto.getgNo());
		model.addAttribute("gsDto", gsDto);
		model.addAttribute("cDtoList", cDtoList);
		return "selGServForm";
	}
	
	@RequestMapping(value="inGServForm")
	public String inGServForm(String gNo, Model model) {
		System.out.println("gNo = " + gNo);
		GServDto gsDto = new GServDto();
		int gServNo = gss.selGServNo(Integer.parseInt(gNo));
		gsDto.setgNo(Integer.parseInt(gNo));
		gsDto.setgServNo(gServNo);
		System.out.println("등록 페이지로 넘어갈때 gNo = "+ gsDto.getgNo());
		model.addAttribute("gsDto", gsDto);
		return "inGServForm";
	}
	
	@RequestMapping(value="tourDiary")
	public String tourDiary(String gNo, Model model) {
		System.out.println("gNo = " + gNo);
		//gsDto.setgNo(Integer.parseInt(gNo));
		
		List<GServDto> gsDtolist = gss.selGServRes(Integer.parseInt(gNo));
		
		for(int i= 0; i < gsDtolist.size(); i++) {
			String[] pt = gsDtolist.get(i).getPickUpTime().split(":");
			int lt = Integer.parseInt(gsDtolist.get(i).getgServLeadTime());
			int sum = Integer.parseInt(pt[0])+lt;
			String endTime = Integer.toString(sum);
			endTime = endTime + ":00";
			System.out.println("endTime = "+endTime);
			gsDtolist.get(i).setEndTime(endTime);
		}
		
		
		model.addAttribute("gsList", gsDtolist);
		System.out.println("tourList = > " + gsDtolist.get(0).getTourDate());
		System.out.println("title = > " + gsDtolist.get(0).getgServTitle());
		return "tourDiary";
	}
	@RequestMapping(value="confirmResForm")
	public String confirmResForm(String gServNo, String tourDate, Model model) {
		model.addAttribute("gServNo", gServNo);
		model.addAttribute("tourDate", tourDate);
		return "confirmResForm";
	}
	@RequestMapping(value="confirmResPro")
	public String confirmResPro(ReservDto resDto , Model model) {
		System.out.println("resDto.getTourDate() = "+resDto.getTourDate());
		int result = ress.updateConfirm(resDto);
		model.addAttribute("result", result);
		
		return "confirmResPro";
	}
}