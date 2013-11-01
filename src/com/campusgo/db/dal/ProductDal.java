package com.campusgo.db.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.campusgo.db.dao.IProduct;
import com.campusgo.db.entity.Product;
import com.campusgo.db.entity.User;
import com.campusgo.db.dbtools.DBcon;

public class ProductDal implements IProduct {

	@Override
	public int insertProduct(Product product) {//添加数据
		// TODO Auto-generated method stub
		DBcon db = new DBcon();
		int result = 0;

		
		String sql = "insert into goodsinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.getPreparedStatement(sql);		
		try {
			db.getPs().setInt(1, product.getGoodsid());
			db.getPs().setString(2, product.getGoodsname());
			db.getPs().setInt(3, product.getPrice());
			db.getPs().setInt(4, product.getSellerid());
			db.getPs().setInt(5, product.getType1_id());
			db.getPs().setInt(6, product.getType2_id());
			db.getPs().setString(7, product.getQuality());
			db.getPs().setString(8, product.getMarque());
			db.getPs().setString(9, product.getAddadtime());
			db.getPs().setInt(10, product.getGoodsnum());
			db.getPs().setString(11, product.getDescribe());
			db.getPs().setInt(12, product.getDelmark());
			db.getPs().setInt(13, product.getSelemode());
			result = db.update();

		} catch (Exception e) {
			e.printStackTrace();

		}
		db.close();
		return result;
	}

	@Override
	public int deleteProductById(Product product) {//删除操作
		// TODO Auto-generated method stub
		DBcon db = new DBcon();
		int result = 0;
		int goodsid = product.getGoodsid();
		String sql = "delete from goodsinfo where goodsid=?";
		db.getPreparedStatement(sql);		
		try {
			db.getPs().setInt(1, goodsid);
			result = db.update();

		} catch (Exception e) {
			e.printStackTrace();

		}
		db.close();
		return result;
	}

	@Override
	public int updateProductById(Product product) {//更新操作
		// TODO Auto-generated method stub
		DBcon db = new DBcon();
		int result = 0;
		int goodsid = product.getGoodsid();
		String goodsname = product.getGoodsname();
		int price = product.getPrice();
		int sellerid = product.getSellerid();
		int type1_id = product.getType1_id();
		int type2_id = product.getType2_id();
		String quality = product.getQuality();
		String marque = product.getMarque();
		String addedtime = product.getAddadtime();
		int goodsnum = product.getGoodsnum();
		String describe = product.getDescribe();
		int delmark = product.getDelmark();
		int salemode = product.getSelemode();
		String sql = "update goodsinfo set goodsid = ? goodsname=? price=? sellerid=? type1_id=? type2_id=? quality=? marque=?  goodsnum=? describe=? delmark=? salemode=? while goodsid=?";
		try {
			db.getPreparedStatement(sql);
			db.getPs().setInt(1,goodsid);
			db.getPs().setString(2,goodsname);
			db.getPs().setInt(3,price);
			db.getPs().setInt(4,sellerid);
			db.getPs().setInt(5,type1_id);
			db.getPs().setInt(6,type2_id);
			db.getPs().setString(7,quality);
			db.getPs().setString(8,marque);
			db.getPs().setString(9,addedtime);
			db.getPs().setInt(10,goodsnum);
			db.getPs().setString(11,describe);
			db.getPs().setInt(12,salemode);
			db.getPs().setInt(13, goodsid);
			result=db.update();
			db.close();
			return result;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return -1;
		}
		
	}
	
	
	@Override
	public Product selectProductById(Product product) {
		// TODO Auto-generated method stub
		DBcon db = new DBcon();
		int goodsid = product.getGoodsid();
		String sql = "select * from goodsinfo where goodsid=?";
		Product _product = new Product();
		db.getPreparedStatement(sql);
		try {
			db.getPs().setInt(1,goodsid);
			ResultSet rs = db.Query();
			while (rs.next()) {
				_product.setGoodsid(rs.getInt(1));
				_product.setGoodsname(rs.getString(2));
				_product.setPrice(rs.getInt(3));
				_product.setSellerid(rs.getInt(4));
				_product.setType1_id(rs.getInt(5));
				_product.setType2_id(rs.getInt(6));
				_product.setQuality(rs.getString(7));
				_product.setMarque(rs.getString(8));
				_product.setAddadtime(rs.getString(9));
				_product.setGoodsnum(rs.getInt(9));
				_product.setDescribe(rs.getString(9));
				_product.setDelmark(rs.getInt(9));
				_product.setSelemode(rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		db.close();
		return _product;
	}

	@Override
	public Product selectProductBySellerId(User user) {
		// TODO Auto-generated method stub
		DBcon db = new DBcon();
		int usrid = user.getUsrid();
		String sql = "select * from goodsinfo where sellerid=?";
		Product _product = new Product();
		db.getPreparedStatement(sql);
		try {
			db.getPs().setInt(1,usrid);
			ResultSet rs = db.Query();
			while (rs.next()) {
				_product.setGoodsid(rs.getInt(1));
				_product.setGoodsname(rs.getString(2));
				_product.setPrice(rs.getInt(3));
				_product.setSellerid(rs.getInt(4));
				_product.setType1_id(rs.getInt(5));
				_product.setType2_id(rs.getInt(6));
				_product.setQuality(rs.getString(7));
				_product.setMarque(rs.getString(8));
				_product.setAddadtime(rs.getString(9));
				_product.setGoodsnum(rs.getInt(9));
				_product.setDescribe(rs.getString(9));
				_product.setDelmark(rs.getInt(9));
				_product.setSelemode(rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		db.close();
		return _product;
	}

	@Override
	public Product selectProductBySellerNickname(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectProductBySellerPhone(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectProductBySchoolId(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> selectAll() {
		// TODO Auto-generated method stub
		DBcon db = new DBcon();

		String sql = "select * from goodsinfo";
		ArrayList<Product> list = new ArrayList<Product>();
		Product _product = null;
		db.getPreparedStatement(sql);
		try {
			ResultSet rs = db.Query();
			while (rs.next()) {
				_product = new Product();
				_product.setGoodsid(rs.getInt(1));
				_product.setGoodsname(rs.getString(2));
				_product.setPrice(rs.getInt(3));
				_product.setSellerid(rs.getInt(4));
				_product.setType1_id(rs.getInt(5));
				_product.setType2_id(rs.getInt(6));
				_product.setQuality(rs.getString(7));
				_product.setMarque(rs.getString(8));
				_product.setAddadtime(rs.getString(9));
				_product.setGoodsnum(rs.getInt(10));
				_product.setDescribe(rs.getString(11));
				_product.setDelmark(rs.getInt(12));
				_product.setSelemode(rs.getInt(13));
				list.add(_product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		db.close();
		return list;
	}

	@Override
	public void SortByPrice(ArrayList<Product> oldList, int i) {
		// TODO Auto-generated method stub
		Comparator<Product> comparator1 = new Comparator<Product>() {
			public int compare(Product p1, Product p2) {

				return p2.getPrice() - p1.getPrice();
			}

		};
		Comparator<Product> comparator2 = new Comparator<Product>() {
			public int compare(Product p1, Product p2) {

				return p1.getPrice() - p1.getPrice();
			}

		};
		if (i == 1)
			Collections.sort(oldList, comparator1);
		else
			Collections.sort(oldList, comparator2);
	}

	@Override
	public void SortByAddedTime(ArrayList<Product> oldList, int i) {
		// TODO Auto-generated method stub
		Comparator<Product> comparator1 = new Comparator<Product>() {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			public int compare(Product p1, Product p2) {
				Date date1;
				Date date2;
				try {
					date1 = format.parse(p1.getAddadtime());
					date2 = format.parse(p2.getAddadtime());
					return (int) (date1.getTime() - date2.getTime());

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}

			}

		};
		Comparator<Product> comparator2 = new Comparator<Product>() {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			public int compare(Product p1, Product p2) {

				Date date1;
				Date date2;
				try {
					date1 = format.parse(p1.getAddadtime());
					date2 = format.parse(p2.getAddadtime());
					return (int) (date2.getTime() - date1.getTime());

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
			}

		};
		if (i == 1)
			Collections.sort(oldList, comparator1);
		else
			Collections.sort(oldList, comparator2);
	}

}
