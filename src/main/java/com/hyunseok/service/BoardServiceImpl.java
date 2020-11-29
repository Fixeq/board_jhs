package com.hyunseok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyunseok.dao.BoardDao;
import com.hyunseok.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	public BoardDao dao;
	
	@Override
	public List<BoardVO> selectListBoard(BoardVO vo) {
		return dao.selectListBoard(vo);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public BoardVO selectBoardDetail(BoardVO vo) {
		return dao.selectBoardDetail(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoardSeq(BoardVO vo) {
		return dao.deleteBoardSeq(vo);
	}

	@Override
	public int selectBoardTotalCount(BoardVO vo) {
		return dao.selectBoardTotalCount(vo);
	}

}
