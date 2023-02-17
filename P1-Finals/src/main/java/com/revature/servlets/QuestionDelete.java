package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.QuestionDao;
import com.revature.dao.impl.QuestionDaoImpl;

@WebServlet(urlPatterns = { "/deleteUser" })
public class QuestionDelete extends HttpServlet {
	private static final long serialVersionUID = 4645721142572801106L;
	private QuestionDao userDao = new QuestionDaoImpl();

	public QuestionDelete() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = (String) request.getParameter("id");
		userDao.remove(userId);
		response.sendRedirect(request.getContextPath() + "/userList");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}