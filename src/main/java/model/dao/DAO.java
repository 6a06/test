package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;
import model.EmployeeList;


public class DAO {
	private final String URL="jdbc:mariadb://localhost/example";
	private final String USER="root";
	private final String PASS="root";
	public EmployeeList findAll() {
		EmployeeList el=new EmployeeList();
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
		String sql ="SELECT id,name,age FROM EMPLOYEE";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			String id=rs.getString("id");
			String name=rs.getString("name");
			int age=rs.getInt("age");
			Employee e=new  Employee(id,name,age);
			el.add(e);
		}
		return el;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return el;
	}

}
