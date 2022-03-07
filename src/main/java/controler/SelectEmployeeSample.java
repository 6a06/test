package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectEmployeeSample {
	public static void main(String[] args) {

    //データベースに接続
		try (Connection conn=DriverManager.getConnection(
				"jdbc:mariadb://localhost/mutter","root","root")){
		String sql ="SELECT id,name,pass FROM mutteruser";
		PreparedStatement pStmt=conn.prepareStatement(sql);
		ResultSet rs=pStmt.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String pass=rs.getString("pass");
			System.out.println(id);
			System.out.println(name);
			System.out.println(pass);

		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}