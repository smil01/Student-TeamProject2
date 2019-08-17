package main.front;

import java.util.HashMap;

import main.error.service.ErrorService;
import main.main.service.MainService;
import main.main.service.StartService;
import main.member.service.LoginOPService;
import main.member.service.LoginService;
import main.member.service.RegisterOPService;
import main.member.service.RegisterService;
import main.test.service.TestService;




public class CommandMapper {
	public static HashMap<String, CommandService> getMap() {
		HashMap<String, CommandService> map = new HashMap<String, CommandService>();
		
		map.put("test.do", new TestService());
		map.put("error.do", new ErrorService());
		map.put("start.do", new StartService());
		map.put("main.do", new MainService());
		map.put("login.do", new LoginService());
		map.put("search.do", new LoginOPService());
		map.put("register.do", new RegisterService());
		map.put("registerOp.do", new RegisterOPService());
		
		return map;
	}
}
