package bitedu.bipa.tiles.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.tiles.vo.BookVO;

@Repository("BookDAO")
public class BookDAO implements IBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// orderIndex = 페이지에 처음 시작하는 컨텐츠 번호, group = 한 페이지에 나타낼 컨텐츠 개수
	public ArrayList<BookVO> selectPageList(int orderIndex, int group){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		HashMap<String, Integer> map =new HashMap<String, Integer>();
		map.put("index", orderIndex); // 각 페이지의 첫 인덱스
		map.put("group", group);  // 각 페이지의 컨텐츠 개수
		list = (ArrayList)sqlSession.selectList("mapper.book.selectPageList",map);
		return list;
	}
	
	public int selectTotalCount() {
		int total;
		total = sqlSession.selectOne("mapper.book.selectTotalCount");
		return total;
	}
	
	@Override
	public boolean insertBook(BookVO copy){
		boolean flag = false;
		int affectedCount1 = sqlSession.insert("mapper.book.insertBook",copy);
		int affectedCount2 = sqlSession.insert("mapper.book.insertCopy",copy);
		if(affectedCount1>0 && affectedCount2>0) {
			flag = true;
		}
		
		return flag;
	}
	
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
	
	@Override
	public BookVO selectBook(int parseInt) {
		// TODO Auto-generated method stub
		BookVO copy = null;
		copy=sqlSession.selectOne("mapper.book.selectBookBySeq",parseInt);
		return copy;
	}
	
	@Override
	public boolean updateBook(BookVO copy) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.book.updateBook",copy);
		if(affectedCount>0) {
			flag=true;
		}
		
		return flag;
	}
	
}







