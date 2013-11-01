package com.campusgo.service;
import java.util.ArrayList;

import com.campusgo.db.dal.ProductDal;
import com.campusgo.db.dal.UserDal;
import com.campusgo.db.entity.Product;
import com.campusgo.db.entity.User;

public class UserService implements IUserService
{

	@Override
	public boolean Login(User user) {
		// TODO Auto-generated method stub
		UserDal dal=new UserDal();
		String pwd = dal.selectUserInfoByNickname(user).getPwd();
		if(user.getPwd().equals(pwd))
			return true;
		else
			return false;
	}

	@Override
	public boolean Reg(User user) {
		// TODO Auto-generated method stub
		UserDal dal = new UserDal();
		if(dal.insertUserInfo(user)>0)
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<Product> ScanGoodsInfo(Product pro) {
		// TODO Auto-generated method stub
		ProductDal dal = new ProductDal();
		ArrayList<Product> list = dal.selectAll();
		return list;
	}

}
