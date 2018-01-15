package oracle.java.s20180102.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.ReservDao;
import oracle.java.s20180102.model.ReservDto;

@Service
public class ReservServiceImpl implements ReservService {

	@Autowired
	private ReservDao resDao;
	
	@Override
	public int updateConfirm(ReservDto resDto) {
		// TODO Auto-generated method stub
		return resDao.updateConfirm(resDto);
	}

}
