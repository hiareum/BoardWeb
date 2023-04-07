package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;



//mapŸ���� �÷����� ��������� ���� �Խ��� ���α׷��� �ʿ��� ��� controller��ü���� ����ϰ� ����
public class HandlerMapping {

	private Map<String,Controller>mappings;
	public HandlerMapping() {
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/logout.do", new LogoutController());
		
		
	}
	
	//path�� �ش��ϴ� controller��ü�� HashMap�÷������κ��� �˻��Ͽ� ����
	public Controller getController(String path){
		return mappings.get(path);
		
	}
}
