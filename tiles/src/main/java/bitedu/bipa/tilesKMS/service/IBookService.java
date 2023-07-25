package bitedu.bipa.tilesKMS.service;

import java.util.ArrayList;

import bitedu.bipa.tilesKMS.vo.BookVO;

public interface IBookService {
	
	
	public ArrayList<BookVO> searchBookAll();
	public boolean removeBook(String bookSeq); 
	
}
