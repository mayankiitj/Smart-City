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
import com.mmt.flyfish.entity.Consultation;
import com.mmt.flyfish.entity.Medication;

/**
 * 
 */

/**
 * @author BABA HARI KISHAN
 *
 */
@Component
public class MedicalDocDao {
	
	public Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (ClassNotFoundException e) {
			System.out.println("Error inside Db Connection Class" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error inside Db Connection Class" + e.getMessage());
		}

		return con;
	}

	public boolean authorize(String user, String pass) {
		Connection con = getConnection();
		if (con == null)
			return false;

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SQLConstants.AUTHENTICATE);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int count = rs.getInt(1);
				if (count >= 1)
					return true;
			}
		} catch (SQLException e) {
			System.out.println("Error inside Authorize Method in DB Connection Class" + e.getMessage());
		}

		return false;
	}

	public Consultation getTreatmentDetail(String consultationKey) {

		Connection con = getConnection();
		if (con == null)
			return null;

		PreparedStatement ps;
		Consultation cObj = null;
		try {
			ps = con.prepareStatement(SQLConstants.TREATMENT_DETAIL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				cObj = new Consultation();
				cObj.setDisease(rs.getString(1));
				cObj.setDate(rs.getString(2));
				cObj.setDoctorFirstName(rs.getString(3));
				cObj.setDoctorLastName(rs.getString(4));
				cObj.setDoctorRating(rs.getInt(5));
				cObj.setConsultationId(rs.getString(6));
				cObj.setDescription(rs.getString(7));
				getMedications(cObj);
			}
		} catch (SQLException e) {
			System.out.println("Error inside Authorize Method in DB Connection Class" + e.getMessage());
		}

		return cObj;
	}

	private void getMedications(Consultation cObj) {
		Connection con = getConnection();
		if (con == null)
			return;
		ArrayList<Medication> arr = new ArrayList<Medication>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SQLConstants.MEDICATION_DETAIL);
			ps.setString(1, cObj.getConsultationId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Medication md = new Medication();
				md.setMedicationId(rs.getString(1));
				md.setMedicineName(rs.getString(2));
				md.setComposition(rs.getString(3));
				arr.add(md);

			}
		} catch (SQLException e) {
			System.out.println("Error inside Authorize Method in DB Connection Class" + e.getMessage());
		}
		cObj.setMedicationList(arr);

	}

	public List<Consultation> getConsultationList(int customerkey) {

		Connection con = getConnection();
		if (con == null)
			return null;

		PreparedStatement ps;
		List<Consultation> list = new ArrayList<Consultation>();

		try {
			ps = con.prepareStatement(SQLConstants.TREATMENT_LIST_QRY);
			ps.setInt(1, customerkey);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Consultation cObj = new Consultation();
				cObj.setDisease(rs.getString(1));
				cObj.setDate(rs.getString(2));
				cObj.setDoctorFirstName(rs.getString(3));
				cObj.setDoctorLastName(rs.getString(4));
				cObj.setDoctorRating(rs.getInt(5));
				cObj.setConsultationId(rs.getString(6));
				cObj.setCustomerId(customerkey);
				list.add(cObj);
			}
		} catch (SQLException e) {
			System.out.println("Error inside Authorize Method in DB Connection Class" + e.getMessage());
		}
		if (list.isEmpty())
			return null;
		return list;
	}
}
