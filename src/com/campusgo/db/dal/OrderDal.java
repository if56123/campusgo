package com.campusgo.db.dal;

import java.util.ArrayList;

import com.campusgo.db.dao.IOrder;
import com.campusgo.db.entity.Order;
import com.campusgo.db.entity.User;

public class OrderDal implements IOrder
{

	@Override
	public int insertOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrderById(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrderById(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order selectOrderById(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectOrderBySellerId(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectOrderBySellerNickname(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectOrderBySellerPhone(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectOrderByBuyerId(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectOrderByBuyerNickname(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectOrderByBuyerPhone(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
