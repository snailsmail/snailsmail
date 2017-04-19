package cn.springmvc.service.impl;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public List<User> getAllUser(){
		return userDAO.getAllUser();
	}


	public User getUserByUserno(String userno){
		return userDAO.getUserByUserno(userno);
	}


	public User getUserByUname(String uname){
		return userDAO.getUserByUname(uname);
	}

	public void insertUser(String userno,String uname,String sex,String tel,Float balance,String address,int isvip){
		userDAO.insertUser(userno,uname,sex,tel,balance,address,isvip);
	}

	public void deleteUserByUserno(String userno){
		userDAO.deleteUserByUserno(userno);
	}

	public void updateUser(String uname,String sex,String tel,Float balance,String address,int isvip,String userno){
		userDAO.updateUser(uname,sex,tel,balance,address,isvip,userno);
	}
	public void insertUser1pwd(String userno,String uname,String sex,String tel,Float balance,String address,int isvip,String password){
		userDAO.insertUser1pwd(userno,uname,sex,tel,balance,address,isvip,password);
	}

	public void updateUserPwd(String pwd,String userno){
		userDAO.updateUserPwd(pwd,userno);
	}

}
