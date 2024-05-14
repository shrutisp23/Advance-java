package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCrud {
	public static void main(String[] args) throws Exception {
		getConnection();
//		add();
//		delete();
//	 update();
//search();
//		findById();
//	findByName();
	//findByEmail();
		 authentication();

	}
	private static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");
		return conn;

	}

	private static void authentication() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where Loginid  = 'patelshrutisp23@gmail.com' AND password = 'shruti'");
		if(rs != null) {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
						+ "  " + rs.getString(5) + "  " + rs.getDate(6) + "  " + rs.getString(7));
			
			}
			
		}
		else {
			System.out.println("Invalid Password and loginID");
		}
		
		
		
	}

	private static void findByEmail() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where Loginid  = 'patelshrutisp23@gmail.com'");
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
					+ "  " + rs.getString(5) + "  " + rs.getDate(6) + "  " + rs.getString(7));
		
		}
		
	}

	private static void findByName() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where firstname = 'shruti' And lastname = 'Patel'");
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
					+ "  " + rs.getString(5) + "  " + rs.getDate(6) + "  " + rs.getString(7));
		
		}
		
	}

	private static void findById() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where id = 2");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
					+ "  " + rs.getString(5) + "  " + rs.getDate(6) + "  " + rs.getString(7));
		}
		
	}



	private static void search() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
					+ "  " + rs.getString(5) + "  " + rs.getDate(6) + "  " + rs.getString(7));
		}

	}

	private static void update() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("update users set password = 'vivanpatel@123' where id = 2");
		System.out.println("Updated succesfully" + i);

	}

	private static void delete() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("delete from users where id = 3");
		System.out.println("Deleted Successfully" + i);

	}

	private static void add() throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(
				" insert into users values(4,'Neeraj', 'Chopra', 'nirajch0700@gmail.com', 'niraj@234', '2002-12-13', 'Indore')");
		System.out.println("inserted successfully" + i);

	}

}
