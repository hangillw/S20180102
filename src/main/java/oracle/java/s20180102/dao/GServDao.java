package oracle.java.s20180102.dao;

import java.util.List;


import oracle.java.s20180102.model.CodeSetDto;
import oracle.java.s20180102.model.ContentsDto;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.vo.GServContentsVo;

public interface GServDao {
	List<GServDto> selGServ(GServDto gsDto);                              // 전체 상품 조회
	//List<GServDto> selGServ(String Id, int GservNo);        // 선택 조회
	//List<GServDto> selGServ(String keyword);                // 검색(JOIN하기 때문에 return타입 변경 필요)
	//int inGServ(GServDto gServDto);                         // 상품 등록
	//int upGServ(GServDto gServDto);                         // 상품 수정
	//int delGServ(String[] GservNo);                         // 상품 일괄 삭제
	int total();
	int total(int gNo);
	GServDto oneGServ(int gServNo);
	List<ContentsDto> selCont(int gServNo);
	List<CodeSetDto> selCodeSet(String itemCode);
	int upGServ(GServContentsVo gsctVO); // 상품수정
	int inGServ(GServContentsVo gsctVO); // 상품 등록
	int selGServNo(int gNo);             // 상품 등록페이지 진입을 위한 새로운 gServNo 번호 검색, 리턴
	int upLock(GServDto lock);
	List<GServDto> selGServRes(int gNo);
	List<GServDto> selPayGuide(GServDto gsDto);
}