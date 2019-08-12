package main.test.jUnit;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.test.DAO.TestDAO;
import main.test.DTO.TestDTO;

class unitTest {

	@Test
	void test() {
		TestDAO dao = TestDAO.getDao();
		ArrayList<TestDTO> test = dao.selectAll();
		
		for(TestDTO dto : test) {
			System.out.println(dto);
		}
	}

}
