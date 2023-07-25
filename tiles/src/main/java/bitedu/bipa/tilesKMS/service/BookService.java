package bitedu.bipa.tilesKMS.service;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.tilesKMS.dao.BookDAO;
import bitedu.bipa.tilesKMS.vo.BookVO;

@Service("BookService")
public class BookService implements IBookService{

	@Autowired
	private BookDAO dao;
	

	public ArrayList<BookVO> searchBookAll(){
		ArrayList<BookVO> list = null;
		list = dao.selectBookAll();
		return list;
	}
	public boolean removeBook(String bookSeq) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = dao.deleteBook(Integer.parseInt(bookSeq));
		return flag;
	}



}







