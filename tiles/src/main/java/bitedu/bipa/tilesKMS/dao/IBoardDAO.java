package bitedu.bipa.tilesKMS.dao;

import java.util.ArrayList;

import bitedu.bipa.tilesKMS.vo.BoardVO;

public interface IBoardDAO {
	public ArrayList<BoardVO> selectAll();
	public boolean insert(BoardVO board);	
	public boolean delete(int parseInt, String pwd);
	public BoardVO select(int parseInt);
	public boolean count(int parseInt);
}
