package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceCilent {
	public static void main(String[] args) {
//1.�����������̳� ����
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
	//2.������ �����̳ʷκ��� boardserviceImpl ��ü(boardservice)�� LookUp��
		BoardService boardService=(BoardService) container.getBean("boardService");
		//3.�� ��� ��� �׽�Ʈ
		BoardVO vo=new BoardVO();
		vo.setTitle("�ӽ�����");
		vo.setWriter("ȫ�浿");
		vo.setContent("�ӽó���...");
		boardService.insertBoard(vo);
		
		//4.�� ��� �˻� ��� �׽�Ʈ
		List<BoardVO> boardList=boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("-->"+board.toString());
		}
		
		//5.������ �����̳� ����
		//���������� H2�� ������ �÷����
		/*
		 <dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<version>2.1.214</version>
		</dependency>
		 
		  
		  */
	}
}
