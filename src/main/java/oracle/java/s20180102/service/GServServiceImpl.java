package oracle.java.s20180102.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.GServDao;
import oracle.java.s20180102.model.GServDto;

@Service
public class GServServiceImpl implements GServService{
	
	@Autowired
	private GServDao gsDao;
	
	@Override
	public int total() {
		// TODO Auto-generated method stub
		return gsDao.total();
	}
	@Override
	public int total(int gNo) {
		// TODO Auto-generated method stub
		return gsDao.total(gNo);
	}
	@Override
	public List<GServDto> selGServ(GServDto gsDto) {
		// TODO Auto-generated method stub
		return gsDao.selGServ(gsDto);
	}
}