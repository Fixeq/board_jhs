package com.hyunseok.vo;

import java.util.Date;

public class BoardVO extends PageInfo{
	
	private Long	boardSeq        ;	/*게시글 번호*/
	private String  boardWriter     ;	/*게시글 작성자*/
	private String 	boardTitle		;	/*게시글 제목*/
	private String 	boardContents   ;	/*게시글 내용*/
	private Long 	boardCnt        ;	/*게시글 조회수*/
	
	private Date	boardRegDate    ;	/*게시글 등록일*/
	private String	boardUpdateId   ;	/*게시글 수정자*/
	private Date	boardUpdate     ;	/*게시글 수정일*/
	

	
	public Long getBoardSeq() {
		return boardSeq;
	}



	public void setBoardSeq(Long boardSeq) {
		this.boardSeq = boardSeq;
	}



	public String getBoardWriter() {
		return boardWriter;
	}



	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}



	public String getBoardTitle() {
		return boardTitle;
	}



	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}



	public String getBoardContents() {
		return boardContents;
	}



	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}



	public Long getBoardCnt() {
		return boardCnt;
	}



	public void setBoardCnt(Long boardCnt) {
		this.boardCnt = boardCnt;
	}



	public Date getBoardRegDate() {
		return boardRegDate;
	}



	public void setBoardRegDate(Date boardRegDate) {
		this.boardRegDate = boardRegDate;
	}



	public String getBoardUpdateId() {
		return boardUpdateId;
	}



	public void setBoardUpdateId(String boardUpdateId) {
		this.boardUpdateId = boardUpdateId;
	}



	public Date getBoardUpdate() {
		return boardUpdate;
	}



	public void setBoardUpdate(Date boardUpdate) {
		this.boardUpdate = boardUpdate;
	}



	@Override
	public String toString() {
		return "BoardVO [boardSeq=" + boardSeq + ", boardWriter=" + boardWriter + ", boardTitle=" + boardTitle
				+ ", boardContents=" + boardContents + ", boardCnt=" + boardCnt + ", boardRegDate=" + boardRegDate
				+ ", boardUpdateId=" + boardUpdateId + ", boardUpdate=" + boardUpdate + " " + super.toString() +"]";
	}
	
}
