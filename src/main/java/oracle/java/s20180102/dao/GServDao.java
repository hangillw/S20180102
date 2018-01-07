package oracle.java.s20180102.dao;

import java.util.List;

import oracle.java.s20180102.model.GServDto;

public interface GServDao {
	List<GServDto> selGServ(GServDto gsDto);                              // 전체 상품 조회
	//List<GServDto> selGServ(String Id, int GservNo);        // 선택 조회
	//List<GServDto> selGServ(String keyword);                // 검색(JOIN하기 때문에 return타입 변경 필요)
	//int inGServ(GServDto gServDto);                         // 상품 등록
	//int upGServ(GServDto gServDto);                         // 상품 수정
	//int delGServ(String[] GservNo);                         // 상품 일괄 삭제
	int total();
	int total(int gNo);
	
}