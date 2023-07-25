package bitedu.bipa.tilesKMS.service;

import java.util.ArrayList;

import bitedu.bipa.tilesKMS.vo.UserVO;

public interface IUserSerivce {
	public boolean regist(UserVO user);
	public boolean login(UserVO id);
	public boolean compare(String id);
//	public ArrayList<UserVO> searchAll();
}
