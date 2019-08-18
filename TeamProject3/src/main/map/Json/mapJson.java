package main.map.Json;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.Json.JsonService;
import main.map.DAO.mapDAO;
import main.map.DTO.mapDTO;
import main.map.DTO.searchDTO;
import main.map.DTO.setMapDTO;

public class mapJson implements JsonService {
	@Override
	public JsonObject execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return (JsonObject)request.getSession().getAttribute("json");
	}
}
