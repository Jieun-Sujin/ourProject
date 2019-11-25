package jdbc.our;

import java.util.List;

public class CafeService {

	private static CafeJSON cafeJson =null;
	
	private static CafeDAO cafeDAO =null;
	private static BeverageDAO beverageDAO =null;
	private static MenuDAO menuDAO =null;
	private static SeatDAO seatDAO =null;
	private static FacilityDAO facilityDAO =null;
	private static InformationDAO informationDAO =null;
	private static BrandDAO brandDAO =null;
	
	
	
	 public static void main(String args[]) { 
		 CafeService cafeService =new CafeService();
		 System.out.println(cafeService.checkBrand()); 
	 }
	
	 
	public static String checkBrand() {
		String result ="";
		
		List<CafeDTO> cafeList =cafeJson.getCafeList();
		List<BrandDTO> brandList =brandDAO.selectBrandList();
		
		CafeDAO cafeDAO = new CafeDAO();
		cafeList = cafeDAO.selectCafeList();
		
		for(CafeDTO cafeDTO : cafeList) {
			for(BrandDTO brandDTO : brandList) {
				if(cafeDTO.getName().contains(brandDTO.getName())) {
					result= result+cafeDTO.getName()+"   "+brandDTO.getName()+"\n";
				}
			}
			
		}

		return result;
	}
	

	public CafeService() {
		cafeJson =new CafeJSON();
		cafeDAO = new CafeDAO();
		beverageDAO =new BeverageDAO();
		menuDAO =new MenuDAO();
		seatDAO =new SeatDAO();
		facilityDAO =new FacilityDAO();
		informationDAO =new InformationDAO();
		brandDAO =new BrandDAO();
	}
	
	
	

}
