package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.model.ProdVo;
import util.MybatisUtil;

public class LprodDao implements ILprodDao{

	@Override
	public List<LprodVo> getLprodList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.getLprodList");
		
		return lprodList;
	}

	@Override
	public List<ProdVo> getProd(String lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<ProdVo> prodList = sqlSession.selectList("lprod.getProd", lprod_gu);
		return prodList;
	}

	
	//lprod 페이징 리스트 조회
	@Override
	public List<LprodVo> getLprodPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}
	
	//전체 lprod 건수 조회
	@Override
	public int getLprodTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("lprod.getLprodTotalCnt");
	}

}
