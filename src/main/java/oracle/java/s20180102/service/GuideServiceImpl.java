package oracle.java.s20180102.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.GuideDao;
import oracle.java.s20180102.model.GuideDto;

@Service
public class GuideServiceImpl implements GuideService {
	@Autowired
	private GuideDao gDao;
	
	/*@Override
	public int totalGuide() {
		
		return gDao.totalGuide();
	}
	
	@Override
	public List<GuideDto> g_list(PagingDto pDto) {
	
		return gDao.g_list(pDto);
	}

	@Override
	public GuideDto g_info(String memberId) {
		return gDao.g_info(memberId);
	}*/

/*	@Override
	public int g_delete(String memberId) {
		return gDao.g_delete(memberId);
	}
*/
	@Override
	public GuideDto selOneGuide(int gNo) {
		// TODO Auto-generated method stub
		return gDao.selOneGuide(gNo);
	}
	@Override
	public int upCostGuide(GuideDto gDto) {
		// TODO Auto-generated method stub
		return gDao.upCostGuide(gDto);
	}
}
