package com.board.pptaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.pptaa.domain.BoardVO;
import com.board.pptaa.domain.Page;
import com.board.pptaa.service.BoardServiceImpl;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	BoardServiceImpl service;
	//개시글 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mav) throws Exception {
	
		List<BoardVO> list = null;
		list = service.list();

		mav.addObject("list", list);
		mav.setViewName("list");
		
		return mav;
	}
	//개시글 작성 페이지
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView writeForm(ModelAndView mav) throws Exception { 
		
		mav.setViewName("write");
		return mav;
	}
	//개시글 작성 쿼리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView write(BoardVO vo,ModelAndView mav) throws Exception {
		
		service.write(vo);
		
		mav.setViewName("redirect:/board/listPage?num=1");
		
		return mav;
	}
	//개시글 보기
	@RequestMapping(value = "/read")
	public ModelAndView readForm(@RequestParam("board_no") int board_no, ModelAndView mav) throws Exception {
		
		BoardVO vo = service.read(board_no);
		mav.addObject("read", vo);
		mav.setViewName("read");
		
		return mav;
	}
	//게시물 수정 페이지
	@RequestMapping(value = "/modify")
	public ModelAndView modifyForm(@RequestParam("board_no") int board_no, ModelAndView mav) throws Exception {
		
		BoardVO vo = service.read(board_no);
		mav.addObject("read", vo);
		mav.setViewName("modify");
		
		return mav;
	}
	//개시글 수정 쿼리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(BoardVO vo, ModelAndView mav, @RequestParam("board_no") int board_no) throws Exception {
		
		service.modify(vo);
		mav.setViewName("redirect:/board/read?board_no=" + board_no);
		
		return mav;
	}
	//개시글 삭제 쿼리
	@RequestMapping("/remove")
	public ModelAndView remove(ModelAndView mav, @RequestParam("board_no") int board_no) throws Exception {
		
		service.remove(board_no);
		
		mav.setViewName("redirect:/board/listPage?num=1");
		
		return mav;
	}
	//게시물 리스트 페이지 추가
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public ModelAndView getListPage(ModelAndView mav, @RequestParam("num") int num) throws Exception {
		
		Page page = new Page();
		page.setNum(num);
		page.setCount(service.count());
		
		List<BoardVO> list = null;
		list = service.page(page.getDisplayPost(), page.getPostNum());

		mav.addObject("list", list);

		mav.addObject("page", page);
		
		mav.addObject("select", num);
		
		mav.setViewName("listpage");
		return mav;
	}
}
