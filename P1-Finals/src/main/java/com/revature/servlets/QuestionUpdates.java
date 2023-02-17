package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.QuestionDao;
import com.revature.dao.impl.QuestionDaoImpl;
import com.revature.model.Question;

@WebServlet(urlPatterns = { "/editUser" })
public class QuestionUpdates extends HttpServlet {
	private static final long serialVersionUID = 4645721142572801101L;
	private QuestionDao userDao = new QuestionDaoImpl();

	public QuestionUpdates() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = (String) request.getParameter("id");

		Question editUser = null;
		editUser = userDao.findUser2(userId);
		request.setAttribute("editUser", editUser);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/users/editUserView.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}