package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.UserList;


public class DAOMutter {
	private final String URL="jdbc:mariadb://localhost/mutter";
	private final String USER="root";
	private final String PASS="root";
	public boolean findAll(UserList ul) {
		List<User> l=new ArrayList<>();
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
		String sql ="SELECT id,name,pass FROM mutteruser ";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String pass=rs.getString("pass");
			User u=new  User(id,name,pass);
			l.add(u);
		}
		ul.setUl(l);
		return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean add(UserList ul,User u) {
		List<User>ull=ul.getUl();
		System.out.println(ull.size()+1);
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
			u.setId(ull.size());
			String sql ="INSERT INTO mutteruser(id,name,pass) "
					+ "values("+u.getId()+",'"+u.getName()+"','"+u.getPass()+"');";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			int result=pStmt.executeUpdate();
			if(result !=1) {
				return false;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return true;

	}

	public boolean follow(User u1,User u2) {
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
			String sql ="INSERT INTO follow(follower,follow) "
					+ "values("+u1.getId()+","+u2.getId()+");";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			int result=pStmt.executeUpdate();
			if(result !=1) {
				return false;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return true;

	}

}
