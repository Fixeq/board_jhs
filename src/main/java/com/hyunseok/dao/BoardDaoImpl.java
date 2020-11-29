package com.hyunseok.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyunseok.vo.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession session;
	
	private static final String namespace = "com.hyunseok.mapper.boardMapper";
	
	@Override
	public List<BoardVO> selectListBoard(BoardVO vo) {
		return session.selectList(namespace +".selectBoardPagingSearch", vo);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return session.insert(namespace + ".insertBoard", vo);
	}

	@Override
	public BoardVO selectBoardDetail(BoardVO vo) {
		return session.selectOne(namespace + ".selectBoardDetail", vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return session.update(namespace+".updateBoard", vo);
	}

	@Override
	public int deleteBoardSeq(BoardVO vo) {
		return session.update(namespace +".deleteBoardSeq", vo);
	}

	@Override
	public int selectBoardTotalCount(BoardVO vo) {
		return session.selectOne(namespace+".selectBoardTotalCount", vo);
	}

}
