package kr.or.ddit.lprod.service;

import java.util.Map;

import kr.or.ddit.common.model.Page;

public interface ILprodService {
	Map<String, Object> getLprodPagingList(Page page);
}
