package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.QuestionDao;
import com.revature.dao.impl.QuestionDaoImpl;
import com.revature.model.Question;

@WebServlet(urlPatterns = { "/doEditUser" })
public class DoEditUser extends HttpServlet {
	private static final long serialVersionUID = 4645721142572801104L;
	private QuestionDao userDao = new QuestionDaoImpl();

	public DoEditUser() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginId = (String) request.getParameter("loginId");
		String passowrd = (String) request.getParameter("questionsection");
		String role = (String) request.getParameter("questiontext");

		Question editUser = new Question(loginId, passowrd, role);
		userDao.update(loginId, editUser);
		response.sendRedirect(request.getContextPath() + "/userList");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}