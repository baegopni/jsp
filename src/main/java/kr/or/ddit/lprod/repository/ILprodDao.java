package kr.or.ddit.lprod.repository;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.model.ProdVo;

public interface ILprodDao {
	List<LprodVo> getLprodList();
	
	List<ProdVo> getProd(String lprod_gu);
}
