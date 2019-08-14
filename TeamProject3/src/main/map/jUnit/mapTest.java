package main.map.jUnit;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.map.DAO.mapDAO;
import main.map.DTO.mapDTO;
import main.map.DTO.searchDTO;

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
		String day = "SATURDAY", start_time = "01", end_time = "01", sex_count = "1", sex_choice = "M",
				start_age = "10", end_age = "10", max = "5";

		String table = day;
		ArrayList<String> columns = new ArrayList<String>();

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
					columns.add(column);
				}
			}
		}
		
		for(String col : columns) {
			System.out.println(col);
		}

	
	}

}
