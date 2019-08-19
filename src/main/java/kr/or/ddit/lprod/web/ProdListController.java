package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.ProdVo;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDao;

@WebServlet("/prodList")
public class ProdListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	private static final Logger logger = LoggerFactory.getLogger(ProdListController.class);
	
	private ILprodDao prodDao;

	@Override
	public void init() throws ServletException {
		prodDao = new LprodDao();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lprodGu = request.getParameter("lprod_gu");
		logger.debug("prod : {}", lprodGu);
		
		List<ProdVo> prodList = prodDao.getProd(lprodGu);
		request.setAttribute("prodList", prodList);
		request.getRequestDispatcher("/lprod/prodList.jsp").forward(request, response);		
		
	}

}
