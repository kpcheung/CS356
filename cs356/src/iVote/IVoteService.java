package iVote;

import java.util.Hashtable;
import java.util.List;

/**
 * IVoteService receives all Student answers to predefined Questions and checks whether
 * the answers are correct, and shows the results e.g. how many Students picked specific
 * answers and how many correct answers were received.
 * @author Karen Cheung
 *
 */

public class IVoteService {
		/**
		 * The question header.
		 */
		private Question question;
	
		/**
		 * This hash table stores a list of students and their answers to the current question.
		 */
		private Hashtable<String, List<String>> studentAnswers;
		
		/**
		 * This is a counter that counts the number of correct answers to the question.
		 */
		private int correctAnswers;

		/**
		 * The default constructor for IVoteService.
		 */
		public IVoteService(Question q) {
			this.question = question;
			this.studentAnswers = new Hashtable<String, List<String>>();
			this.correctAnswers = 0;
		}
		
		/**
		 * This method receives answers from a single student.
		 * @param ID The student's ID
		 * @param ans The student's answer(s)
		 * @return False if the answer list is null, true otherwise.
		 */
		public boolean receiveAns(String ID, List<String> ans) {
			if(ans != null) {
				
				
				
				return true;
			}
			else {
				return false;
			}
		}
		
		/**
		 * Checks if the hash table already contains the student ID.
		 * @return
		 */
		public boolean checkDupe(int ID) {
			if(studentAnswers.containsKey(ID)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void showResults() {
			System.out.println("Question: " + question);
			List<String> candidates = question.getCandidates();
			for (String candidate : candidates) {
				int numChosen = 0;
				for(String ID : studentAnswers.keySet()) {
					numChosen+=1;
				}
				System.out.println(candidate + "\t\t" + numChosen);
			}
			
			System.out.println("Total students who submitted answers: " + studentAnswers.size());
			System.out.println("Total correct answers: " + correctAnswers);
		}
}
