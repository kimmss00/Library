package bitedu.bipa.tilesKMS.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tilesKMS.service.BoardService;
import bitedu.bipa.tilesKMS.vo.BoardVO;

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
	//C - 동작
	@RequestMapping(value="regist.do", method=RequestMethod.GET)
	public ModelAndView regist(@ModelAttribute("board") BoardVO board) {
		ModelAndView mav = new ModelAndView();
		System.out.println(board);
		boardservice.regist(board);
		System.out.println("regist");
		mav.setViewName("redirect:list.do");
		return mav;
	}
	
	
	//R1 - 전체 리스트
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardVO> list = boardservice.serchAll();
		mav.addObject("list",list);
		mav.setViewName("/board/list");

		return mav;
	}
	
	//R2 - 세부 내용 확인
	@RequestMapping(value="/view_detail.do", method=RequestMethod.GET)
	public ModelAndView viewdetail(@RequestParam("seq") String seq) {
		ModelAndView mav = new ModelAndView();
		BoardVO board = boardservice.find(seq);
		boolean count = boardservice.count(seq);
		mav.addObject("board",board);
		mav.addObject(count);
		mav.setViewName("/board/view_detail");
		return mav;
	}
	
	
	//D
	@RequestMapping(value="remove.do", method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("seq") String seq, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		boolean flag = boardservice.remove(seq, password);
		mav.setViewName("redirect:list.do");
		return mav;
	}
}
