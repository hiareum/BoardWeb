package com.springbook.view.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;


import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ���� ó��");
		
		// 1. ����� �Է� ���� ����
		// request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		String seq = request.getParameter("seq");
		
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		
		vo.setContent(content);
		
		vo.setSeq(Integer.parseInt(seq));
		
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. ȭ�� �׺���̼�
	/*	ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return "getBoardList";	  */
		
	
	
		return "getBoardList.do";
		
	}

}
