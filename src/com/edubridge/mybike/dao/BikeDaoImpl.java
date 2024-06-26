package com.edubridge.mybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.mybike.model.Bike;
import com.edubridge.mybike.util.DBUtils;




public class BikeDaoImpl implements BikeDao{
	static Connection con=DBUtils.getConection();

	@Override
	public int addBike(Bike b) {
		String INSERT_QUERY="insert into Bike(id,companyname,bodytype,modelname,price) values(?,?,?,?,?) ";
		int status=0;
	try {
		PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
		ps.setInt(1, b.getId());
		ps.setString(2, b.getCompanyname());
		ps.setString(3, b.getBodytype());
		ps.setString(4, b.getModelname());
		ps.setInt(5, b.getPrice());
		
		
		status =ps.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return status;
}
	

	@Override
	public List<Bike> findBikes() {
		String SELECT_QUERY="select* from bike";
		List<Bike> bikeList=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 Bike b=new Bike();
				 b.setId(rs.getInt("id"));
		         b.setCompanyname(rs.getString("companyname"));
		         b.setBodytype(rs.getString("bodytype"));
		         b.setModelname(rs.getString("modelname"));
		         b.setPrice(rs.getInt("price"));
		         		         bikeList.add(b);
			 } 
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
		
		return bikeList;

		
	}

	@Override
	public Bike findBikeByName(String name) {
Bike b=null;
		
		String SELECT_QUERY ="Select * from bike where companyname=?";
		try {
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				b=new Bike();
				b.setId(rs.getInt("id"));
				b.setCompanyname(rs.getString("companyname"));
				b.setBodytype(rs.getString("bodytype"));
				b.setModelname(rs.getString("modelname"));
				b.setPrice(rs.getInt("price"));
			
				
			}
			 
		} catch (SQLException e) {
		   
			e.printStackTrace();
		}
		return b;

		
	}

	@Override
	public int updateBike(Bike b) {
		String UPDATE_QUERY ="update bike set companyname=?,bodytype=?,modelname=?,price=? where id=?";
		 int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
				ps.setString(1, b.getCompanyname());
				ps.setString(2, b.getBodytype());
				ps.setString(3, b.getModelname());
				ps.setInt(4, b.getPrice());
				ps.setInt(5, b.getId());
				
				status =ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return status;

		
	}

	@Override
	public int deleteBikeByName(String name) {
		String DELETE_QUERY="delete from bike where companyname=?";
		int status=0;
		try {
			PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
			ps.setString(1,name);
			status=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return status;
	}

	@Override
	public void deleteAllBikes() {
		String DELETE_QUERY="delete from bike";
		try {
			PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	}

	
