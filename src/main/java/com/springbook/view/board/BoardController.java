package com.springbook.view.board;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller //@SessionAttributes board��� �̸����� ����� �����Ͱ� �ִٸ� �� �����͸� ���ǿ��� �ڵ����� �����϶�� �����̴�

@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//@ModelAttribute�� ��ü�� �̸��� ������ �������� ��������� view(jsp)���� ����� �����͸� �����ϴ� �뵵�ε� ����� �� �ִ�
	//@ModelAttribute�� ������ �޼���� @RequestMapping������̼��� ����� �޼ҵ庸�� ���� ȣ��
	//@ModelAttribute�޼��� �������� ���ϵ� ��ü�� �ڵ����� model������ȴ�. ���� @ModelAttribute�޼��� �������� ���ϵ� ��ü�� view���������� ����� �� �ִ�

	// �˻� ���� ��� ����
		@ModelAttribute("conditionMap")
		public Map<String, String> searchConditionMap(){
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("����", "TITLE");
			conditionMap.put("����", "CONTENT");
			return conditionMap;
		}

	
	// �� ���
	@RequestMapping(value = "/insertBoard.do") //�����������̳ʰ� BoardVO��ü ������ MultipartFile ��ü�� �����ϰ� �Ҵ���,
	//�׷���  multipartResolver��� �̸����� ��ϵ� CommonsMultipartResolver�� ������ ������ �����̳ʴ� MultipartFile��ü�� ������ �� ���� 
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {
		// ���� ���ε� ó��
				MultipartFile uploadFile = vo.getUploadFile();
				if(!uploadFile.isEmpty()){
					String fileName = uploadFile.getOriginalFilename();
					uploadFile.transferTo(new File("D:\\boardWebFile" + fileName));
				}
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	// �� ����
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
			System.out.println("��ȣ : " + vo.getSeq());
			System.out.println("���� : " + vo.getTitle());
			System.out.println("�ۼ��� : " + vo.getWriter());
			System.out.println("���� : " + vo.getContent());
			System.out.println("����� : " + vo.getRegDate());
			System.out.println("��ȸ�� : " + vo.getCnt());
			
			boardDAO.updateBoard(vo);
			return "getBoardList.do";
		}

	// �� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	// �� �� ��ȸ
		@RequestMapping("/getBoard.do") //model���� board��� �̸����� boardVO��ü�� ����ȴ� �ֳ��ϸ� @SessionAttributes("board")�������� ���� 
		public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
			model.addAttribute("board", boardDAO.getBoard(vo)); // Model ���� ����
			return "getBoard.jsp"; // View �̸� ����
		}
		
	// �� ��� �˻�
	//@RequestMapping("/getBoardList.do")
	//public String getBoardList(
		//	@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
		//	@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
		//	BoardDAO boardDAO, Model model) {
		//System.out.println("�˻� ���� : " + condition);
	//	System.out.println("�˻� �ܾ� : " + keyword);
		// Model ���� ����
	//	model.addAttribute("boardList", boardDAO.getBoardList(vo));																
		//return "getBoardList.jsp"; // View �̸� ����
	//}  
		
//		
//		// �� ��� �˻�
//		@RequestMapping("/getBoardList.do")
//		public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {		
//			// Model ���� ����
//			model.addAttribute("boardList", boardDAO.getBoardList(vo));																
//			return "getBoardList.jsp"; // View �̸� ����
//		}
		
		// �� ��� �˻�
		@RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo,  Model model) {	
			//�� üũ,. �˻����ǰ� �˻�Ű���尡 ���޵��� ���� ���� ���Ͽ� (���� ��� �α��� ���� �� getBoardList.do ��û�� ���޵ǰų� ��ȭ�鿡�� �۸��
			//���� VO��ü��SearchCondition , SearchKeyword���� )
			if(vo.getSearchCondition()==null) {
				vo.setSearchCondition("TITLE");
			}
			if(vo.getSearchKeyword()==null) {
				vo.setSearchKeyword("");
			}
			//������ ����
			model.addAttribute("boardList", boardService.getBoardList(vo));																
			return "getBoardList.jsp"; // View �̸� ����
		}
		
		
}
