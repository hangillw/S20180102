package oracle.java.s20180102.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;

import oracle.java.s20180102.model.CodeSetDto;
import oracle.java.s20180102.model.ContentsDto;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.vo.GServContentsVo;

@Repository
public class GServDaoImpl implements GServDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public int total() { return session.selectOne("totalGServ");	}
	
	@Override
	public int total(int gNo) {	
		int gNolength = Integer.toString(gNo).length();
		int result = 0;
		if(gNolength>6) {
			result = 1;
		}else {
			result =  session.selectOne("totalGNoServ", gNo);
		}
			
		return result;	
	}
	
	@Override
	public List<GServDto> selGServ(GServDto gsDto) {
		// TODO Auto-generated method stub
		System.out.println("gsDto.getgNo() = "+gsDto.getgNo());
		System.out.println("gsDto.getgServNo() = "+gsDto.getgServNo());
		return session.selectList("listAll", gsDto);
	}
	@Override
	public GServDto oneGServ(int gServNo) {
		// TODO Auto-generated method stub
		return session.selectOne("oneGServ", gServNo);
	}
	@Override
	public List<ContentsDto> selCont(int gServNo) {
		// TODO Auto-generated method stub
		return session.selectList("listContents", gServNo);
	}
	@Override
	public List<CodeSetDto> selCodeSet(String itemCode) {
		// TODO Auto-generated method stub
		//int code = Integer.parseInt(itemCode);
		System.out.println("gServDaoImpl->selCodeSet : "+itemCode);
		return session.selectList("listCodeSet", itemCode);
	}
	@Override
	public int upGServ(GServContentsVo gsctVO) {
		int gServNo = gsctVO.getgServNo();
		//List<ContentsDto> cntList = session.selectList("listContents", gServNo); 
		session.delete("deleteContents", gServNo);
		for(int i = 0; i < gsctVO.getgServOrder().length; i++) {
			if(gsctVO.getgServIntro()[i]==null && gsctVO.getgServIntro()[i].length()>1) {
				continue;
			}
			ContentsDto ctDto = new ContentsDto();
			ctDto.setgServNo(gsctVO.getgServNo());
			/*if(gsctVO.getgServOrder().length>cntList.size()) {
			ctDto.setgServIntro(gsctVO.getgServIntro()[i] == null ? gsctVO.getgServIntro()[i] : cntList.get(i).getgServIntro());
			ctDto.setgServOrder(gsctVO.getgServOrder()[i] == null ? gsctVO.getgServOrder()[i] : cntList.get(i).getgServOrder());
			ctDto.setImgSrc(gsctVO.getImgSrc()[i] == null ? gsctVO.getImgSrc()[i] : cntList.get(i).getImgSrc());
			}*/
			ctDto.setgServIntro(gsctVO.getgServIntro()[i]);
			ctDto.setgServOrder(gsctVO.getgServOrder()[i]);
			ctDto.setImgSrc(gsctVO.getImgSrc()[i]);
			System.out.println(gsctVO.getImgSrc()[i]);
			/*session.update("updateContents", ctDto);*/
			session.insert("insertContents", ctDto);
			System.out.println(i+"번 통과");
		}
		
		/*System.out.println("gsctVO.getgServTitle() = "+gsctVO.getgServTitle());
		System.out.println("gsctVO.getgNo()"+gsctVO.getgNo());
		System.out.println("gsctVO.getgServGps() = "+gsctVO.getgServGps());
		System.out.println("gsctVO.getgServLeadTime() = "+gsctVO.getgServLeadTime());
		System.out.println("gsctVO.getgServSub() = "+gsctVO.getgServSub());
		if(gsctVO.getgServArea()==null) {
			System.out.println("gsctVO.getgServArea() === null");
		}else {
			System.out.println("gsctVO.getgServArea() === notNull");
		}
		System.out.println("gsctVO.getgServArea() = "+gsctVO.getgServArea());
		System.out.println("gsctVO.getgServPrice() = "+gsctVO.getgServPrice());
		System.out.println("gsctVO.getgServLang() = "+gsctVO.getgServLang());
		System.out.println("gsctVO.getServTag() = "+gsctVO.getServTag());
		System.out.println("gsctVO.getgServDay() = "+gsctVO.getgServDay());
		System.out.println("gsctVO.getgServEDate() = "+gsctVO.getgServEDate());
		System.out.println("gsctVO.getgServSDate() = "+gsctVO.getgServSDate());
		System.out.println("gsctVO.getPickUpLoc() = "+gsctVO.getPickUpLoc());
		System.out.println("gsctVO.getPickUpTime() = "+gsctVO.getPickUpTime());
		System.out.println("gsctVO.getpInclude() = "+gsctVO.getpInclude());
		System.out.println("gsctVO.getNotPInclude() = "+gsctVO.getNotPInclude());
		System.out.println("gsctVO.getCaution() = "+gsctVO.getCaution());
		System.out.println("gsctVO.getgServLock() = "+gsctVO.getgServLock());*/
		return session.update("updateGServ", gsctVO);
	}
	
	
	@Override
	public int selGServNo(int gNo) {
		System.out.println("gNo = " + gNo );
		int result = session.selectOne("selGServNo", gNo);
		System.out.println("result(NewGServNo) = "+result);
		return result;
	}
	
	@Override
	public int inGServ(GServContentsVo gsctVO) {
		int result = 0;
		result = session.update("inGServ", gsctVO);
		for(int i = 0; i < gsctVO.getgServOrder().length; i++) {
			if(gsctVO.getgServIntro()[i]==null && gsctVO.getgServIntro()[i].length()>1) {
				continue;
			}
			ContentsDto ctDto = new ContentsDto();
			System.out.println("gsctVO.getgServNo() = "+gsctVO.getgServNo());
			System.out.println("gsctVO.getgServIntro()["+i+"] = "+gsctVO.getgServIntro()[i]);
			System.out.println("gsctVO.getgServOrder()["+i+"] = "+gsctVO.getgServOrder()[i]);
			System.out.println("gsctVO.getImgSrc()["+i+"] = "+gsctVO.getImgSrc()[i]);
			ctDto.setgServNo(gsctVO.getgServNo());
			ctDto.setgServIntro(gsctVO.getgServIntro()[i]);
			ctDto.setgServOrder(gsctVO.getgServOrder()[i]);
			ctDto.setImgSrc(gsctVO.getImgSrc()[i]);
			System.out.println(gsctVO.getImgSrc()[i]);
			/*session.update("updateContents", ctDto);*/
			session.insert("insertContents", ctDto);
			System.out.println(i+"번 통과");
		}
		
		/*System.out.println("gsctVO.getgServTitle() = "+gsctVO.getgServTitle());
		System.out.println("gsctVO.getgNo()"+gsctVO.getgNo());
		System.out.println("gsctVO.getgServGps() = "+gsctVO.getgServGps());
		System.out.println("gsctVO.getgServLeadTime() = "+gsctVO.getgServLeadTime());
		System.out.println("gsctVO.getgServSub() = "+gsctVO.getgServSub());
		if(gsctVO.getgServArea()==null) {
			System.out.println("gsctVO.getgServArea() === null");
		}else {
			System.out.println("gsctVO.getgServArea() === notNull");
		}
		System.out.println("gsctVO.getgServArea() = "+gsctVO.getgServArea());
		System.out.println("gsctVO.getgServPrice() = "+gsctVO.getgServPrice());
		System.out.println("gsctVO.getgServLang() = "+gsctVO.getgServLang());
		System.out.println("gsctVO.getServTag() = "+gsctVO.getServTag());
		System.out.println("gsctVO.getgServDay() = "+gsctVO.getgServDay());
		System.out.println("gsctVO.getgServEDate() = "+gsctVO.getgServEDate());
		System.out.println("gsctVO.getgServSDate() = "+gsctVO.getgServSDate());
		System.out.println("gsctVO.getPickUpLoc() = "+gsctVO.getPickUpLoc());
		System.out.println("gsctVO.getPickUpTime() = "+gsctVO.getPickUpTime());
		System.out.println("gsctVO.getpInclude() = "+gsctVO.getpInclude());
		System.out.println("gsctVO.getNotPInclude() = "+gsctVO.getNotPInclude());
		System.out.println("gsctVO.getCaution() = "+gsctVO.getCaution());
		System.out.println("gsctVO.getgServLock() = "+gsctVO.getgServLock());*/
		return result;
	}
	@Override
	public int upLock(GServDto lock) {
		return session.update("uplock", lock);
	}
	@Override
	public List<GServDto> selGServRes(int gNo) {
		// TODO Auto-generated method stub
		return session.selectList("gServResList", gNo);
	}
}