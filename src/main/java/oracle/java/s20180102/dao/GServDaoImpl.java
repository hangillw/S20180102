package oracle.java.s20180102.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;

import oracle.java.s20180102.model.CodeSetDto;
import oracle.java.s20180102.model.ContentsDto;
import oracle.java.s20180102.model.GServDto;

@Repository
public class GServDaoImpl implements GServDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public int total() { return session.selectOne("total");	}
	@Override
	public int total(int gNo) {	return session.selectOne("gNoServTotal",gNo);	}
	@Override
	public List<GServDto> selGServ(GServDto gsDto) {
		// TODO Auto-generated method stub
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
}