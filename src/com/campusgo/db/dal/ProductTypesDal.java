package com.campusgo.db.dal;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.campusgo.db.dao.IProductType;
import com.campusgo.db.dbtools.DBcon;
import com.campusgo.db.entity.ProductType;

public class ProductTypesDal implements IProductType{

	public ProductTypesDal() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<ProductType> getProductTypes(int whichtype)
	{
		
		DBcon db = new DBcon();
		String sql = "select * from goodstype_"+whichtype;
		ProductType pt = null; 
		ArrayList<ProductType> list = new ArrayList<ProductType>();
		db.getPreparedStatement(sql);
		try {
			ResultSet rs = db.Query();
			while (rs.next()) {
				pt = new ProductType(); 
				pt.setProductId(rs.getInt(1));
				pt.setProductName(rs.getString(2));
				list.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		db.close();
		return list;
		
	}

}
