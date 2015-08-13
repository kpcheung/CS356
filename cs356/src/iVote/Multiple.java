package iVote;

import java.util.List;

/**
 * This class further defines a Question that has multiple correct answers.
 * @author Karen Cheung
 *
 */

public class Multiple extends Question {

	/**
	 * This is the default constructor for the Multiple class.
	 * @param question		The question header
	 * @param candidates	The list of possible answers to the question
	 * @param answer		The list of correct answers to the question
	 */
	public Multiple(String question, List<String> candidates,
			List<String> answer) {
		super(question, candidates, answer);
	}
}
