package jdbc.our;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.MalformedURLException; 
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;

public class CafeJSON {

	final static String serviceKey = "706870666b746e7737385675516170";
	
	public CafeDTO getCafe() {
		String TYPE ="json";
		String SERVICE ="coffeeShopInfo";
		int START_INDEX =1;
		int END_INDEX =1;
		
		String urlStr ="http://openapi.seoul.go.kr:8088/"+serviceKey+"/"+TYPE+"/"+SERVICE+"/"+START_INDEX+"/"+END_INDEX;		
		
		CafeDTO cafeDTO =new CafeDTO();
		
		try {
			URL url = new URL(urlStr); 
			BufferedReader bf; 
			String line = ""; 
			String result="";
			
			bf = new BufferedReader(new InputStreamReader(url.openStream())); 
			//버퍼에 있는 정보를 하나의 문자열로 변환. 
			while((line=bf.readLine())!=null){ 
				result=result.concat(line); 
				System.out.println(result); 
			}
			// Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
			JSONParser parser = new JSONParser(); 
			JSONObject jsonObj = (JSONObject) parser.parse(result); 
			// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다. 
			JSONObject parse_response = (JSONObject) jsonObj.get("coffeeShopInfo");
			JSONObject parse_result = (JSONObject) jsonObj.get("RESULT");
			JSONArray parse_cafeList =(JSONArray)parse_response.get("row");
			
			JSONObject obj; 
			 
			for(int i = 0 ; i < parse_cafeList.size(); i++) { 
				obj = (JSONObject) parse_cafeList.get(i); 
				cafeDTO.setName((String)obj.get("NM")); 
				cafeDTO.setAddr((String)obj.get("ADDR"));
				cafeDTO.setArea((String)obj.get("AREA"));
			
			} 
			
			bf.close(); 
			
			}catch(MalformedURLException e) {
				System.out.println("MalformedURLException"+e.getMessage()); 
			}catch(IOException e){ 
			    System.out.println("IOException"+e.getMessage()); 
			}catch(ParseException e){ 
			    System.out.println("ParseException"+e.getMessage()); 
			}

		return cafeDTO;
		
	}

	public List<CafeDTO> getCafeList() {
		String TYPE ="json";
		String SERVICE ="coffeeShopInfo";
		int START_INDEX =1;
		int END_INDEX =1000;
		
		List<CafeDTO>cafeList =new ArrayList<CafeDTO>();
		
		String urlStr ="http://openapi.seoul.go.kr:8088/"+serviceKey+"/"+TYPE+"/"+SERVICE+"/"+START_INDEX+"/"+END_INDEX;		
			
		try {
			URL url = new URL(urlStr); 
			BufferedReader bf; 
			String line = ""; 
			String result="";
			
			bf = new BufferedReader(new InputStreamReader(url.openStream())); 
			//버퍼에 있는 정보를 하나의 문자열로 변환. 
			while((line=bf.readLine())!=null){ 
				result=result.concat(line); 
				//System.out.println(result); 
			}
			// Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
			JSONParser parser = new JSONParser(); 
			JSONObject jsonObj = (JSONObject) parser.parse(result); 
			// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다. 
			JSONObject parse_response = (JSONObject) jsonObj.get("coffeeShopInfo");
			JSONObject parse_result = (JSONObject) jsonObj.get("RESULT");
			JSONArray parse_cafeList =(JSONArray)parse_response.get("row");
			
			JSONObject obj; 
			 
			for(int i = 0 ; i < parse_cafeList.size(); i++) { 
				obj = (JSONObject) parse_cafeList.get(i); 
				CafeDTO cafeDTO =new CafeDTO();
				cafeDTO.setName((String)obj.get("NM")); 
				cafeDTO.setAddr((String)obj.get("ADDR"));
				cafeDTO.setArea((String)obj.get("AREA"));
				cafeList.add(cafeDTO);
			} 
			
			bf.close(); 
			
			}catch(MalformedURLException e) {
				System.out.println("MalformedURLException"+e.getMessage()); 
			}catch(IOException e){ 
			    System.out.println("IOException"+e.getMessage()); 
			}catch(ParseException e){ 
			    System.out.println("ParseException"+e.getMessage()); 
			}

		return cafeList;
		
	}
}
