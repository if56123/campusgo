package com.campusgo.db.dal;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.campusgo.db.dao.IUser;
import com.campusgo.db.entity.User;
import com.campusgo.db.dbtools.DBcon;

public class UserDal implements IUser
{

	@Override
	public int insertUserInfo(User user) {//添加用户信息
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		int result=0;
		int usrid=user.getUsrid();
		String nickname=user.getNickname();
		String school=user.getSchool();
		String stuid=user.getStuid();
		String academy=user.getAcademy();
		String specialty=user.getSpecialty();
		String sex=user.getSex();
		String age=user.getAge();
		String pwd=user.getPwd();
		String phone=user.getPhone();
		String qq=user.getQq();
	    String sql="insert into userinfo values(?,?,?,?,?,?,?,?,?,?,?,?)";
		db.getPreparedStatement(sql);
	    try 
		{
	    	db.getPs().setInt(1, usrid);
	    	db.getPs().setString(2, nickname);
	    	db.getPs().setString(3, pwd);
	    	db.getPs().setString(4, stuid);
	    	db.getPs().setString(5, sex);
	    	db.getPs().setString(1, school);
	    	db.getPs().setString(1, academy);
	    	db.getPs().setString(1, specialty);
	    	db.getPs().setString(1, age);
	    	db.getPs().setString(1, phone);
	    	db.getPs().setString(1, qq);
	    	//db.getPs().setInt(1, current_timestamp);
			 result=db.update();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		db.close();
		return result;
	}

	@Override
	public int updateUserInfo(User user) {//修改用户信息
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		int result=0;
		int usrid=user.getUsrid();
		String nickname=user.getNickname();
		String school=user.getSchool();
		String stuid=user.getStuid();
		String academy=user.getAcademy();
		String specialty=user.getSpecialty();
		String sex=user.getSex();
		String age=user.getAge();
		String pwd=user.getPwd();
		String phone=user.getPhone();
		String qq=user.getQq();
		String sql="update userinfo set usrid=?,nickname=?,pwd=?,stuid=?,sex=?,school=?,academy=?,specialty=?,age=?,phone=?,qq=? where usrid=?";
		db.getPreparedStatement(sql);
		try 
		{
			db.getPs().setInt(1, usrid);
			db.getPs().setString(2, nickname);
			db.getPs().setString(3, pwd);
			db.getPs().setString(4, stuid);
			db.getPs().setString(5, sex);
			db.getPs().setString(6, school);
			db.getPs().setString(7, academy);
			db.getPs().setString(8, specialty);
			db.getPs().setString(9, age);
			db.getPs().setString(10, phone);
			db.getPs().setString(11, qq);
			db.getPs().setInt(12, usrid);
			
			result=db.update();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		db.close();
		return result;
	}

	@Override
	public int deleteUserInfoById(User user) {//通过id删除用户信息
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		int result=0;
		int usrid=user.getUsrid();
		String sql="delete from userinfo where usrid=?";
		db.getPreparedStatement(sql);
		
		try 
		{
			db.getPs().setInt(1, usrid);
			result=db.update();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
			
		}
		db.close();
		return result;
	}

	@Override
	public int deleteUserInfoByPhone(User user) {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		int result=0;
		String phone=user.getPhone();
		String sql="delete from userinfo where phone=?";
		db.getPreparedStatement(sql);

		try 
		{
			db.getPs().setString(1, phone);
			 result=db.update();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
			
		}
		db.close();
		return result;
	}

	@Override
	public int deleteUserInfoByNickname(User user) {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		int result=0;
		String nickname=user.getNickname();
		String sql="delete from userinfo where nickname=?";
		db.getPreparedStatement(sql);
		
		try 
		{
			db.getPs().setString(1, nickname);
			result=db.update();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
			
		}
		db.close();
		return result;
	}

	@Override
	public int deleteUserInfoBySchoolId(User user) {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		int result=0;
		String stuid=user.getStuid();
		String sql="delete from userinfo where stuid=?";
		db.getPreparedStatement(sql);
		
		try 
		{
			db.getPs().setString(1, stuid);
			result=db.update();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
		}
		db.close();
		return result;
	}

	@Override
	public User selectUserInfoById(User user) {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		int usrid=user.getUsrid();
		String sql="select * from userinfo where usrid=?";
		db.getPreparedStatement(sql);
		User _user=new User();
		try
		{
			db.getPs().setInt(1, usrid);
			ResultSet rs=db.Query();
			while(rs.next())
			{
				_user.setUsrid(rs.getInt(1));
				_user.setNickname(rs.getString(2));
				_user.setPwd(rs.getString(3));
				_user.setStuid(rs.getString(4));
				_user.setSex(rs.getString(5));
				_user.setSchool(rs.getString(6));
				_user.setAcademy(rs.getString(7));
				_user.setSpecialty(rs.getString(8));
				_user.setAge(rs.getString(9));
				_user.setPhone(rs.getString(10));
				_user.setQq(rs.getString(11));
				_user.setRegdate(rs.getString(12));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		db.close();
		return _user;
	}

	@Override
	public User selectUserInfoByPhone(User user) {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		String phone=user.getPhone();
		String sql="select * from userinfo where phone=?";
		db.getPreparedStatement(sql);
		User _user=new User();
		try
		{
			db.getPs().setString(1, phone);
			ResultSet rs=db.Query();
			while(rs.next())
			{
				_user.setUsrid(rs.getInt(1));
				_user.setNickname(rs.getString(2));
				_user.setPwd(rs.getString(3));
				_user.setStuid(rs.getString(4));
				_user.setSex(rs.getString(5));
				_user.setSchool(rs.getString(6));
				_user.setAcademy(rs.getString(7));
				_user.setSpecialty(rs.getString(8));
				_user.setAge(rs.getString(9));
				_user.setPhone(rs.getString(10));
				_user.setQq(rs.getString(11));
				_user.setRegdate(rs.getString(12));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		db.close();
		return _user;
	}

	@Override
	public User selectUserInfoByNickname(User user) {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		String nickname=user.getNickname();
		String sql="select * from userinfo where nickname=?";
		db.getPreparedStatement(sql);
		User _user=new User();
		try
		{
			db.getPs().setString(1, nickname);
			ResultSet rs=db.Query();
			while(rs.next())
			{
				_user.setUsrid(rs.getInt(1));
				_user.setNickname(rs.getString(2));
				_user.setPwd(rs.getString(3));
				_user.setStuid(rs.getString(4));
				_user.setSex(rs.getString(5));
				_user.setSchool(rs.getString(6));
				_user.setAcademy(rs.getString(7));
				_user.setSpecialty(rs.getString(8));
				_user.setAge(rs.getString(9));
				_user.setPhone(rs.getString(10));
				_user.setQq(rs.getString(11));
				_user.setRegdate(rs.getString(12));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		db.close();
		return _user;
	}

	@Override
	public User selectUserInfoBySchoolId(User user) {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		String stuid=user.getStuid();
		String sql="select * from userinfo where stuid=?";
		db.getPreparedStatement(sql);
		User _user=new User();
		try
		{
			db.getPs().setString(1, stuid);		
			ResultSet rs=db.Query();
			while(rs.next())
			{
				_user.setUsrid(rs.getInt(1));
				_user.setNickname(rs.getString(2));
				_user.setPwd(rs.getString(3));
				_user.setStuid(rs.getString(4));
				_user.setSex(rs.getString(5));
				_user.setSchool(rs.getString(6));
				_user.setAcademy(rs.getString(7));
				_user.setSpecialty(rs.getString(8));
				_user.setAge(rs.getString(9));
				_user.setPhone(rs.getString(10));
				_user.setQq(rs.getString(11));
				_user.setRegdate(rs.getString(12));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		db.close();
		return _user;
	}

	@Override
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		DBcon db=new DBcon();
		String sql="select * from userinfo";
		db.getPreparedStatement(sql);
		ArrayList<User> list=new ArrayList<User>();
		User _user=null;
		try
		{
			ResultSet rs=db.Query();
			while(rs.next())
			{
				_user=new User();
				_user.setUsrid(rs.getInt(1));
				_user.setNickname(rs.getString(2));
				_user.setPwd(rs.getString(3));
				_user.setStuid(rs.getString(4));
				_user.setSex(rs.getString(5));
				_user.setSchool(rs.getString(6));
				_user.setAcademy(rs.getString(7));
				_user.setSpecialty(rs.getString(8));
				_user.setAge(rs.getString(9));
				_user.setPhone(rs.getString(10));
				_user.setQq(rs.getString(11));
				_user.setRegdate(rs.getString(12));
				list.add(_user);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		db.close();
		return list;
	}

}
