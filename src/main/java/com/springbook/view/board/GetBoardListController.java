package com.springbook.view.board;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		
		// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
//		// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ���� �����Ѵ�. �׷��� �����̶�� ���� Ŭ���̾�Ʈ �������� �ϳ���
		//�޸𸮿� �����Ǿ� Ŭ���̾�Ʈ�� ���� ������ �����ϱ� ���� �����Ѵ� ���� ���ǿ� ���� ������ ����Ǹ� �� ����
		//������ �δ��� �� �� �ۿ� ����
		//�ᱹ ���� ����� ������ �ƴ�  HttpServletRequest��ü�� �����ϴ� ���� �´�
		//HttpServletRequestŬ���̾�Ʈ�� ��û���� �����Ǿ��ٰ� ����޽����� Ŭ���̾�Ʈ�� ������ �Ǹ� �ڵ�����
		//�����Ǵ� ��ȸ�� ��ü�� ���� �˻� ����� ������ �ƴ� HttpServletRequest��ü�� �����Ͽ� �����ϸ� 
		//������ �δ��� ���� �ʰ� �����͸� ������ �� �ִ�
		//������ GetBoardListController�� �˻� ����� HttpSession�� �ƴϰ� HttpServletRequest�� �ƴ�
		//ModelAndView�� �����ϰ� �ִ�. ModelAndView�� �𵨰� �� ������ ��� �����Ͽ� ������ �� ���
		//dispatcherServlet�� conttroller�� ������ ModelAndView��ü���� �� ������ ������ ����
		//HttpServletRequest��ü�� �˻� ����� �ش��ϴ� �� ������ �����Ͽ� jsp�� ������ �Ѵ�
		//���� jsp���Ͽ����� �˻������ ������ �ƴ� HttpServletRequest�κ��� ���� �� �� �ִ�.
		
	/*	HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
		*/
		
		// 3. �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); 	// Model ���� ����
		mav.setViewName("getBoardList"); 	// View ���� ����
		return mav;
	}
}