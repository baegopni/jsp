package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.model.ProdVo;

public interface ILprodDao {
	List<LprodVo> getLprodList();
	
	List<ProdVo> getProd(String lprod_gu);
	
	
	//lprod 페이징 리스트 조회
	List<LprodVo> getLprodPagingList(SqlSession sqlSession, Page page);
	
	//전체 lprod 건수 조회
	int getLprodTotalCnt(SqlSession sqlSession);
}
