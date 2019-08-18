package main.main.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.front.CommandService;
import main.map.DAO.mapDAO;
import main.map.DTO.mapDTO;
import main.map.DTO.setMapDTO;

public class OutPutService implements CommandService{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String day = request.getParameter("day"), start_time = request.getParameter("start_time"),
				end_time = request.getParameter("end_time"), sex_count = request.getParameter("sex_count"),
				sex_choice = request.getParameter("sex_choice"), start_age = request.getParameter("start_age"),
				end_age = request.getParameter("end_age"), max = request.getParameter("max"),
				dong = request.getParameter("dong");
		
		String[] temp_dong = dong.replaceAll("\\p{Z}", "").split(",");
		String sql_dong = "";
		for(int i = 0; i < temp_dong.length; i++) {
			sql_dong+= "DONG = " + "\'" + temp_dong[i] + "\'";
			if(temp_dong.length - 1 != i) {
				sql_dong+= " or ";
			}
		}

		String table = day;
		ArrayList<setMapDTO> chart_list = new ArrayList<setMapDTO>();
		ArrayList<mapDTO> result = new ArrayList<mapDTO>();
		ArrayList<String> col_list = new ArrayList<String>();
		String desc = "";

		for (int times = Integer.parseInt(start_time); times <= Integer.parseInt(end_time); times += 1) {
			String time = (times < 10) ? "0" : "";
			time += "" + times;

			for (int sexs = 0; sexs <= Integer.parseInt(sex_count); sexs += 1) {
				String sex = null;
				if (sex_choice.equals("M")) {
					sex = sex_choice;
					sex_choice = "W";
				} else {
					sex = sex_choice;
					sex_choice = "M";
				}
				for (int age = Integer.parseInt(start_age); age <= Integer.parseInt(end_age); age += 10) {
					String column = day + "_T" + time + "_" + sex + age;
					col_list.add(column);
					desc += column + "+";
				}
			}
		}
		
		desc = desc.substring(0, desc.length()-1);
		
		for(String tab : col_list) {
			ArrayList<mapDTO> temp = mapDAO.getDao().select(tab, table, max, desc, sql_dong);

			chart_list.add(new setMapDTO(tab, temp));
			if(result.size() == 0) {
				result = temp;
			} else {
				for(int i = 0; i < temp.size(); i++) {
					result.get(i).setCount(result.get(i).getCount() + temp.get(i).getCount());
				}
			}
		}

		request.getSession().setAttribute("chart", chart_list);
		System.out.println(request.getSession().getAttribute("chart"));

		JsonArray json_list = new JsonArray();
		for (mapDTO dto : result) {
			for (int i = 0; i < dto.getCount(); i++) {
				JsonObject obj = new JsonObject();
				obj.addProperty("lat", dto.getX());
				obj.addProperty("lng", dto.getY());

				json_list.add(obj);
			}
		}

		JsonObject json_result = new JsonObject();
		json_result.add("positions", json_list);
		
		
		request.getSession().setAttribute("json", json_result);
		
		return "output_last.jsp";
	}

	@Override
	public boolean getType() {
		// TODO Auto-generated method stub
		return false;
	}

}
