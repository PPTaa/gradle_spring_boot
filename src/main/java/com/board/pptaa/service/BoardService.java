package com.board.pptaa.service;

import java.util.List;

import com.board.pptaa.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> list() throws Exception;
	public void write(BoardVO vo) throws Exception;
	public BoardVO read(int board_no) throws Exception;
	public void modify(BoardVO vo) throws Exception;
	public BoardVO remove(int board_no) throws Exception;

}
