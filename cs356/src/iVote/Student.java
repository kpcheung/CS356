package iVote;

import java.util.List;
import java.util.Random;

/**
 * This class stores all relevant information about a single Student which is their
 * student ID which is a randomly generated string of integers prefixed by "00" and
 * a list of their answers.
 * @author K
 *
 */

public class Student {
	
	/**
	 * A randomly generated student ID.
	 */
	private String ID;
	
	/**
	 * A list of the student's answers.
	 */
	private List<String> candidates;

	/**
	 * The default constructor for the Student class.
	 */
	public Student() {
		ID = generateID();
	}
	
	/**
	 * This method returns the student ID.
	 * @return	the student ID
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * This method returns the list of the student's answers.
	 * @return	The list of the students answers
	 */
	public List<String> getCandidates() {
		return candidates;
	}
	
	/**
	 * This method creates a randomly generated student ID.
	 * @return	A randomly generated student ID
	 */
	public String generateID() {
		Random rand = new Random();
	    int randNum = rand.nextInt((9000 - 1000) + 1) + 1000;
		return "00" + randNum;
	}
	
	/**
	 * This method adds the student's answers to the candidates list.
	 * @param candidates	T list of the student's answers
	 */
	public void addCandidates(List<String> candidates) {
		this.candidates = candidates;
	}
}
