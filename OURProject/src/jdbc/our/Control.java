package jdbc.our;

import java.util.List;

public class Control {
	public static void main(String args[]) {
		CafeJSON cafeJson =new CafeJSON();
		
		
		//CafeDTO cafeDTO =cafeJson.getCafe();
		//CafeDAO cafeDAO = new CafeDAO();
		//cafeDAO.insertCafe(cafeDTO);
		
		List<CafeDTO> cafeList =cafeJson.getCafeList();
		CafeDAO cafeDAO = new CafeDAO();
		//cafeDAO.insertCafe(cafeList);
		cafeList = cafeDAO.selectCafeList();
		
		for(CafeDTO cafeDTO : cafeList) {
			System.out.println(cafeDTO.getName());
		}
		
	
		
	}
}
