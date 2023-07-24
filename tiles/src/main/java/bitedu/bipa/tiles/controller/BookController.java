package bitedu.bipa.tiles.controller;

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

import bitedu.bipa.tiles.service.BookService;
import bitedu.bipa.tiles.vo.BookVO;

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
	
	@RequestMapping(value="/view_regist.do", method=RequestMethod.GET)
	public ModelAndView viewRegist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("");
		return mav;
	}
	
	@RequestMapping(value="/regist.do", method=RequestMethod.POST)
	public ModelAndView regist(@ModelAttribute("book") BookVO book) {
		ModelAndView mav = new ModelAndView();
		System.out.println(book);
		bookservice.registBook(book);
		System.out.println("regist");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/view_detail.do", method=RequestMethod.GET)
	public ModelAndView viewDetail(@RequestParam("bookSeq") String bookSeq) {
		ModelAndView mav = new ModelAndView();
		BookVO list = bookservice.findBook(bookSeq);
		mav.addObject("list",list);
		mav.setViewName("");
		return mav;
	}
	
	@RequestMapping(value="/remove.do", method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("bookSeq") String bookSeq) {
		ModelAndView mav = new ModelAndView();
		boolean flag = bookservice.removeBook(bookSeq);
		
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("upload");
		String path = "C:\\Users\\금정산2_PC08\\Downloads\\sample\\src\\main\\webapp\\resources";//이미지파일 저장한 곳
		DiskFileItemFactory factory = new DiskFileItemFactory();//업로드할 데이터 용량 제한하는 메서드 DiskFileItemFactory
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024*1024*10);
		ServletFileUpload upload = new ServletFileUpload(factory);//binary와 같이 업로드 가능한 파일의 형태가 다양하기 때문에 업로드 가능한 형태로 알아서 변형시켜줌
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);//servlet 서버에서 파일업로드 처리
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookVO book = null;
		try {
			book = bookservice.upload(items);//처리된 데이터를 로직으로 넘김
			System.out.println(book);
			bookservice.registBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.setViewName("redirect:list.do");
		
		return mav;
	}
	
	@RequestMapping(value="/download.do",method = RequestMethod.GET)
	public void download(@RequestParam("fileName") String fileName,HttpServletResponse resp) {
		File downloadFile = new File("C:\\Users\\금정산2_PC08\\Downloads\\sample\\src\\main\\webapp\\resources\\"+fileName);//이미지 파일 저장한 곳
		
		try {
			fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html; charset=UTF-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-Disposition", "attatchment;filename="+fileName);
		
		try {
			FileInputStream fis = new FileInputStream(downloadFile);
			OutputStream os = resp.getOutputStream();
			byte[] buffer = new byte[256];
			int length = 0;
			while((length=fis.read(buffer))!=-1) {
				os.write(buffer, 0, length);
			}
			os.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("e",e);
		mav.setViewName("./error/exception");
		return mav;
	}
}
