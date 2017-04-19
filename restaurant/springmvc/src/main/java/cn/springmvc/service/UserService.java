package cn.springmvc.service;

import cn.springmvc.model.User;

import java.util.List;


public interface UserService {

	public List<User> getAllUser();

	public User getUserByUserno(String userno);

	public User getUserByUname(String uname);

	public void insertUser(String userno, String uname, String sex, String tel, Float balance, String address, int isvip);

	public void insertUser1pwd(String userno, String uname, String sex, String tel, Float balance, String address, int isvip, String password);

	//public void insertUser1url(String userno,String uname,String sex,String tel,Float balance,String address,String password);

	public void deleteUserByUserno(String userno);

	public void updateUser(String uname, String sex, String tel, Float balance, String address, int isvip, String userno);

	public void updateUserPwd(String pwd, String userno);


}
