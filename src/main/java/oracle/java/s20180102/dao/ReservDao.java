package oracle.java.s20180102.dao;

import java.util.List;

import oracle.java.s20180102.model.ReservDto;

public interface ReservDao {
	//int upReserv(String cancle);                 // 예약 취소
	//List<ReservDto> selReservList(String Id);    // 회원별 예약 리스트 조회
	//int inReserv(ReservDto reservDto);           // 예약 등록
	//int upReserv(ReservDto reservDto);           // 예약 수정
	//int delReserv(String payCode);               // 예약 삭제
	
	int updateConfirm(ReservDto resDto);
}