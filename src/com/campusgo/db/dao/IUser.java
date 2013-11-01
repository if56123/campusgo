package com.campusgo.db.dao;

import java.util.ArrayList;
import com.campusgo.db.entity.User;

public interface IUser {
	
	public int insertUserInfo(User user);//插入用户信息
	public int updateUserInfo(User user);//修改用户信息
	public int deleteUserInfoById(User user);//删除用户信息通过用户ID
	public int deleteUserInfoByPhone(User user);//通过用户电话删除用户信息
	public int deleteUserInfoByNickname(User user);//通过用户昵称删除信息
	public int deleteUserInfoBySchoolId(User user);//通过学号删除用户信息
	public User selectUserInfoById(User user);//通过用户ID查看用户信息
	public User selectUserInfoByPhone(User user);//通过电话查看用户信息
	public User selectUserInfoByNickname(User user);//通过用户昵称查看用户信息
	public User selectUserInfoBySchoolId(User user);//通过用户学号查看用户信息
	public ArrayList<User> selectAll();//查看所有用户信息

}
