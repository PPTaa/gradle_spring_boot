package com.board.pptaa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.pptaa.domain.BoardVO;
import com.board.pptaa.mapper.BoardMapperDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapperDAO dao;
	
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public void write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.write(vo);
	}

	@Override
	public BoardVO read(int board_no) throws Exception {
		return dao.read(board_no);
		
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);
	}

	@Override
	public BoardVO remove(int board_no) throws Exception {
		// TODO Auto-generated method stub
		return dao.remove(board_no);
	}



}
