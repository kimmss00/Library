package bitedu.bipa.tiles.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tiles.service.BoardService;
import bitedu.bipa.tiles.vo.BoardVO;

@Controller("boardController")
@RequestMapping("/guestbook")
public class BoardController {

	@Autowired
	private BoardService boardservice;
	
	//C - UI
	@RequestMapping(value="view_regist.do", method=RequestMethod.GET)
	public ModelAndView viewregist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/regist");
		
		return mav;
	}
	//C - ����
	@RequestMapping(value="regist.do", method=RequestMethod.GET)
	public ModelAndView regist(@ModelAttribute("board") BoardVO board) {
		ModelAndView mav = new ModelAndView();
		System.out.println(board);
		boardservice.regist(board);
		System.out.println("regist");
		mav.setViewName("redirect:list.do");
		return mav;
	}
	
	
	
	
	//R1 - ��ü ����Ʈ
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardVO> list = boardservice.serchAll();
		mav.addObject("list",list);
		mav.setViewName("/board/list");

		return mav;
	}
	
	//R2 - ���� ���� Ȯ��
	@RequestMapping(value="/view_detail.do", method=RequestMethod.GET)
	public ModelAndView viewdetail(@RequestParam("no") String no) {
		ModelAndView mav = new ModelAndView();
		BoardVO board = boardservice.find(no);
		boolean count = boardservice.count(no);
		mav.addObject("board",board);
		mav.addObject(count);
		mav.setViewName("/board/view_detail");
		return mav;
	}
	
	
	//D
	@RequestMapping(value="remove.do", method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("no") String no) {
		ModelAndView mav = new ModelAndView();
		boolean flag = boardservice.remove(no);
		mav.setViewName("redirect:list.do");
		return mav;
	}
}