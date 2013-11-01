package com.campusgo.db.dao;

import java.util.ArrayList;
import com.campusgo.db.entity.User;

public interface IUser {
	
	public int insertUserInfo(User user);//�����û���Ϣ
	public int updateUserInfo(User user);//�޸��û���Ϣ
	public int deleteUserInfoById(User user);//ɾ���û���Ϣͨ���û�ID
	public int deleteUserInfoByPhone(User user);//ͨ���û��绰ɾ���û���Ϣ
	public int deleteUserInfoByNickname(User user);//ͨ���û��ǳ�ɾ����Ϣ
	public int deleteUserInfoBySchoolId(User user);//ͨ��ѧ��ɾ���û���Ϣ
	public User selectUserInfoById(User user);//ͨ���û�ID�鿴�û���Ϣ
	public User selectUserInfoByPhone(User user);//ͨ���绰�鿴�û���Ϣ
	public User selectUserInfoByNickname(User user);//ͨ���û��ǳƲ鿴�û���Ϣ
	public User selectUserInfoBySchoolId(User user);//ͨ���û�ѧ�Ų鿴�û���Ϣ
	public ArrayList<User> selectAll();//�鿴�����û���Ϣ

}
