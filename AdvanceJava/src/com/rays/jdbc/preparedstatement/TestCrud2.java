package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class TestCrud2 {
	
		public static void main(String[] args) throws Exception {
			

//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//			Date d = (Date) sdf.parse("2001-05-08");

			add(6, "Aditya ", "Mukati", "adi07@gmail.com", "pass@123", Date.valueOf("2004-02-25") , "Bhopal");

		}

			private static Connection getConnection() throws Exception {

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");
	
				return conn;

			}               
			
			private static void add(int id, String fname, String lname, String email, String pwd, Date dob, String address)
					throws Exception {

				Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?)");

				pstmt.setInt(1, id);
				pstmt.setString(2, fname);
				pstmt.setString(3, lname);
				pstmt.setString(4, email);
				pstmt.setString(5, pwd);
				pstmt.setDate(6, dob);
				pstmt.setString(7, address);

				int i = pstmt.executeUpdate();

				System.out.println("data inserted successfully " + i);

	}

}
