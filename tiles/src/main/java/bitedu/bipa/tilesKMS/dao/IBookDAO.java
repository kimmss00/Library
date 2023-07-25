package bitedu.bipa.tilesKMS.dao;

import java.util.ArrayList;

import bitedu.bipa.tilesKMS.vo.BookVO;

public interface IBookDAO {
	public ArrayList<BookVO> selectBookAll();
	public boolean deleteBook(int parseInt);
	

}
