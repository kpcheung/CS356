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
		private String question;
		
		/**
		 * This variable represents the list of possible answers to the question.
		 */
		private List<String> candidates;
		
		/**
		 * This variable represents a list of correct answers to the question. 
		 */
		private List<String> correctCandidates;
	
		/**
		 * This hashtable stores a list of students and their answers to the current question.
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
			this.question = q.getQuestion();
			this.candidates = q.getCandidates();
			this.correctCandidates = q.getCorrectCandidates();
			this.studentAnswers = new Hashtable<String, List<String>>();
			this.correctAnswers = 0;
		}
		
		/**
		 * This method receives answers from a single student.
		 * @param 	ID The student's ID
		 * @param 	ans The student's answer(s)
		 * @return 	<code>false</code> if the answer list is null;
		 * 			<code>true</code> otherwise.
		 */
		public boolean receiveAns(String ID, List<String> ans) {
			
			if(ans != null) {
				if(checkDupe(ID)) {
					studentAnswers.replace(ID, ans);
				}
				else {
					studentAnswers.put(ID, ans);
				}
				
				return true;
			}
			else {
				return false;
			}
		}
		
		/**
		 * Checks if the hashtable already contains the student ID.
		 * @return	<code>true</code> if the key already exists in the hashtable;
		 * 			<code>false</code> otherwise.
		 */
		public boolean checkDupe(String ID) {
			if(studentAnswers.containsKey(ID)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		/**
		 * Prints out the statistics of how many students chose each candidate for the question.
		 */
		public void showResults() {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("\nQuestion: " + question);
			
			for (String candidate : candidates) {
				int numChosen = 0;
				for(String ID : studentAnswers.keySet()) {
					for(String studentAns : studentAnswers.get(ID)) {
						if(studentAns.equals(candidate)) {
							numChosen++;
						}
						for(String c : correctCandidates) {
							if(studentAns.equals(c)) {
								correctAnswers++;
							}
						}
					}
				}
				System.out.println(candidate + "\t\t\t" + numChosen);
			}
			
			System.out.println("\nTotal students who submitted answers: " + studentAnswers.size());
			System.out.println("Total correct answers: " + correctAnswers / candidates.size());
			System.out.println();
			System.out.println("KEY: " + correctCandidates);
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
		}
}
