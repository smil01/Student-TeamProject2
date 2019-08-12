package main.test.Json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import main.Json.JsonService;

public class testJson implements JsonService{

	@Override
	public JsonObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonObject test = new JsonObject();
		
		test.addProperty("test1", 1);
		test.addProperty("test2", true);
		test.addProperty("test3", "3");
		
		return test;
	}
}
