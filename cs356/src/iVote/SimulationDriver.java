package iVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The SimulationDriver runs a test version of iVoteService with a randomly generated
 * number of students and randomly generated answers to questions that are predefined.
 * @author Karen Cheung
 *
 */

public class SimulationDriver {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Simulation variables, i.e. sample questions, candidates, and correct answers
		 * for Multiple Candidate Questions and Single Candidate Questions.
		 */
		String questionMulti = "Which fruits are the superior fruits? (Choose all that apply)";
		List<String> candidatesMulti = new ArrayList<String>();
		String questionSingle = "Where's the beef? (A Wendy's fast food chain reference)";
		List<String> candidatesSingle = new ArrayList<String>();
		candidatesMulti.add("Durian");
		candidatesMulti.add("Apples");
		candidatesMulti.add("Persimmons");
		candidatesMulti.add("Grapes");
		candidatesMulti.add("Melons");
		candidatesSingle.add("There was never any beef.");
		candidatesSingle.add("It died with Clara Peller.");
		candidatesSingle.add("You should quit reading the Wendy's Wiki article.");
		candidatesSingle.add("Why are you wasting my time?");
		List<String> correctMulti = new ArrayList<String>();
		List<String> correctSingle = new ArrayList<String>();
		correctMulti.add("Persimmons");
		correctMulti.add("Melons");
		correctSingle.add("It died with Clara Peller.");
	}
	
	/**
	 * Creates a simulation of students answering questions.
	 * @param questionType Input 1 for single candidate questions, 2 for multiple candidate questions.
	 * @param question The question that is asked to the students.
	 * @param candidates The list of possible answers to the question.
	 * @param correctAns The correct answer(s) to the question.
	 */
	private static void simulation(int questionType, String question, List<String> candidates, List<String> correctAns) {
		/**
		 * The question that is either Multiple Candidate or Single Candidate.
		 */
		Question q;
		/**
		 * An instance of the IVoteService to evaluate the answers to the question.
		 */
		IVoteService iVote;
		
		/**
		 * A random number generator for use in randomizing the number of students.
		 */
		Random rand = new Random();
		
		/**
		 * Randomizes the number of students between 20-50 as with a standard classroom size.
		 */
		int randNumStudents = rand.nextInt((20 - 50) + 1) + 20;
		
		/**
		 * An array of the random number of students.
		 */
		Student[] students = new Student[randNumStudents];
		
		if(questionType == 1) {
			q = new Single(question, candidates, correctAns);
		}
		else {
			q = new Multiple(question, candidates, correctAns);
		}
		
		iVote = new IVoteService(q);
		
		for(int k = 0; k < students.length; k++) {
			students[k] = new Student();
			students[k].addCandidates(generateAns());
			
		}
	}

	/**
	 * Generates random answers per student.
	 * @return
	 */
	private static List<String> generateAns() {
		List<String> ans = new ArrayList<String>();
		
		return ans;
	}
}
