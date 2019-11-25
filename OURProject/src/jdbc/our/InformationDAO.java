package jdbc.our;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.our.DBConUtil;

public class InformationDAO{
	
	public List<BrandDTO> selectBrandList(){
		List<BrandDTO> brandList = new ArrayList<BrandDTO>();
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		boolean state =false;
		
		try {
			conn =DBConUtil.getConnection();
			String sql = "SELECT id, brand_name FROM brand";
			
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//rs에 객체가 들어있다면 
			while(rs.next()) {
				int i=1;
				BrandDTO brandDTO =new BrandDTO();
				brandDTO.setId(rs.getLong(i++));
				brandDTO.setName(rs.getString(i++));
				brandList.add(brandDTO);
			}
			
			int rows = pstmt.executeUpdate();
			//System.out.println("rows>>"+rows);
			
		}catch(Exception e) {
			DBConUtil.close(conn,pstmt);
		}
			
		return brandList;
	}
	
}
