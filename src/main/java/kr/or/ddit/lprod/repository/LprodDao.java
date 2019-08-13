package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import util.MybatisUtil;

public class LprodDao implements ILprodDao{

	@Override
	public List<LprodVo> getLprodList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.getLprodList");
		
		return lprodList;
	}

}
