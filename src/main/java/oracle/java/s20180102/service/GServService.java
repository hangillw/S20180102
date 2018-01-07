package oracle.java.s20180102.service;

import java.util.List;

import org.springframework.stereotype.Service;

import oracle.java.s20180102.model.GServDto;

@Service
public interface GServService {
	List<GServDto> selGServ(GServDto gsDto);                              // 전체 상품 조회
	int total();											  // 총 상품수
	int total(int gNo); 									  // 가이드별 상품수
	//List<GServDto> selGServ(String Id, String GservNo);     // 선택 조회
	//List<GServDto> selGServ(String keyword);                // 검색(JOIN하기 때문에 return타입 변경 필요)
	//int inGServ(GServDto gServDto);                         // 상품 등록
	//int upGServ(GServDto gServDto);                         // 상품 수정
	//int delGServ(String[] GservNo);                         // 상품 일괄 삭제
	
	
}