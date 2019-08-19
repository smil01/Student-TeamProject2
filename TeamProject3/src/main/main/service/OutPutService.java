package main.main.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.front.CommandService;
import main.map.DAO.mapDAO;
import main.map.DTO.chartDTO;
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
		Queue<String> q = new LinkedList<String>();
		Queue<String> qq = new LinkedList<String>();
		
		for (int times = Integer.parseInt(start_time); times <= Integer.parseInt(end_time); times += 1) {
			String time = (times < 10) ? "0" : "";
			time += "" + times;

			for (int sexs = 0; sexs <= Integer.parseInt(sex_count); sexs += 1) {
				String sex = null;
				if (sex_choice.equals("M")) {
					sex = sex_choice;
					if(Integer.parseInt(sex_count)==1)
					sex_choice = "W";
				} else {
					sex = sex_choice;
					if(Integer.parseInt(sex_count)==1)
					sex_choice = "M";
				}
				for (int age = Integer.parseInt(start_age); age <= Integer.parseInt(end_age); age += 10) {
					String column = day + "_T" + time + "_" + sex + age;
					q.offer(sex);
					qq.offer(time);
					col_list.add(column);
					desc += column + "+";
				}
			}
		}
		
		desc = desc.substring(0, desc.length()-1);
		
		HashMap<String, chartDTO> map = new HashMap<String, chartDTO>();
		ArrayList<String> local_list = new ArrayList<String>();
		
		HashMap<String, HashMap<String, Integer>> mmmap = new HashMap<String, HashMap<String,Integer>>();
		
		for(String tab : col_list) {
			ArrayList<mapDTO> temp = mapDAO.getDao().select(tab, table, max, desc, sql_dong);
			
			String sex = q.poll();
			String time = qq.poll();
			for(int i = 0; i < temp.size(); i++) {
				if(map.get(temp.get(i).getAddr()) == null) {
					chartDTO chart_temp = new chartDTO();
					
					chart_temp.setTotal(temp.get(i).getCount());
					if(sex.equals("M")) {
						chart_temp.setM(temp.get(i).getCount());
					} else {
						chart_temp.setW(temp.get(i).getCount());
					}
					
					local_list.add(temp.get(i).getAddr());
					map.put(temp.get(i).getAddr(), chart_temp);
					
					if(mmmap.get(temp.get(i).getAddr()) == null) {
						HashMap<String, Integer> time_map = new HashMap<String, Integer>();
						time_map.put(time, temp.get(i).getCount());
						
						mmmap.put(temp.get(i).getAddr(), time_map);
					} else {
						HashMap<String, Integer> time_map = mmmap.get(temp.get(i).getAddr());
						
						if(time_map.get(time) == null) {
							time_map.put(time, temp.get(i).getCount());
						} else {
							int a = time_map.get(time) + temp.get(i).getCount();
							time_map.put(time, a);
						}
						
						mmmap.put(temp.get(i).getAddr(), time_map);
					}
				} else {
					int ttt = map.get(temp.get(i).getAddr()).getTotal() + temp.get(i).getCount();
					map.get(temp.get(i).getAddr()).setTotal(ttt);
					
					if(sex.equals("M")) {
						int mmm = map.get(temp.get(i).getAddr()).getM() + temp.get(i).getCount();
						map.get(temp.get(i).getAddr()).setM(mmm);
					} else {
						int www = map.get(temp.get(i).getAddr()).getW() + temp.get(i).getCount();
						map.get(temp.get(i).getAddr()).setW(www);
					}
					
					if(mmmap.get(temp.get(i).getAddr()) == null) {
						HashMap<String, Integer> time_map = new HashMap<String, Integer>();
						time_map.put(time, temp.get(i).getCount());
						
						mmmap.put(temp.get(i).getAddr(), time_map);
					} else {
						HashMap<String, Integer> time_map = mmmap.get(temp.get(i).getAddr());
						
						if(time_map.get(time) == null) {
							time_map.put(time, temp.get(i).getCount());
						} else {
							int a = time_map.get(time) + temp.get(i).getCount();
							time_map.put(time, a);
						}
						
						mmmap.put(temp.get(i).getAddr(), time_map);
					}
				}
			}

			chart_list.add(new setMapDTO(tab, temp));
			if(result.size() == 0) {
				result = temp;
			} else {
				for(int i = 0; i < temp.size(); i++) {
					result.get(i).setCount(result.get(i).getCount() + temp.get(i).getCount());
				}
			}
		}

		request.setAttribute("chart", chart_list);
		request.setAttribute("chart_map1", mmmap);
		request.setAttribute("chart_map2", map);
		request.setAttribute("chart_key", local_list);
		
		System.out.println(map);
		

		JsonArray json_list = new JsonArray();
		for (mapDTO dto : result) {
			for (int i = 0; i < dto.getCount(); i++) {
				JsonObject obj = new JsonObject();
				obj.addProperty("lat", dto.getX());
				obj.addProperty("lng", dto.getY());

				json_list.add(obj);
			}
		}
		
		//[1,  37.8, 80.8, 41.8, 1, 2],
		String honto_map = "";
		
		for(int i = Integer.parseInt(start_time); i <= Integer.parseInt(end_time); i++) {
			String key = "";
			
			if(i < 10) {
				key += "0";
			}
			key += "" + i;
			
			honto_map += "[" + (i+1) + ", ";
			for(int j = 0; j < local_list.size(); j++) {
				honto_map += "" + mmmap.get(local_list.get(j)).get(key);
				
				if(j != local_list.size() - 1) {
					honto_map += ",";
				}
			}
			honto_map += "]";
			
			if(i != Integer.parseInt(end_time)) {
				honto_map += ",";
			}
		}
		request.setAttribute("honto_map", honto_map);
		
		

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
