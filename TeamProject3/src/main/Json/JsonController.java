package main.Json;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsonController
 */
@WebServlet("*.json")
public class JsonController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command = JsonUtil.getCommand(request);
		
		JsonService requestService = JsonMapper.getMap().get(command);
		
		System.out.println("================ Json 커멘드 확인 : " + command);
		if (requestService == null) {
			response.sendRedirect("error.do");
		} else {
			response.getWriter().print(requestService.execute(request, response));
		}
	}
}
