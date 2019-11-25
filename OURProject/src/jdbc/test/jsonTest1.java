package jdbc.test;

import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException; 
public class jsonTest1 { 
	
	//데이터 입력 
	
	/*
	public static void main(String[] args) throws ParseException { 
		// JSON DATA 는 가장 아래 단계에서 부터 만들어 나간다. 
		JSONObject data = new JSONObject(); 
		// date라는 이름의 JSON 객체를 만들어줍니다. 
		data.put("name", "Kim"); 
		data.put("age", 10); 
		JSONObject response = new JSONObject(); 
						
		// response라는 이름의 Key값으로 전에 만든 data객체를 Value로 넣어줍니다.
		response.put("response", data);  
		// toJSONString()이라는 메소드를 이용해서 response 객체의 데이터를 문저열로 바꾸어 줍니다.
		String json = response.toJSONString(); 
		System.out.println(json);
  
	}
	*/
	
	//Parsing
	public static void main(String[] args) throws ParseException{ 
		String json = "{\"response\":{\"name\":\"서울\",\"age\":10}}";
		
		// 파싱 객체 생성 
		JSONParser parser = new JSONParser(); 
		// json object 로 파싱해온다. 
		JSONObject object = (JSONObject) parser.parse(json); 
		//json문자열을 parse()하여 JSON Object형태로 변환합니다. 

		// 1. response 객체를 받아온다. 
		JSONObject parse_response = (JSONObject) object.get("response"); 
		String name = (String) parse_response.get("name"); 
		int age = ((Long)parse_response.get("age")).intValue(); //json의 기본반환형은 Long형입니다. 
		
		System.out.println("name : "+name); 
		System.out.println("age : "+age); 
  
	}
}
