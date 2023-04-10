package com.springbook.view.user;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;  //� Controller ��ü�� �˻��Ǵ��� ���� �ڵ�� �����Ϸ��� ��� ��Ʈ���� �ֻ��� �������̽� �ʿ�

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("�α��� ó��");

		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		// 3. ȭ�� �׺���̼� ���� ��Ű�����ִ� ��Ʈ�ѷ� ����
//		if (user != null) {
//			System.out.println("�α������� "+user);
//			return "getBoardList.do";
//		} else {
//			return "login";
//		}

		// 3. ȭ�� �׺���̼� ������ �����̳ʻ���
		//redirect:�� ����ϴ� ������ �丮������ �����Ǿ� �ִ��� �̸� �����ϰ� �����̷�Ʈ��
		ModelAndView mv =new ModelAndView(); //spring ��Ʈ�ѷ��� ����߱� ������ ModelAndView�� �ٲ���Ѵ�
		if (user != null) {
			mv.setViewName("redirect:getBoardList.do");
			
		} else {
			mv.setViewName("redirect:login.jsp");
		}
		return mv;

		
	}

}


