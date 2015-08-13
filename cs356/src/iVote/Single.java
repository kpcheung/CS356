package iVote;

import java.util.List;

/**
 * This class further defines a Question that only has one correct answer.
 * @author Karen Cheung
 *
 */

public class Single extends Question {

	public Single(String question, List<String> candidates,
			List<String> answer) {
		super(question, candidates, answer);
	}
}
