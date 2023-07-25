package bitedu.bipa.tilesKMS.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tilesKMS.service.BookService;
import bitedu.bipa.tilesKMS.vo.BookVO;

@Controller("bookController")
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<BookVO> list = (ArrayList<BookVO>)bookservice.searchBookAll();
		mav.addObject("list",list);
		mav.setViewName("/book/list");
		return mav;
	}

	
	@RequestMapping(value="remove.do", method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("bookSeq") String bookSeq) {
		ModelAndView mav = new ModelAndView();
		boolean flag = bookservice.removeBook(bookSeq);
		mav.setViewName("redirect:list.do");
		return mav;
	}

}
