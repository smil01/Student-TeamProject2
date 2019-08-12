package main.test.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.front.CommandService;
import main.test.DAO.TestDAO;
import main.test.DTO.TestDTO;

public class TestService implements CommandService{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 작업공간
		TestDAO dao = TestDAO.getDao();
		ArrayList<TestDTO> test = dao.selectAll();
		
		request.setAttribute("test", test);
		
		// 이동 jsp
		return "test.jsp";
	}

	@Override
	public boolean getType() {
		// true : sendRedirect
		// flase : forward
		return false;
	}

}