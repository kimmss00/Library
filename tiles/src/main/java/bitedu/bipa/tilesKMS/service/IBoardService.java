package bitedu.bipa.tilesKMS.service;

import java.util.ArrayList;

import bitedu.bipa.tilesKMS.vo.BoardVO;

public interface IBoardService {
	
	public boolean regist(BoardVO board);
	public ArrayList<BoardVO> serchAll();
	public boolean remove(String seq, String pwd);
	public BoardVO find(String seq);
	public boolean count(String seq);


}
