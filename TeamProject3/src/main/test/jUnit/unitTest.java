package main.test.jUnit;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

import main.test.DAO.TestDAO;
import main.test.DTO.TestDTO;

class unitTest {

	@Test
	void test() {
//		TestDAO dao = TestDAO.getDao();
//		ArrayList<TestDTO> test = dao.selectAll();
//		
//		for(TestDTO dto : test) {
//			System.out.println(dto);
//		}
	}
	
	@Test
	void test2() {
		String[] Rargs = {"--vanilla"};
		Rengine re = new Rengine(Rargs, false, null);
		System.out.println("Create R Engine...");
		
		if(!re.waitForR()) {
			System.out.println("Loding R");
			return;
		}
		
		REXP a = re.eval("a <- 10", true);
		System.out.println(a.asDouble());
	}

}
