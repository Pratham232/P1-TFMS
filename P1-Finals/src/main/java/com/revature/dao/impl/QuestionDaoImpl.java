package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.QuestionDao;
import com.revature.model.Question;
import com.revature.util.ConnectionFactory;
import com.revature.util.DbUtil;
import com.revature.util.QueryConstants;

public class QuestionDaoImpl implements QuestionDao {

	private Connection connection;
	private PreparedStatement preparedStatment;

	public QuestionDaoImpl() {
	}

	@Override
	public void save(Question user) {

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatment = connection.prepareStatement(QueryConstants.INSERT_USER);

			preparedStatment.setString(1, user.getUserLogin().toUpperCase());
			preparedStatment.setString(2, user.getUserPass());
			preparedStatment.setString(3, user.getRole());

			// Execute statement.
			int rowsInserted = preparedStatment.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("A new question added successfully!");
				connection.commit();
			}

		} catch (SQLException e) {
			System.out.println("SQLException in save() method");
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Rollback Exception in save() method");
				e1.printStackTrace();
			}
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}

	}

	@Override
	public void update(String userId, Question newUser) {

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatment = connection.prepareStatement(QueryConstants.UPDATE_USER);

			preparedStatment.setString(1, newUser.getUserLogin().toUpperCase());
			preparedStatment.setString(2, newUser.getUserPass());
			preparedStatment.setString(3, newUser.getRole());
			preparedStatment.setString(4, userId.toUpperCase());

			// Execute statement.
			int rowsUpdated = preparedStatment.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("User " + userId + " was updated successfully!");
				connection.commit();
			}

		} catch (SQLException e) {
			System.out.println("SQLException in update() method");
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Rollback Exception in update() method");
				e1.printStackTrace();
			}
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}

	}

	@Override
	public void remove(String userId) {

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			preparedStatment = connection.prepareStatement(QueryConstants.DELETE_USER);
			preparedStatment.setString(1, userId.toUpperCase());

			// Execute statement.
			int rowsDeleted = preparedStatment.executeUpdate();

			if (rowsDeleted > 0) {
				System.out.println("User " + userId + " was removed successfully!");
				connection.commit();
			}

		} catch (SQLException e) {
			System.out.println("SQLException in remove() method");
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Rollback Exception in remove() method");
				e1.printStackTrace();
			}
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}

	}

	@Override
	public Question findUser(String userId, String userPass) {

		ResultSet rs = null;
		Question found = null;

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(QueryConstants.SELECT_USER);
			preparedStatment.setString(1, userId.toUpperCase());
			preparedStatment.setString(2, userPass);
			rs = preparedStatment.executeQuery();
			if (rs.next()) {
				found = new Question(rs.getString(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return found;
	}
	
	@Override
	public Question findUser(String userId) {

		ResultSet rs = null;
		Question found = null;

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(QueryConstants.SELECT_USER_BY_ID);
			preparedStatment.setString(1, userId.toUpperCase());
			rs = preparedStatment.executeQuery();
			if (rs.next()) {
				found = new Question(rs.getString(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return found;
	}

	@Override
	public List<Question> allUsers() throws SQLException {

		ResultSet rs = null;
		List<Question> foundList = new ArrayList<Question>();
		Question currentUser = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(QueryConstants.SELECT_ALL_USER);
			rs = preparedStatment.executeQuery();
			while (rs.next()) {
				currentUser = new Question(rs.getString(1), rs.getString(2), rs.getString(3));
				foundList.add(currentUser);
			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return foundList;
	}

	@Override
	public Question findUser2(String questionId) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Question found = null;

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(QueryConstants.SELECT_USER2);
			preparedStatment.setString(1, questionId.toUpperCase());
			rs = preparedStatment.executeQuery();
			if (rs.next()) {
				found = new Question(rs.getString(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return found;
	}

}
