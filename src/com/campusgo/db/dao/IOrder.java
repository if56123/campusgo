package com.campusgo.db.dao;

import java.util.ArrayList;
import com.campusgo.db.entity.Order;
import com.campusgo.db.entity.User;

public interface IOrder {
	
	public int insertOrder(Order order);//插入订单信息
	public int deleteOrderById(Order order);//删除订单通过订单ID
	public int updateOrderById(Order order);//更新订单信息
	public Order selectOrderById(Order order);//通过订单ID查找订单信息
	public Order selectOrderBySellerId(User user);//通过卖家ID查看订单信息
	public Order selectOrderBySellerNickname(User user);//通过卖家名查看订单信息
	public Order selectOrderBySellerPhone(User user);//通过卖家电话查看订单信息
	public Order selectOrderByBuyerId(User user);//通过买家ID查看订单信息
	public Order selectOrderByBuyerNickname(User user);//通过买家名查看订单信息
	public Order selectOrderByBuyerPhone(User user);//通过买家电话查看订单信息
	public ArrayList<Order> selectAll();//查看所有订单信息
}
