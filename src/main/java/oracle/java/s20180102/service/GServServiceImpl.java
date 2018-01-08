package oracle.java.s20180102.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.GServDao;
import oracle.java.s20180102.model.ContentsDto;
import oracle.java.s20180102.model.GServDto;

@Service
public class GServServiceImpl implements GServService{
	
	@Autowired
	private GServDao gsDao;
	
	@Override
	public int total() {
		return gsDao.total();
	}
	@Override
	public int total(int gNo) {
		return gsDao.total(gNo);
	}
	@Override
	public List<GServDto> selGServ(GServDto gsDto) {
		return gsDao.selGServ(gsDto);
	}
	@Override
	public GServDto oneGServ(int gServNo) {
		return gsDao.oneGServ(gServNo);
	}
	@Override
	public List<ContentsDto> selCont(int gServNo) {
		return gsDao.selCont(gServNo);
	}
	
}