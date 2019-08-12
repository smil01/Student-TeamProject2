package main.Json;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

public interface JsonService {
	public JsonObject execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
