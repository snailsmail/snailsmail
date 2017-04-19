package cn.springmvc.dao;

import cn.springmvc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDAO {

	/**
	 * 获得所有用户
	 *
	 */
	public List<User> getAllUser();

	/**
	 * 通过用户userno获得用户对象
	 * @param userno
	 * @return
	 */
	public User getUserByUserno(@Param("userno") String userno);

	/**
	 * 通过用户uname获得用户对象
	 * @param uname
	 * @return
	 */
	public User getUserByUname(@Param("uname") String uname);

	/**
	 * 添加新用户
	 * @param
	 * @return
	 */
	public void insertUser(@Param("userno") String userno, @Param("uname") String uname, @Param("sex") String sex, @Param("tel") String tel, @Param("balance") Float balance, @Param("address") String address, @Param("isvip") int isvip);

	/**
	 * 添加新用户
	 * @param
	 * @return
	 */
	public void insertUser1pwd(@Param("userno") String userno, @Param("uname") String uname, @Param("sex") String sex, @Param("tel") String tel, @Param("balance") Float balance, @Param("address") String address, @Param("isvip") int isvip, @Param("pwd") String pwd);

	/**
	 * 通过userno删除用户
	 * @param userno
	 * @return
	 */
	public void deleteUserByUserno(@Param("userno") String userno);


	/**
	 * 更新用户
	 * @param
	 * @return
	 */
	public void updateUser(@Param("uname") String uname, @Param("sex") String sex, @Param("tel") String tel, @Param("balance") Float balance, @Param("address") String address, @Param("isvip") int isvip, @Param("userno") String userno);

	public void updateUserPwd(@Param("pwd") String pwd, @Param("userno") String userno);


}
