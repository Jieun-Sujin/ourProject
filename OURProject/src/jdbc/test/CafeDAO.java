package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.test.DBConUtil;

public class CafeDAO{
	
	public List<CafeDTO> selectCafeList(){
		List<CafeDTO> cafeList = new ArrayList<CafeDTO>();
		System.out.println("===========list call=============");

		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		boolean state =false;
		
		try {
			conn =DBConUtil.getConnection();
			String sql = "SELECT id, cafe_name, cafe_addr,cafe_area FROM cafe";
			
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
			System.out.println("rows>>"+rows);
			
		}catch(Exception e) {
			DBConUtil.close(conn,pstmt);
		}
			
		return cafeList;
	}
	
	//파일의 기본정보 저장 
	public CafeDTO insertFile(CafeDTO cafeDTO) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		boolean state =false;
		String[] generateColumns = {"id"}; 
		
		try {
			conn =DBConUtil.getConnection();
			String sql ="INSERT INTO cafe(cafe_name,cafe_addr,cafe_area) VALUES(?,?);";
			pstmt= conn.prepareStatement(sql,generateColumns);
			
			pstmt.setString(1, cafeDTO.getName());
			pstmt.setString(2, cafeDTO.getAddr());
			pstmt.setString(3, cafeDTO.getArea());
			int rows = pstmt.executeUpdate();
			
			//진화된 try : catch 문이 필요 없음. 새로 생성된 key 중에서 자동 생성 된거 있어 ?
			try(ResultSet geneResultKey =pstmt.getGeneratedKeys()) {
				if(geneResultKey.next()) {
					cafeDTO.setId(geneResultKey.getLong(1)); //자동으로 생성된 key을 가져오겠다.
					System.out.println(geneResultKey.getLong(1));
				}
			}
			
			System.out.println("rows>>"+rows);
		}catch(Exception e) {
			e.printStackTrace();
			cafeDTO =new CafeDTO();
		}finally {
			DBConUtil.close(conn,pstmt);
		}
		
		return cafeDTO;
	}
	
}
