package bitedu.bipa.tiles.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.tiles.dao.IUserDAO;
import bitedu.bipa.tiles.dao.UserDAO;
import bitedu.bipa.tiles.vo.UserVO;

@Service("UserService")
public class UserService implements IUserSerivce {

	@Autowired
	private UserDAO dao;
	
	@Override
	public boolean regist(UserVO user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = dao.regist(user);
		return flag;
	}

	@Override
	public boolean login(UserVO user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = dao.login(user);
		return flag;
	}

	@Override
	public boolean compare(String id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag=dao.compare(id);//Áßº¹½Ã true
		return flag;
	}

//	@Override
//	public ArrayList<UserVO> searchAll() {
//		// TODO Auto-generated method stub
//		ArrayList<UserVO> list = null;
//		list = dao.selectAll();
//		return null;
//	}

}
