package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Question;

public interface QuestionDao {

	void save(Question user);

	void update(String userId, Question newUSer);

	void remove(String userId);

	Question findUser(String userId, String userPass);


	List<Question> allUsers() throws SQLException;

	Question findUser(String userId);

	Question findUser2(String questionId);

}
