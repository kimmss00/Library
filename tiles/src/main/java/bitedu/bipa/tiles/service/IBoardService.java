package bitedu.bipa.tiles.service;

import java.util.ArrayList;

import bitedu.bipa.tiles.vo.BoardVO;

public interface IBoardService {
	
	public boolean regist(BoardVO board);
	public ArrayList<BoardVO> serchAll();
	public boolean remove(String no);
	public BoardVO find(String no);
	public boolean count(String no);


}
