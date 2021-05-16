/**
 * @author Rogér
 */

package questions;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionDBTest {	

	private Question Question1;
	private Question Question2;
	private QuestionDB QuestionDB;

	@BeforeAll
	void setUp() throws Exception {
				
		this.QuestionDB = new QuestionDB();		

		// Question 1
		ArrayList<String> aw = new ArrayList<String>();
		Category category = null;
		
		this.Question1 = new Question(0, "Question 1", 1, aw, 3, category);

		// Question 2
		this.Question2 = new Question(0, "Question 2", 5, aw, 7, category);
	}
/*
	@AfterAll
	void tearDown() throws Exception {

		this.QuestionDB.finalize();
	}	*/

	@Test
	final void testCreate() {

		// Create question 1
		this.QuestionDB.create(this.Question1);

		// Create question 2
		this.QuestionDB.create(this.Question2);
	}

	@Test
	final void testUpdate() {

		// Update question 1 
		this.Question1.setQuestion("Update Question1");
		this.QuestionDB.update(this.Question1);
	}

	@Test
	final void testGetByID() {

		int id1 = this.Question1.getID();
		int id2 = this.Question1.getID();
		Question question1 = this.QuestionDB.getByID(id1);
		Question question2 = this.QuestionDB.getByID(id2);
		
		assertEquals(this.Question1, question1);
		assertEquals(this.Question2, question2);
	}

	@Test
	final void testGetByDifficulty() {

		int difficulty = this.Question1.getDifficulty();
		ArrayList<Question> questions = this.QuestionDB.getByDifficulty(difficulty);
		ArrayList<Question> questionList = new ArrayList<Question>();
		
		questionList.add((Question) this.Question1);

		assertEquals(questionList, questions);
	}

	@Test
	final void testGetByCategory() {

		Category category = this.Question1.getCategory();
		ArrayList<Question> questions = this.QuestionDB.getByCategory(category);
		ArrayList<Question> questionList = new ArrayList<Question>();
		
		questionList.add((Question) this.Question1);
		questionList.add((Question) this.Question2);

		assertEquals(questionList, questions);
	}

	@Test
	final void testGetAllQuestions() {

		ArrayList<Question> questions = this.QuestionDB.getAllQuestions();
		ArrayList<Question> questionList = new ArrayList<Question>();
		
		questionList.add((Question) this.Question1);
		questionList.add((Question) this.Question2);

		assertEquals(questionList, questions);
	}

	@Test
	final void testDelete() {

		// Delete test questions
		this.QuestionDB.delete(this.Question1.getID());
		this.QuestionDB.delete(this.Question2.getID());

		// Compare again. List should be empty by now		
		ArrayList<Question> questions = this.QuestionDB.getAllQuestions();
		ArrayList<Question> questionList = new ArrayList<Question>();
		assertEquals(questionList, questions);
	}
}
