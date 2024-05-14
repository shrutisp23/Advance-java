package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDelete {
  public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");
	Statement stmt = conn.createStatement();
	int i = stmt.executeUpdate("delete from users where id = 3");
	System.out.println("Deleted Successfully"+i);
	
	ResultSet rs = stmt.executeQuery("select * from users");
	while (rs.next()) {
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getDate(6)+"  "+rs.getString(7));
	}
}
}
