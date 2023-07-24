package bitedu.bipa.tiles.service;

import java.util.ArrayList;

import bitedu.bipa.tiles.vo.UserVO;

public interface IUserSerivce {
	public boolean regist(UserVO user);
	public boolean login(UserVO id);
	public boolean compare(String id);
//	public ArrayList<UserVO> searchAll();
}
