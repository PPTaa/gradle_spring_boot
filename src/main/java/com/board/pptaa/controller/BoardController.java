package com.board.pptaa.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.pptaa.domain.BoardVO;
import com.board.pptaa.service.BoardServiceImpl;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	BoardServiceImpl service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mav) throws Exception {
	
		List<BoardVO> list = null;
		list = service.list();

		mav.addObject("list", list);
		mav.setViewName("list");
		
		return mav;
	}
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView writeForm(ModelAndView mav) throws Exception { 
		
		mav.setViewName("write");
		return mav;
	}
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView write(BoardVO vo,ModelAndView mav) throws Exception {
		
		service.write(vo);
		
		mav.setViewName("redirect:/board/list");
		
		return mav;
	}
	
	@RequestMapping(value = "/read")
	public ModelAndView readForm(@RequestParam("board_no") int board_no, ModelAndView mav) throws Exception {
		
		BoardVO vo = service.read(board_no);
		mav.addObject("read", vo);
		mav.setViewName("read");
		
		return mav;
	}
	
	//게시물 수정
	@RequestMapping(value = "/modify")
	public ModelAndView modifyForm(@RequestParam("board_no") int board_no, ModelAndView mav) throws Exception {
		
		BoardVO vo = service.read(board_no);
		mav.addObject("read", vo);
		mav.setViewName("modify");
		
		return mav;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(BoardVO vo, ModelAndView mav) throws Exception {
		
		
		service.modify(vo);
		mav.setViewName("redirect:/board/read?board_no=" + vo.getBoard_no());
		
		return mav;
	}
}
