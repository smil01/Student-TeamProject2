package main.front;

import java.util.HashMap;

import main.error.service.ErrorService;
import main.test.service.TestService;




public class CommandMapper {
	public static HashMap<String, CommandService> getMap() {
		HashMap<String, CommandService> map = new HashMap<String, CommandService>();
		
		map.put("test.do", new TestService());
		map.put("error.do", new ErrorService());
		
		return map;
	}
}
