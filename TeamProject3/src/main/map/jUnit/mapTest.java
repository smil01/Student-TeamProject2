package main.map.jUnit;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.map.DAO.mapDAO;
import main.map.DTO.mapDTO;
import main.map.DTO.searchDTO;
import main.map.DTO.setMapDTO;

class mapTest {

	@Test
	void test() {
//		System.out.println(mapDAO.getDao().select(new searchDTO("SATURDAY", "00", "M", "10", "10")));
	}

	@Test
	void test2() {
//		for (mapDTO dto : mapDAO.getDao().select(new searchDTO("SATURDAY", "00", "M", "10", "10"))) {
//			System.out.println(dto);
//		}
	}

	@Test
	void test3() {
//		String day = "SATURDAY", start_time = "01", end_time = "01", sex_count = "1", sex_choice = "M",
//				start_age = "10", end_age = "10", max = "5";
//
//		String table = day;
//		ArrayList<String> columns = new ArrayList<String>();
//
//		for (int times = Integer.parseInt(start_time); times <= Integer.parseInt(end_time); times += 1) {
//			String time = (times < 10) ? "0" : "";
//			time += "" + times;
//
//			for (int sexs = 0; sexs <= Integer.parseInt(sex_count); sexs += 1) {
//				String sex = null;
//				if (sex_choice.equals("M")) {
//					sex = sex_choice;
//					sex_choice = "W";
//				} else {
//					sex = sex_choice;
//					sex_choice = "M";
//				}
//				for (int age = Integer.parseInt(start_age); age <= Integer.parseInt(end_age); age += 10) {
//					String column = day + "_T" + time + "_" + sex + age;
//					columns.add(column);
//				}
//			}
//		}
//		
//		for(String col : columns) {
//			System.out.println(col);
//		}
//
//	
	}
	
	@Test
	void test4() {
		String day ="MONDAY", start_time ="00",
				end_time = "01", sex_count ="1",
				sex_choice = "M", start_age = "10",
				end_age = "20", max = "5";
		
		String dong = "월계동, 상계동";
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

		System.out.println(json_result);
	}

}
