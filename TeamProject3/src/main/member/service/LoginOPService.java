package main.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.front.CommandService;
import main.member.DAO.memberDAO;
import main.member.DTO.memberDTO;

public class LoginOPService implements CommandService{
	boolean go = false;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		memberDTO result = memberDAO.getDao().select(new memberDTO(id, pw));

		if(result != null) {
			request.getSession().setAttribute("login", result);
			go = false;
			return "Input_Gw.html";
		}
		
		go = true;
		return "login.do";
	}

	@Override
	public boolean getType() {
		return go;
	}

}
