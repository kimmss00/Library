package bitedu.bipa.tilesKMS.dao;

import java.util.ArrayList;

import bitedu.bipa.tilesKMS.vo.UserVO;

public interface IUserDAO {
	public boolean login(UserVO user);
	public boolean regist(UserVO user);
	public boolean compare(String id);
//	public ArrayList<UserVO> selectAll();
	

}
