package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql ="select * from test",result=""; //이안에 어떤 테이블이있는지 보는
		List<String>list = new ArrayList<String>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.ORACLE_ID,Constants.ORACLE_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("id");
				list.add(result);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
