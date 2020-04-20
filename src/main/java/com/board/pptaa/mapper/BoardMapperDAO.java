package com.board.pptaa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.pptaa.domain.BoardVO;

@Mapper
public interface BoardMapperDAO {
	
	public List<BoardVO> selectMemberList() throws Exception;
	public List<BoardVO> list() throws Exception;
	public void write(BoardVO vo) throws Exception;
	public BoardVO read(int board_no) throws Exception;
	public void modify(BoardVO vo) throws Exception;

}
