package com.springbook.biz.board;



//import java.sql.Date;
import java.util.Date;  //regDate변수를 기본생성자가 없는 java.util.Date타입의 변수로 변경 왜냐면 특정 자바 객체를 XML로 변환하려면 반드시 해당 클래스에 기본 생성자가 있어야한다

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

//VO(Value Object)
@XmlAccessorType(XmlAccessType.FIELD) //boardVO객체를 XML로 변환 XmlAccessType.FIELD 때문에 이 객체가 가진 필드, 즉 변수들은 자동으로 자식 엘리먼트로 표현 가능
public class BoardVO {
	
	@XmlAttribute  //seq변수에만 @XmlAttribute 붙혔는데 이는 seq를 속성으로 표현하라는 의미
	private int seq;
	
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	@XmlTransient //xml변환에서 제외
	private String searchCondition;
	
	@XmlTransient
	private String searchKeyword;
	
	@XmlTransient
	private MultipartFile uploadFile;
	
	@JsonIgnore //json으로 나오지 않도록 제외 , getter위에 설정
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	//setUploadFile()메소드가  호출되려면 MultipartFile타입의 객체가 먼저 생성되어 있어야 한다 이 MultipartFile객체는 바로 스프링 컨테이너가 생성한다
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@JsonIgnore //json으로 나오지 않도록 제외 , getter위에 설정
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	@JsonIgnore //json으로 나오지 않도록 제외 , getter위에 설정
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
}