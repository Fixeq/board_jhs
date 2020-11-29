package com.hyunseok.service;

import java.util.List;

import com.hyunseok.vo.BoardVO;

public interface BoardService {

	/**
	 * 게시글 목록 조회
	 * @param vo
	 * @return
	 */
	public List<BoardVO> selectListBoard(BoardVO vo);
	
	/**
	 * 게시글 등록
	 * @param vo
	 * @return
	 */
	public int insertBoard(BoardVO vo);
	
	/**
	 * 게시글 단건 조회
	 * @param vo
	 * @return
	 */
	public BoardVO selectBoardDetail(BoardVO vo);
	
	/**
	 * 게시글 수정
	 * @param vo
	 * @return
	 */
	public int updateBoard(BoardVO vo);
	
	/**
	 * 게시글 삭제
	 * @param vo
	 * @return
	 */
	public int deleteBoardSeq(BoardVO vo);
	
	public int selectBoardTotalCount(BoardVO vo);
}
