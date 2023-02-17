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

@WebServlet(urlPatterns = { "/doAddUser" })
public class DoAddUser extends HttpServlet {
	private static final long serialVersionUID = 4645721142572801105L;
	private QuestionDao userDao = new QuestionDaoImpl();

	public DoAddUser() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String questionid = (String) request.getParameter("questionid");
		String questionsection = (String) request.getParameter("questionsection");
		String questiontext = (String) request.getParameter("questiontext");

		Question newUser = new Question(questionid, questionsection, questiontext);
		String errorString = null;

		String regex = "^[a-zA-Z][0-9]{2}$";

		if (questionid == null || !questionid.matches(regex)) {
			errorString = "Question ID is the string literal ^[a-zA-Z][0-9]{3}$ !";
		}

		if (errorString == null) {
			userDao.save(newUser);
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("newUser", newUser);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/users/addUserView.jsp");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/userList");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}