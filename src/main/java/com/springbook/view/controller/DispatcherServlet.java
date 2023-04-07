package com.springbook.view.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//DispatcherServlet�� Ŭ���̾�Ʈ�� ��û�� ���� ���� �޾Ƶ��̴� Front Controller, ������ Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� DispatcherServlet�� �ϴ� ���� ���� ������, �������� ��û ó�� �� ��Ʈ�ѿ�
//Ŭ���̾��� ��û�� ���� DispatcherServlet�� HandlerMapping�� ���� Controller��ü�� �˻��ϰ�, �˻��� Controller�� ����
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	public DispatcherServlet() {
		super();

	}
	
	//���� ��ü�� ������ �� �ɹ����� �ʱ�ȭ�ϱ� ���� �ڵ����� ����, DispatcherServlet�� �̷��� ����
	//handlerMapping�� viewResolver�� �̿��Ͽ� ������� ��û�� ó��
	public void init(ServletConfig config) throws ServletException {

		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path : "+path);

		// 2.handlerMapping �� ���ؼ� path�� �ش��ϴ� ��Ʈ�� �˻�
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. �˻��� ��Ʈ�ѷ� ����
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ�� �˻�
		String view = null;
		
		if(!viewName.contains(".do")) {
			view=viewResolver.getView(viewName);
			System.out.println("��� : "+view);
		}else {
			view = viewName;
		}
		
		// 5. �˻��� ȭ������ �̵�
		response.sendRedirect(view);
		
	}

	public void destroy() {

	}
}