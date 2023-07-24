package bitedu.bipa.tiles.dao;

import java.util.ArrayList;

import bitedu.bipa.tiles.vo.BoardVO;

public interface IBoardDAO {
	public ArrayList<BoardVO> selectAll();
	public boolean insert(BoardVO board);	
	public boolean delete(int parseInt);
	public BoardVO select(int parseInt);
	public boolean count(int parseInt);
}
