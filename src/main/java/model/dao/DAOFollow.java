package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Follow;
import model.FollowList;
import model.User;


public class DAOFollow {
	private final String URL = "jdbc:mariadb://localhost/mutter";
	private final String USER = "root";
	private final String PASS = "root";
	public boolean findAll(FollowList fl) {
		List<Follow> l=new ArrayList<>();
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
		String sql ="SELECT follow,follower FROM follow";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			int follow=rs.getInt("follow");
			int follower=rs.getInt("follower");
			Follow f=new  Follow(follow,follower);
			l.add(f);
		}
		fl.setFl(l);
		return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public FollowList findFollower(User u) {
		List<Follow> l=new ArrayList<>();
		FollowList fl=new FollowList();
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
		String sql ="SELECT follow,follower FROM follow";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			int follow=rs.getInt("follow");
			int follower=rs.getInt("follower");
			if(follow==u.getId()) {
				Follow f=new  Follow(follow,follower);
				l.add(f);
		}
			}
		fl.setFl(l);
		return fl;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return fl;
	}
	public FollowList findFollow(User u) {
		List<Follow> l=new ArrayList<>();
		FollowList fl=new FollowList();
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
		String sql ="SELECT follow,follower FROM follow";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			int follow=rs.getInt("follow");
			int follower=rs.getInt("follower");
			if(follower==u.getId()) {
				Follow f=new  Follow(follow,follower);
				l.add(f);
		}
		}fl.setFl(l);
			return fl;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return fl;
	}
	public boolean follow(User u1,User u2) {
		if(!check(u1,u2)) {
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
			String sql ="INSERT INTO follow(follower,follow) "
					+ "values("+u1.getId()+","+u2.getId()+");";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			int result=pStmt.executeUpdate();
			if(result !=1) {
				return false;
			}}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return true;
		}
		return false;

	}
	public boolean check(User followerU,User followU) {
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
		String sql ="SELECT follow,follower FROM follow";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			int follow=rs.getInt("follow");
			int follower=rs.getInt("follower");
				if(follow==followU.getId()) {
					if(follower==followerU.getId()) {
						return true;
					}
				}
		}
		return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
