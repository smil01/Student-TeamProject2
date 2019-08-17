package main.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.front.CommandService;
import main.member.DAO.memberDAO;
import main.member.DTO.memberDTO;

public class RegisterOPService implements CommandService {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		memberDTO input = new memberDTO(request.getParameter("name"), request.getParameter("id"),
				request.getParameter("pw"));

		return memberDAO.getDao().insert(input) ? "login.do" : "register.do"; // 회원가입 성공 : 회원가입 실패
	}

	@Override
	public boolean getType() {
		return true;
	}

}
