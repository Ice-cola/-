package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.bean.Pumproomregion;
import com.bean.pumproom;


public class Dao {
	private Connection conn;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void getConn(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncsws_pumproom","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(String name,String phone,int address1,int address2,String content,String img) throws SQLException{
		getConn();
		String sql = "insert into repair(name,phone,address1,address2,content,img) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, phone);
		ps.setInt(3, address1);
		ps.setInt(4, address2);
		ps.setString(5, content);
		ps.setString(6, img);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public List<Pumproomregion> getAddress() throws SQLException{
		getConn();
		String sql = "select * from pumproomregion";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Pumproomregion> list = new ArrayList<Pumproomregion>();
		while(rs.next()){
			Pumproomregion p = new Pumproomregion(rs.getInt("pumproomregionid"),rs.getString("regionname"));
			list.add(p);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
	
	public List<pumproom> getPumpRoom(int id) throws SQLException{
		getConn();
		String sql = "select * from pumproom where pumproomregionid =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		List<pumproom> list = new ArrayList<pumproom>();
		while(rs.next()){
			pumproom p = new pumproom(rs.getInt("PUMPROOM_ID"),rs.getString("PUMPROOM_NAME"));
			list.add(p);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
}
