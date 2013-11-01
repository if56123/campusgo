package com.campusgo.db.dao;

import java.util.ArrayList;
import com.campusgo.db.entity.Product;
import com.campusgo.db.entity.User;

public interface IProduct {

	public int insertProduct(Product product);//������Ʒ��Ϣ
	public int deleteProductById(Product product);//ɾ����Ʒͨ����ƷID
	public int updateProductById(Product product);//������Ʒ��Ϣ
	public Product selectProductById(Product product);//ͨ����ƷID������Ʒ��Ϣ
	public Product selectProductBySellerId(User user);//ͨ������ID�鿴��Ʒ��Ϣ
	public Product selectProductBySellerNickname(User user);//ͨ���������鿴��Ʒ��Ϣ
	public Product selectProductBySellerPhone(User user);//ͨ�����ҵ绰�鿴��Ʒ��Ϣ
	public Product selectProductBySchoolId(User user);//ͨ��ѧ�Ų鿴��Ʒ��Ϣ
	public ArrayList<Product> selectAll();//�鿴������Ʒ��Ϣ
	public void  SortByAddedTime(ArrayList<Product> oldList, int i);//����ʹ��ʱ������
	public void SortByPrice(ArrayList<Product> oldList,int i);//���ռ۸�����
	
}
