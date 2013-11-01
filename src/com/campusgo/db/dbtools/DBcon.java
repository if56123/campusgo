package com.campusgo.db.dbtools;

import java.sql.*;
public class DBcon {
	private String forname = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://yzbay.eicp.net:47917/sql_goods";
	private String user = "postgres";
	private String pwd = "mytaobao";
	private Connection con = null;
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	//private Statement st = null;
	private PreparedStatement ps = null;
	public PreparedStatement getPs() {
		return ps;
	}
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}
	private ResultSet rs = null;
	public DBcon() { 
		try{
			Class.forName(forname);
			con = DriverManager.getConnection(url,user,pwd);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getPreparedStatement(String sql) {
		  try {
		   // 根据获取的数据库连接对象创建数据库 命令执行对象
			  ps = con.prepareStatement(sql);
		  } catch (Exception ex) {  
			  ex.printStackTrace();
		  }
		  // 返回数据库命令执行对象
		  return ps;
		 }
	public ResultSet Query(){
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int update(){
		int result = 0;
		try {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public void close(){
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
