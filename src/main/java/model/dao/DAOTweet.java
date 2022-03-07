package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;
import model.MutterList;

public class DAOTweet {
	private final String URL="jdbc:mariadb://localhost/mutter";
	private final String USER="root";
	private final String PASS="root";
	public boolean findAll(MutterList ml) {
		List<Mutter> l=new ArrayList<>();
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
		String sql ="select mutteruser.id, mutteruser.name,mutter.tweetid, mutter.tweet,mutter.time from mutteruser ,mutter \r\n"
				+ "where mutteruser.id=mutter.id order by mutter.tweetid;";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			String name=rs.getString("name");
			int id=rs.getInt("id");
			int tweetid=rs.getInt("tweetid");
			String tweet=rs.getString("tweet");
			String time=rs.getString("time");
			Mutter m=new  Mutter(name,tweet,time,id,tweetid);
			l.add(m);
		}
		ml.setmL(l);
		return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean add(MutterList ml,Mutter m) {
		List<Mutter>mll=ml.getmL();
		System.out.println(mll.size());
		try (Connection conn=DriverManager.getConnection(URL,USER,PASS)){
			m.setMutterId(mll.size());
			String sql ="INSERT INTO mutter(id,tweetid,tweet,time) "
					+ "values("+m.getUserId()+","+m.getMutterId()+",'"+m.getTweet()+"','"+m.getTime()+"');";
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
