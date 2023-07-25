package bitedu.bipa.tilesKMS.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.tilesKMS.vo.UserVO;

@Repository("UserDAO")
public class UserDAO implements IUserDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean regist(UserVO user) {
		boolean flag = false;
		// TODO Auto-generated method stub
		int affectCount = sqlSession.insert("mapper.user.signup", user);
		if(affectCount > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean login(UserVO user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		UserVO loginuser = sqlSession.selectOne("mapper.user.login", user);
		if(loginuser !=null) {
			flag = true;
			System.out.println("로그인성공");
		}else {
			System.out.println("로그인실패");	
		}
		return flag;
	}

	@Override
	public boolean compare(String id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int affectCount = sqlSession.selectOne("mapper.user.compare", id);
		if(affectCount > 0) {
			flag = true; //중복시 true -> 중복시 false로 반환하려고 처음 설계했으나, false로 반환하면 해당 메서드가 동작하지않음 -> 중복체크가 실행되지않는다.
		}
		return flag;
	}

//	@Override
//	public ArrayList<UserVO> selectAll() {
//		// TODO Auto-generated method stub
//		ArrayList<UserVO> list = null;
//		list=(ArrayList)sqlSession.selectList("mapper.user.searchAll");
//		return list;
//	}

}
