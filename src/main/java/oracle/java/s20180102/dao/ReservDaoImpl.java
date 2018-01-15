package oracle.java.s20180102.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.s20180102.model.ReservDto;

@Repository
public class ReservDaoImpl implements ReservDao {
	@Autowired
	private SqlSession session;
//태욱---------------------------------------------------------------------------------------------------------
	@Override
	public int updateConfirm(ReservDto resDto) {
		if(resDto.getConfirm().equals("Y")) {
			System.out.println("예스예스");
			System.out.println("resDto.getgServNo() = " + resDto.getgServNo()+ " resDto.getTourDate() = " + resDto.getTourDate());
			return session.update("upConfirmY", resDto);
		}else if(resDto.getConfirm().equals("N")){
			System.out.println("노노오노");
			System.out.println("resDto.getgServNo() = " + resDto.getgServNo()+ " resDto.getTourDate() = " + resDto.getTourDate());
			return session.update("upConfirmN", resDto);
		}
		return 0;
	}

//태욱---------------------------------------------------------------------------------------------------------

}
