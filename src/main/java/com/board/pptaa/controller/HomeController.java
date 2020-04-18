package com.board.pptaa.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.pptaa.domain.BoardVO;
import com.board.pptaa.mapper.BoardMapperDAO;

@Controller
@EnableAutoConfiguration
public class HomeController {
	
	@Autowired
	private BoardMapperDAO mapper;
	
	@RequestMapping(value = "/helloworld")
	@ResponseBody
	public String helloworld() {
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
	
	@RequestMapping("/")
	public String home() throws Exception{
		List<BoardVO> list = mapper.selectMemberList();
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.size());
			System.out.println("num : " + list.get(i).getBoard_no());
            System.out.println("title : " + list.get(i).getTitle());
            System.out.println("date : " + list.get(i).getRegDate());
        } 
		
		return "index";
	}
}	
