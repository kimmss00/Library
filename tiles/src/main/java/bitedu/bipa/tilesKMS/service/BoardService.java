package bitedu.bipa.tilesKMS.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.tilesKMS.dao.BoardDAO;
import bitedu.bipa.tilesKMS.vo.BoardVO;

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
	public boolean remove(String seq, String pwd) {
		boolean flag = false;
		System.out.println("remove");
		flag = dao.delete(Integer.parseInt(seq), pwd);
		return flag;
	}

	@Override
	public BoardVO find(String seq) {
		// TODO Auto-generated method stub
		BoardVO board = null;
		board=dao.select(Integer.parseInt(seq));
		return board;
	}

	@Override
	public boolean count(String seq) {
		boolean flag = false;
		flag=dao.count(Integer.parseInt(seq));
		return flag;
	}

}
