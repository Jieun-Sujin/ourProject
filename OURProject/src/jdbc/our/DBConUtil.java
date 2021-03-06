package jdbc.our;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConUtil {

	private static Connection conn = null;
	
	private DBConUtil() {}
	
	//데이터베이스 접속을 위한 메서드
	//어플리케이션이 종료되기 전까지 접속된 상태로 상주해 있는다.
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/our?useSSL=false";
		conn = DriverManager.getConnection(url, "sujin", "1111");
		
		if(conn !=null) {
			System.out.println("접속 성공");
		}else {
			System.out.println("접속 실패");
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {if(pstmt != null) {pstmt.close();}
			} catch(Exception e) {e.printStackTrace();}
		try {if(conn != null) {conn.close();}
			} catch(Exception e) {e.printStackTrace();}	
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {if(rs != null) {rs.close();}
		} catch(Exception e) {e.printStackTrace();}
		
		close(conn, pstmt);
		
	}
	
}
