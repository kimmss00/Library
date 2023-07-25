package bitedu.bipa.tilesKMS.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.tilesKMS.vo.BookVO;

@Repository("BookDAO")
public class BookDAO implements IBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BookVO> selectBookAll(){
		ArrayList<BookVO> list = null;
		list= (ArrayList)sqlSession.selectList("mapper.book.selectAllBook");
		System.out.println(list.size());
		return list;
	}
	
	@Override
	public boolean deleteBook(int parseInt) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.book.deleteBook",parseInt);
		if(affectedCount>0) {
			flag = true;
		}
		
		return flag;
	}
	
	
	
	
	
}







