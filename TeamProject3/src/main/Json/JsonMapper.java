package main.Json;

import java.util.HashMap;

import main.map.Json.mapJson;
import main.test.Json.testJson;

public class JsonMapper {
	public static HashMap<String, JsonService> getMap() {
		HashMap<String, JsonService> map = new HashMap<String, JsonService>();
		
		map.put("test.json", new testJson());
		map.put("map.json", new mapJson());
		
		return map;
	}
}
