package oracle.java.s20180102.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import oracle.java.s20180102.service.GServService;
import oracle.java.s20180102.service.ReviewService;
import oracle.java.s20180102.vo.GServContentsVo;

@Controller
public class UploadController {

  private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

  	@Resource(name = "uploadPath")
	  private String uploadPath;
  	
  	@Autowired
  	private GServService gss;
  	
  	/*@Autowired
	private ReviewService revs;*/
  
 /* @RequestMapping(value = "inRImg", method = RequestMethod.GET)
  public void inRImg() {
		System.out.println("uploadForm GET Start");
 }*/

  
/* 후기 등록  */
  
  /*@RequestMapping(value = "inRImg", method = RequestMethod.POST)
  public String inRImg(@RequestParam("images") List<MultipartFile> rImg, HttpServletRequest request, Model model) throws Exception {
		String[] savedName = new String[rImg.size()];
		for(int i=0; i<rImg.size(); i++) {
			savedName[i] = uploadFile(rImg.get(i).getOriginalFilename(), rImg.get(i).getBytes());
		}
	    model.addAttribute("savedName", savedName);
    return "inRImg";
  }*/
  
  /*@RequestMapping(value="inReviewPro", method = RequestMethod.POST)
	public String writeReviewPro(ReviewDto revDto, HttpServletRequest request, Model model) {
		String savedName = "";
		MultipartFile[] images = revDto.getImages();
		for(int i=0; i<images.length; i++) {
			try {
				if(i==0) {
					savedName = uploadFile(images[i].getOriginalFilename(), images[i].getBytes());
				} else {
					savedName +=","+uploadFile(images[i].getOriginalFilename(), images[i].getBytes());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			revDto.setrImg(savedName);   // rImg DB 저장 
		}
		revs.inReview(revDto);

		// currentPage 보내줘야함.
		return "redirect:review_member.do";
	}*/
  
  	
//태욱----------------------------------------------------------------------------------------------------
  @RequestMapping(value="selGServPro", method=RequestMethod.POST)
	public String selGServPro(GServContentsVo gsctVO, Model model) {
		System.out.println("gsDto = " + gsctVO);
		String[] savedName = new String[(gsctVO.getgServIntro()).length];
		String gServDay = "";
		//System.out.println("gServArea = " + gsctVO.getgServArea());
		for(int i = 0; i < gsctVO.getDays().length; i++) {
			gServDay +=  gsctVO.getDays()[i];
		}
		
		gsctVO.setgServDay(gServDay);
		gsctVO.setgServGps(gsctVO.getPickUpLoc());
		MultipartFile[] images = gsctVO.getImgfile();
		System.out.println("images.length = " + images.length);
		if(images!=null) {
		for(int i = 0; i<images.length+1; i++) {
			try {
				if(i==0) {
				//if(i==0 || images[1].getOriginalFilename().equals("")) {
					savedName[i] = null;
				} else {
					if(images[i].getBytes() != null) {
					savedName[i] = uploadFile(images[i-1].getOriginalFilename(), images[i-1].getBytes());
					System.out.println("savedName["+i+"] = " + savedName[i]);
					}
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			gsctVO.setImgSrc(savedName);   // rImg DB 저장 
			System.out.println("savedName.length = " + savedName.length);
			}
		}
		gss.upGServ(gsctVO);
		
		model.addAttribute("gNo", gsctVO.getgNo());
		return "redirect:service_guide.do";
  }
  
  @RequestMapping(value="inGServPro", method=RequestMethod.POST)
	public String inGServPro(GServContentsVo gsctVO, Model model) {
		System.out.println("gsDto = " + gsctVO);
		String[] savedName = new String[(gsctVO.getgServIntro()).length];
		String gServDay = "";
		//System.out.println("gServArea = " + gsctVO.getgServArea());
		for(int i = 0; i < gsctVO.getDays().length; i++) {
			gServDay +=  gsctVO.getDays()[i];
		}
		
		gsctVO.setgServDay(gServDay);
		gsctVO.setgServGps(gsctVO.getPickUpLoc());
		MultipartFile[] images = gsctVO.getImgfile();
		System.out.println("images.length = " + images.length);
		if(images!=null) {
		for(int i = 0; i<images.length+1; i++) {
			try {
				if(i==0) {
					savedName[i] = null;
				} else {
					if(images[i].getBytes() != null) {
					savedName[i] = uploadFile(images[i-1].getOriginalFilename(), images[i-1].getBytes());
					System.out.println("savedName["+i+"] = " + savedName[i]);
					}
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			gsctVO.setImgSrc(savedName);   // rImg DB 저장 
			System.out.println("savedName.length = " + savedName.length);
			}
		}
		gss.inGServ(gsctVO);
		
		model.addAttribute("gNo", gsctVO.getgNo());
		return "redirect:service_guide.do";
}
//태욱----------------------------------------------------------------------------------------------------
  
  
  private String uploadFile(String originalName, byte[] fileData) throws Exception {

    UUID uid = UUID.randomUUID();

    String savedName = uid.toString() + "_" + originalName;

    File target = new File(uploadPath, savedName);

    FileCopyUtils.copy(fileData, target);

    return savedName;

  }
  
}