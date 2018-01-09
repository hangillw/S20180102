package oracle.java.s20180102.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oracle.java.s20180102.model.CodeSetDto;
import oracle.java.s20180102.service.GServService;


@RestController
@RequestMapping("/rest")
public class GuideRestController {
	 @Autowired
	 private GServService gss;
	 
	 @RequestMapping("/selArea")
	  public List<CodeSetDto> selArea(String itemCode) {
		System.out.println("@RestController selArea  START");
		System.out.println("Controller in itemCode : " + itemCode);
		List<CodeSetDto> codeSetList = gss.selCodeSet(itemCode);
		System.out.println("codeSetList : "+codeSetList);
		return codeSetList;
		}
}
