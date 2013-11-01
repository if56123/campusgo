package com.campusgo.db.dao;

import java.util.ArrayList;
import com.campusgo.db.entity.Product;
import com.campusgo.db.entity.User;

public interface IProduct {

	public int insertProduct(Product product);//插入商品信息
	public int deleteProductById(Product product);//删除商品通过商品ID
	public int updateProductById(Product product);//更新商品信息
	public Product selectProductById(Product product);//通过商品ID查找商品信息
	public Product selectProductBySellerId(User user);//通过卖家ID查看商品信息
	public Product selectProductBySellerNickname(User user);//通过卖家名查看商品信息
	public Product selectProductBySellerPhone(User user);//通过卖家电话查看商品信息
	public Product selectProductBySchoolId(User user);//通过学号查看商品信息
	public ArrayList<Product> selectAll();//查看所有商品信息
	public void  SortByAddedTime(ArrayList<Product> oldList, int i);//按照使用时间排序
	public void SortByPrice(ArrayList<Product> oldList,int i);//按照价格排序
	
}
