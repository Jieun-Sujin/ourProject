package jdbc.our;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.our.DBConUtil;

public class CafeDAO{
	
	public List<CafeDTO> selectCafeList(){
		List<CafeDTO> cafeList = new ArrayList<CafeDTO>();
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		boolean state =false;
		
		try {
			conn =DBConUtil.getConnection();
			String sql = "SELECT id, cafe_name, cafe_addr, cafe_area FROM cafe";
			
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//rs에 객체가 들어있다면 
			while(rs.next()) {
				int i=1;
				CafeDTO cafeDTO =new CafeDTO();
				
				cafeDTO.setId(rs.getLong(i++));
				cafeDTO.setName(rs.getString(i++));
				cafeDTO.setAddr(rs.getString(i++));
				cafeDTO.setArea(rs.getString(i++));
				cafeList.add(cafeDTO);
			}
			
			int rows = pstmt.executeUpdate();
			//System.out.println("rows>>"+rows);
			
		}catch(Exception e) {
			DBConUtil.close(conn,pstmt);
		}
			
		return cafeList;
	}
	
	
	public void insertCafe(CafeDTO cafeDTO) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		try {
			
			conn =DBConUtil.getConnection();
			
			String sql ="INSERT INTO cafe(cafe_name, cafe_addr, cafe_area) VALUES(?, ?, ?)";
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, cafeDTO.getName());
			pstmt.setString(2, cafeDTO.getAddr());
			pstmt.setString(3, cafeDTO.getArea());
			int rows = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DBConUtil.close(conn,pstmt);
		}
		
	}
	
	public void insertCafe(List<CafeDTO> cafeList) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		try {
			
			conn =DBConUtil.getConnection();
			
			String sql ="INSERT INTO cafe(cafe_name, cafe_addr, cafe_area) VALUES(?, ?, ?)";
			pstmt= conn.prepareStatement(sql);
			for(CafeDTO cafeDTO :cafeList) {
				pstmt.setString(1, cafeDTO.getName());
				pstmt.setString(2, cafeDTO.getAddr());
				pstmt.setString(3, cafeDTO.getArea());
				pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DBConUtil.close(conn,pstmt);
		}
		
	}
}
