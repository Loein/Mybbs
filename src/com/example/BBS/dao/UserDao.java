package com.example.BBS.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class UserDao {
	//�������ݿ�Ĵ���
	public static Connection getCon() {
		//���ݿ���������
		String username="root";
		//���ݿ���������
		String password="qysn19980614";
		String driver="com.mysql.cj.jdbc.Driver";
		//����testΪ���ݿ�����
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
	//���в�ѯ�ķ��������������������������򷵻�true
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
	//����
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

