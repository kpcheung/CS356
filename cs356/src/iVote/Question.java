package iVote;

import java.util.List;

/**
 * Question is an abstract class that houses the format of both MultipleChoice and SingleChoice questions.
 * @author Karen Cheung
 *
 */

public abstract class Question {
	
	/**
	 * This variable contains the header of the question.
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
	
	/**
	 * The default constructor for the Question class.
	 * @param question		The question header
	 * @param candidates	The list of possible answers for the question
	 * @param answer		The list of correct answers
	 */
	public Question(String question, List<String> candidates, List<String> answer) {
		this.question = question;
		this.candidates = candidates;
		this.answer = answer;
	}
	
	/**
	 * This method returns the question header.
	 * @return	The question header
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * This method returns the list of possible answers for the question
	 * @return	A list of possible answers for the question
	 */
	public List<String> getCandidates() {
		return candidates;
	}
	
	/**
	 * This method returns a list of correct answers for the question
	 * @return	A list of correct answers for the question
	 */
	public List<String> getCorrectCandidates() {
		return answer;
	}
}
