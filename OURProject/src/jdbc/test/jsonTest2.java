package jdbc.test;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException; 

public class jsonTest2 { 
	final static String key= "156238e23a254d72ae8c5dd983bb3adc";
	final static String Type="json";
	final static int pIndex =1;
	final static int pSize =100; //총 가져오는 카페 수 
	final static String SIGUM_NM= "수원시"; // 시군명
	final static int SIGUM_CD= 41110;  //시군 코드
	final String url 
	="https://openapi.gg.go.kr/Genrestrtcate?KEY=156238e23a254d72ae8c5dd983bb3adc&Type=json&pIndex=1&pSize=100&SIGUM_NM=%EC%88%98%EC%9B%90%EC%8B%9C&SIGUN_CD=41110";
	
	
	
	//데이터 입력 
	
	/*
	public static void main(String[] args) throws ParseException { 
		JSONObject data1 = new JSONObject(); 
		data1.put("name", "Kim"); 
		data1.put("age", 10); 
		
		JSONObject data2 = new JSONObject(); 
		data2.put("name", "Jung"); 
		data2.put("age",20); 
		
		JSONObject data3 = new JSONObject(); 
		data3.put("name", "Park"); 
		data3.put("age",30);
		
		JSONArray data_list = new JSONArray(); 
		data_list.add(data1); 
		data_list.add(data2); 
		data_list.add(data3);
		
		//1. 
		JSONObject itemList = new JSONObject(); 
		// ItemList이라는 Json객체를 만들어서 itemlist Key값으로 data_list Value를 넣어줍니다. 
		itemList.put("itemlist", data_list);
		
		//2.  
		JSONObject items = new JSONObject(); 
		items.put("items", itemList); 
		
		//3. header데이터 
		JSONObject header = new JSONObject(); 
		header.put("code", "00"); 
		header.put("error", "faile"); 
	
		//4.json 데이터 설정해 줍니다. 
		JSONObject jsondata = new JSONObject(); 
		jsondata.put("header", header); 
		jsondata.put("body", items); 
		
		//5.response 설정합니다.
		JSONObject response = new JSONObject(); 
		response.put("response", jsondata); 
		
		System.out.println(response.toJSONString());
	}
    */
	
	public static void main(String[] args) throws ParseException { 
			
		String response 
		= "{\"response\":{\"header\":{\"code\":\"00\",\"error\":\"faile\"},"
				+ "\"body\":{\"items\":{\"itemlist\":"
				+ "[{\"name\":\"서울\",\"age\":\"10\"},"
				+ "{\"name\":\"대전\",\"age\":\"20\"},"
				+ "{\"name\":\"대구\",\"age\":\"30\"}]}}}}"; 
		
		JSONParser paser = new JSONParser(); 
		JSONObject obj = (JSONObject) paser.parse(response);
		
		//Parser로 문자열 데이터를 JSON데이터로 변환합니다.
		JSONObject parse_response = (JSONObject) obj.get("response"); 
		JSONObject parse_body = (JSONObject) parse_response.get("body"); 
		JSONObject parse_items = (JSONObject) parse_body.get("items"); 
		
		// items로 부터 itemlist 를 받아옵니다.
		JSONArray parse_itemlist = (JSONArray) parse_items.get("itemlist"); 
		for (int i = 0; i < parse_itemlist.size(); i++) { 
			JSONObject imsi = (JSONObject) parse_itemlist.get(i); 
			String name = (String) imsi.get("name"); 
			String age = (String) imsi.get("age"); 
			System.out.println("배열의 " + i + "번째 요소"); 
			System.out.println("name : " + name +"  age "+age); 
			}
		}
	
}
	
