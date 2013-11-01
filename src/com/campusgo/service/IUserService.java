package com.campusgo.service;

import java.util.ArrayList;

import com.campusgo.db.entity.Product;
import com.campusgo.db.entity.User;

public interface IUserService 
{
	public boolean Login(User user);
	public boolean Reg(User user);
	public ArrayList<Product> ScanGoodsInfo(Product pro);

}
