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
		System.out.println("===== iVote Simulation ==========================================");
		System.out.println("Hello, this is a simulation based on iVote.io\n");
		
		/**
		 * Simulation variables, i.e. sample questions, candidates, and correct answers
		 * for Multiple Candidate Questions and Single Candidate Questions.
		 */
		String questionMulti = "Which fruits are the superior fruits?\n";
		List<String> candidatesMulti = new ArrayList<String>();
		String questionSingle = "Where's the beef?\n(A Wendy's fast food chain reference)\n";
		List<String> candidatesSingle = new ArrayList<String>();
		candidatesMulti.add("a. Durian");
		candidatesMulti.add("b. Apples");
		candidatesMulti.add("c. Persimmons");
		candidatesMulti.add("d. Grapes");
		candidatesMulti.add("e. Melons");
		candidatesMulti.add("f. Peaches");
		candidatesMulti.add("g. Strawberries");
		candidatesSingle.add("a. There was never any beef.");
		candidatesSingle.add("b. It died with Clara Peller.");
		candidatesSingle.add("c. Please stop this madness...");
		candidatesSingle.add("d. Why are you wasting my time?");
		List<String> correctMulti = new ArrayList<String>();
		List<String> correctSingle = new ArrayList<String>();
		correctMulti.add("c. Persimmons");
		correctMulti.add("e. Melons");
		correctMulti.add("g. Strawberries");
		correctSingle.add("b. It died with Clara Peller.");
		
		simulation(1, questionSingle, candidatesSingle, correctSingle);
		simulation(2, questionMulti, candidatesMulti, correctMulti);
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
		int randNumStudents = rand.nextInt((20 - 10) + 1) + 10;
		
		/**
		 * An array of the random number of students.
		 */
		Student[] students = new Student[randNumStudents];
		
		if(questionType == 1) {
			System.out.println("== Single Candidate Question ==");
			System.out.println("Please choose one answer");
			q = new Single(question, candidates, correctAns);
		}
		else {
			System.out.println("== Multiple Candidate Question ==");
			System.out.println("Choose all that apply");
			q = new Multiple(question, candidates, correctAns);
		}
		
		iVote = new IVoteService(q);
		
		for(int k = 0; k < students.length; k++) {
			students[k] = new Student();
			students[k].addCandidates(generateAns(questionType, candidates));
			iVote.receiveAns(students[k].getID(), students[k].getCandidates());
		}
		
		iVote.showResults();
	}

	/**
	 * Generates random answers per student.
	 * @return	A list of the answers the student has chosen
	 */
	private static List<String> generateAns(int questionType, List<String> candidates) {
		List<String> ans = new ArrayList<String>();
		Random rand = new Random();
		if(questionType == 1) {
			int randAns = rand.nextInt((candidates.size() - 1) + 1);
			ans.add(candidates.get(randAns));
		}
		
		//Multiple Candidate questions means there are multiple correct answers, but 
		//the statistics are useless if every student chooses all the options so they
		//are limited to the amount of available options minus one.
		else {
			int randNumAns = rand.nextInt(((candidates.size() - 1) - 1) + 1) + 1;
			for(int i = 0; i < randNumAns; ++i) {
				int randAns = rand.nextInt((candidates.size() - 1) + 1);
				for(String candidate : candidates) {
					if(!ans.contains(candidates.get(randAns))) {
						ans.add(candidates.get(randAns));
					}
				}
			}
		}
		return ans;
	}
}
