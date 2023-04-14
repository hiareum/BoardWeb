package com.springbook.biz.board;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Xml������ �ݵ�� �� �ϳ��� ��Ʈ ������Ʈ�� ������ �Ѵ�. ���� �Խñ� ����� xml�� ǥ���ؾ� �ϹǷ� boardVO��ü ��������
//��Ʈ ������Ʈ�� ����� �� �ٸ� �ڹ� Ŭ������ �ʿ�
@XmlRootElement(name = "boardList") //��Ʈ ������Ʈ�� ����
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	@XmlElement(name = "board") //�� ������ ������ boardList�� ������Ʈ �̸����� ��� ���� board�� ����
	private List<BoardVO> boardList;

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
}