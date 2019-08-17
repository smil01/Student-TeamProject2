package main.test.Json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.Json.JsonService;

public class testJson implements JsonService{

	@Override
	public JsonObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonObject test = new JsonObject(), test2 = new JsonObject(), result = new JsonObject();
		JsonArray list = new JsonArray();
		
		test.addProperty("lat", 37.63163577);
		test.addProperty("lng", 127.0419499);
		list.add(test);
		
		test2.addProperty("lat", 37.63163577);
		test2.addProperty("lng", 127.0419499);
		list.add(test2);
		
		result.add("positions", list);
		return result;
	}
}
