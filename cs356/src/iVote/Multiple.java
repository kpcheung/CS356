package iVote;

import java.util.List;

/**
 * This class further defines a Question that has multiple correct answers.
 * @author Karen Cheung
 *
 */

public class Multiple extends Question {

	public Multiple(String question, List<String> candidates,
			List<String> answer) {
		super(question, candidates, answer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkAns(List<String> submittedAns) {
		// TODO Auto-generated method stub
		
	}

	
}
