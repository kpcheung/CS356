package iVote;

import java.util.List;

/**
 * Question is an abstract class that houses the format of both MultipleChoice and SingleChoice questions.
 * @author Karen Cheung
 *
 */

public abstract class Question {
	
	/**
	 * This variable contains the body of the question.
	 */
	private String question;
	
	/**
	 * This variable contains a list of possible answers for the question.
	 */
	List<String> candidates;
	
	/**
	 * This variable is a list of the correct answers.
	 */
	List<String> answer;
	
	public Question(String question, List<String> candidates, List<String> answer) {
		this.question = question;
		this.candidates = candidates;
		this.answer = answer;
	}
}
