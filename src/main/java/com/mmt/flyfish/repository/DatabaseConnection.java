package com.mmt.flyfish.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mmt.flyfish.constant.SQLConstants;
import com.mmt.flyfish.entity.ParkingLot;


/**
 * 
 */

/**
 * @author BABA HARI KISHAN
 *
 */
@Component
public class DatabaseConnection {
	
	
	public Connection getConnection() {
		
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		}
		catch(ClassNotFoundException e){
			System.out.println("Error inside Db Connection Class"+e.getMessage());
		}
		catch(SQLException e){
			System.out.println("Error inside Db Connection Class"+e.getMessage());
		}
		
		return con;		
	}
	
	public boolean authorize(String user,String pass) {
		Connection con = getConnection();
		if(con == null) return false;
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SQLConstants.AUTHENTICATE);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int count = rs.getInt(1);
				if(count >= 1) return true;
			}
		} catch (SQLException e) {		
			System.out.println("Error inside Authorize Method in DB Connection Class"+e.getMessage());
		}
		
		return false;
	}
	
	public boolean bookSlot(double latitude, double longitude, int userId) {
		
		Connection con = getConnection();
		if(con == null) return false;
		
		PreparedStatement ps;		
		try {
			ps = con.prepareStatement(SQLConstants.UPDATE_QRY);
			ps.setInt(1, userId);
			ps.setDouble(2, latitude);
			ps.setDouble(3, longitude);
			
			int count = ps.executeUpdate();
			if(count > 0) return true;
			
		} catch (SQLException e) {		
			System.out.println("Error inside Authorize Method in DB Connection Class"+e.getMessage());
		}
		
		return false;
	} 
	
	public int freeSlot(double latitude, double longitude){
		Connection con = getConnection();
		if(con == null) return 0;
		int billAmount = 0;
		PreparedStatement ps;		
		try {
			ps = con.prepareStatement(SQLConstants.STATUS_QRY);
			ps.setDouble(1, latitude);
			ps.setDouble(2, longitude);
			
			ResultSet rs = ps.executeQuery();			
			if(rs.next()){
				long timeConsumed = rs.getLong(1);
				int price = rs.getInt(2);
				billAmount = (int) (timeConsumed * price);
			}
			
			ps = con.prepareStatement(SQLConstants.DELETE_QRY);			
			ps.setDouble(1, latitude);
			ps.setDouble(2, longitude);
			
			ps.executeUpdate();			
			
		} catch (SQLException e) {		
			System.out.println("Error inside Authorize Method in DB Connection Class"+e.getMessage());
		}
		return billAmount;		
	}

	public List<ParkingLot> getAvailableSlots(double latitude, double longitude) {
		
		Connection con = getConnection();
		if(con == null) return null;
		
		PreparedStatement ps;
		List<ParkingLot> list = new ArrayList<ParkingLot>();
		
		try {
			ps = con.prepareStatement(SQLConstants.SEARCH_SLOTS_QRY);
			ps.setDouble(1, latitude);
			ps.setDouble(1, longitude);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				ParkingLot pObj = new ParkingLot();
				pObj.setLatitude(rs.getDouble(1));
				pObj.setLongitude(rs.getDouble(2));
				pObj.setPrice(rs.getInt(3));
				pObj.setAddress(rs.getString(4));				
				pObj.setName(rs.getString(5));
				list.add(pObj);
			}
		} catch (SQLException e) {		
			System.out.println("Error inside getAvailableSlots Method in DB Connection Class"+e.getMessage());
		}
		if(list.isEmpty()) return null;		
		return list;
	}
}
