package bitedu.bipa.tiles.dao;

import java.util.ArrayList;

import bitedu.bipa.tiles.vo.BookVO;

public interface IBookDAO {
	public boolean insertBook(BookVO copy);	
	public ArrayList<BookVO> selectBookAll();
	public boolean deleteBook(int parseInt);
	public BookVO selectBook(int parseInt);
	public boolean updateBook(BookVO copy);

}
