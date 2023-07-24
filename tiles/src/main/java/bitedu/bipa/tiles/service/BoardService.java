package bitedu.bipa.tiles.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.tiles.dao.BoardDAO;
import bitedu.bipa.tiles.vo.BoardVO;

@Service("BoardService")
public class BoardService implements IBoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public boolean regist(BoardVO board) {
		boolean flag = false;
		System.out.println("regist");
		flag = dao.insert(board);
		return flag;
	}

	@Override
	public ArrayList<BoardVO> serchAll() {
		ArrayList<BoardVO> list = null;
		System.out.println("list");
		list = dao.selectAll();
		return list;
	}

	@Override
	public boolean remove(String no) {
		boolean flag = false;
		System.out.println("remove");
		flag = dao.delete(Integer.parseInt(no));
		return flag;
	}

	@Override
	public BoardVO find(String no) {
		// TODO Auto-generated method stub
		BoardVO board = null;
		board=dao.select(Integer.parseInt(no));
		return board;
	}

	@Override
	public boolean count(String no) {
		boolean flag = false;
		flag=dao.count(Integer.parseInt(no));
		return flag;
	}

}
