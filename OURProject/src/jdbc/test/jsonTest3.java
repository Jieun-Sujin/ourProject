package jdbc.test;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException; 

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.net.URL; 

public class jsonTest3 { 
	
	public static void main(String args[]) {
		try {
			String KEY = "706870666b746e7737385675516170";
			String TYPE ="json";
			String SERVICE ="coffeeShopInfo";
			int START_INDEX =1;
			int END_INDEX =3;
			String urlStr ="http://openapi.seoul.go.kr:8088/"+KEY+"/"+TYPE+"/"+SERVICE+"/"+START_INDEX+"/"+END_INDEX;		
			
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
			JSONObject obj = (JSONObject) parser.parse(result); 
			// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다. 
			JSONObject parse_response = (JSONObject) obj.get("coffeeShopInfo");
			JSONObject parse_result = (JSONObject) obj.get("RESULT");
			JSONArray parse_cafeList =(JSONArray)parse_response.get("row");
			
			JSONObject cafe; 
			 
			for(int i = 0 ; i < parse_cafeList.size(); i++) { 
				cafe = (JSONObject) parse_cafeList.get(i); 
				String cafeName = (String)cafe.get("NM"); 
				String cafeeAddr =(String)cafe.get("ADDR");
				String cafeArea =(String)cafe.get("AREA");

				System.out.print("CAFE "+(i+1)); 
				System.out.print("    NM : "+cafeName);
				System.out.print("    ADDR : "+cafeeAddr);
				System.out.print("    AREA : "+cafeArea);
				System.out.println(); 
			} 
			bf.close(); 
			
			}catch(Exception e){ 
			    System.out.println(e.getMessage()); 
			}

	}
			
}
	
		
	
