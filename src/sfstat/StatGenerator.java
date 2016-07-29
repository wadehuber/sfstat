package sfstat;

import java.util.ArrayList;

/**
 * Stat Generation class
 * Calculates different stats based on a list of Scores
 * 
 * @author Wade Huber & Mitch Jenkins
 *
 */
public class StatGenerator {
	
	ArrayList<Score> scores;

	/** 
	 * Default Constructor 
	 * Creates empty list
	 */
	public StatGenerator() {
		super();
		this.scores = new ArrayList<Score>();
	}

	public void addScore(Score s) {
		scores.add(s);
	}
	
	public double getAverageTotal(){
		int total = 0;
		
		for (Score s : scores) {
			total += s.getTotal();
		}
		
		return (double) total / (double) scores.size();
	}	
	
	public int[] getTotalsArray() {
		int[] totals = new int[scores.size()];
		
		int ii=0;			
		
		for (Score s : scores) {
			totals[ii] = s.getTotal();
			ii++;
		}

		return totals;
	}
	
	public double[] getAverageScores() {
		
		int numSubScores = scores.get(0).getCount();
		double averages[] = new double[numSubScores];
		
		for (Score s : scores) {
			int theseScores[] = s.getScores();
			for (int ii=0;ii<numSubScores;ii++) {
				averages[ii] += theseScores[ii];
			}
		}
		
		for (int ii=0;ii<numSubScores;ii++) {
			averages[ii] /= (double) scores.size();
		}
		
	    return averages;
	}

	public int[] getModeScores() {
		int modes[] = new int[scores.get(0).getCount()];
		
		
		for (int ii=0;ii<scores.get(0).getCount();ii++) {
			int[] categoryScores = extractOneColumn(ii);
			modes[ii] = IntArrayStats.mode(categoryScores);
		}
		
		return modes;
	}
	
	/**
	 * Calculate medians for each score category
	 * @return double array of medians 
	 */
	public double[] getMedianScores() {
		double medians[] = new double[scores.get(0).getCount()];
		
		
		for (int ii=0;ii<scores.get(0).getCount();ii++) {
			int[] categoryScores = extractOneColumn(ii);
			medians[ii] = IntArrayStats.median(categoryScores);
		}
		
		return medians;
	}

	private int[] extractOneColumn(int scoreIndex) {
	
		int myInts[] = new int[scores.size()];
		int ii=0;
		
		for (Score s : scores) {
			myInts[ii]=s.getScores()[scoreIndex];
			ii++;
		}
		
		return myInts;
	}
	
	public String toString() {
		String ret = "";
		
		for (Score s : scores) {
			ret += s + "\n";
		}
		return ret;
	}
	
	

}
