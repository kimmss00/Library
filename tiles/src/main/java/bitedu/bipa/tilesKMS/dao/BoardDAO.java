/**
 * 
 */
package bitedu.bipa.tilesKMS.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.tilesKMS.vo.BoardVO;

@Repository("BoardDAO")
public class BoardDAO implements IBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
//	private DataSource dataSource;

	@Override
	public boolean insert(BoardVO board) {
		boolean flag = false;
		int affectCount = sqlSession.insert("mapper.board.insert", board);
		if(affectCount >0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public ArrayList<BoardVO> selectAll() {
		ArrayList<BoardVO> list = null;
		list=(ArrayList)sqlSession.selectList("mapper.board.selectAll");
		return list;
	}

	@Override
	public boolean delete(int parseInt, String pwd) {
		boolean flag = false;
		int affectCount1 = sqlSession.insert("mapper.board.iscorrect", pwd);
		int affectCount2 = sqlSession.insert("mapper.board.delete", parseInt);
		return flag;
	}

	@Override
	public BoardVO select(int parseInt) {
		BoardVO list = null;
		list=sqlSession.selectOne("mapper.board.select", parseInt);

		return list;
	}

	@Override
	public boolean count(int parseInt) {
		boolean flag = false;
		int affectCount = sqlSession.update("mapper.board.count", parseInt);
		return flag;
	}

}
