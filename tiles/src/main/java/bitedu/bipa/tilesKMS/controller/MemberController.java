package bitedu.bipa.tilesKMS.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tilesKMS.service.UserService;
import bitedu.bipa.tilesKMS.vo.UserVO;

@Controller("memberController")
@RequestMapping("/member")
public class MemberController {
	
	@Autowired UserService userservice;
	
	//회원가입 페이지 ui
	@RequestMapping(value="/viewRegist.do", method=RequestMethod.GET)
	public ModelAndView viewRegist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/regist");
		return mav;
	}
	
	//회원가입 동작
	@RequestMapping(value="/regist.do", method=RequestMethod.POST)
	public ModelAndView regist(@ModelAttribute("user") UserVO user) {
		ModelAndView mav = new ModelAndView();
		System.out.println(user);
		userservice.regist(user);
		boolean flag = userservice.compare(user.getId());
		System.out.println(flag);
		if(flag==true) {//중복이 아니면 로그인창으로
			System.out.println("회원가입 되었습니다.");
			mav.setViewName("main");
		}
		else {//중복시 다시 회원가입창으로
			System.out.println("아이디가 중복되었습니다.");
			mav.setViewName("redirect:view_regist.do");
		}
		return mav;
	}
	
	@RequestMapping(value="/viewLogin.do", method=RequestMethod.GET)
	public ModelAndView viewLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd, UserVO user,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		session.setAttribute("user", user);
		System.out.println(user);
		boolean flag = userservice.login(user);
		if(flag==false) {
			System.out.println("로그인 실패");	
			session.invalidate();
			mav.setViewName("redirect:viewLogin.do");			
		}
		else {
			
			System.out.println(flag);
			mav.setViewName("main");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
//		ArrayList<UserVO> list = userservice.searchAll();
//		mav.addObject("list", list);
		mav.setViewName("/member/list");
		return mav;
	}
	
	
}
