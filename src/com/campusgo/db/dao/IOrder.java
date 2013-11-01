package com.campusgo.db.dao;

import java.util.ArrayList;
import com.campusgo.db.entity.Order;
import com.campusgo.db.entity.User;

public interface IOrder {
	
	public int insertOrder(Order order);//���붩����Ϣ
	public int deleteOrderById(Order order);//ɾ������ͨ������ID
	public int updateOrderById(Order order);//���¶�����Ϣ
	public Order selectOrderById(Order order);//ͨ������ID���Ҷ�����Ϣ
	public Order selectOrderBySellerId(User user);//ͨ������ID�鿴������Ϣ
	public Order selectOrderBySellerNickname(User user);//ͨ���������鿴������Ϣ
	public Order selectOrderBySellerPhone(User user);//ͨ�����ҵ绰�鿴������Ϣ
	public Order selectOrderByBuyerId(User user);//ͨ�����ID�鿴������Ϣ
	public Order selectOrderByBuyerNickname(User user);//ͨ��������鿴������Ϣ
	public Order selectOrderByBuyerPhone(User user);//ͨ����ҵ绰�鿴������Ϣ
	public ArrayList<Order> selectAll();//�鿴���ж�����Ϣ
}
