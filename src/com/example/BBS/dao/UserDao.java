package com.example.BBS.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class UserDao {
	//连接数据库的代码
	public static Connection getCon() {
		//数据库连接名称
		String username="root";
		//数据库连接密码
		String password="qysn19980614";
		String driver="com.mysql.cj.jdbc.Driver";
		//其中test为数据库名称
		String url="jdbc:mysql://localhost:3306/zzgyy?characterEncoding=utf8&serverTimezone=UTC";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	//进行查询的方法，若含有满足条件的数据则返回true
	public static boolean getSelect(String userName,String password) { 
		boolean flag=false;
		String sql = "select * from User where name='"+userName+"' and password='"+password+"'"; 
		Connection conn = getCon();
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag=true;
			}
		} catch (Exception e) {
		}
		return flag;
	}
	//插入
	public static boolean insertUser(String userName,String password) {
		boolean flag=false;
		String sql="select * from User where name='"+userName+"' and password='"+password+"'";
		Connection conn = getCon();
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (!rs.next()) {
				pst.execute("insert into User(name,password) values('"+userName+"','"+password+"')");
				flag=true;
			}
		} catch (Exception e) {
		}
		return flag;
	}
}

