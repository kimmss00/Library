package bitedu.bipa.tiles.service;

import java.util.ArrayList;

import bitedu.bipa.tiles.vo.BookVO;

public interface IBookService {
	
	public boolean registBook(BookVO copy);
	
	public ArrayList<BookVO> searchBookAll();
	public boolean removeBook(String bookSeq); 
	public BookVO findBook(String bookSeq); 
	public boolean modifyBook(BookVO copy);
	
}
