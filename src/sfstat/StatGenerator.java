package sfstat;

import java.util.ArrayList;
import java.util.Arrays;

public class StatGenerator {
	
	ArrayList<Scores> scores;

	public StatGenerator() {
		super();
		this.scores = new ArrayList<Scores>();
	}

	public void addScore(Scores s) {
		scores.add(s);
	}
	
	public double getAverageTotal(){
		int total = 0;
		
		for (Scores s : scores) {
			total += s.getTotal();
		}
		
		return (double) total / (double) scores.size();
	}	
	
	public double[] getAverageScores() {
		
		int numSubScores = scores.get(0).getCount();
		double averages[] = new double[numSubScores];
		
		for (Scores s : scores) {
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
			int[] categoryScores = extractOneScore(ii);
			modes[ii] = mode(categoryScores);
		}
		
		return modes;
	}
	
	public double[] getMedianScores() {
		double medians[] = new double[scores.get(0).getCount()];
		
		
		for (int ii=0;ii<scores.get(0).getCount();ii++) {
			int[] categoryScores = extractOneScore(ii);
			medians[ii] = median(categoryScores);
		}
		
		return medians;
	}


	private double median(int[] a) {
		int[] vals = a.clone();
		Arrays.sort(vals);
		double ret = 0;

		if (vals.length % 2 != 0) {
			ret = (double) vals[vals.length / 2];
		}
		else {
			ret = (vals[vals.length / 2] + vals[(vals.length / 2) + 1]) / 2;
		}
		
		return ret;
	}
	
	private int mode(int[] a) {
		int mode = 0;
		int modeCount = 1;
		int current = 0;
		int count = 0;
		
		int[] vals = a.clone();
		Arrays.sort(vals);
		
		for (int ii=0;ii<vals.length;ii++) {
			if(vals[ii] == vals[current]) {
				count++;
			}
			else {
				if (count > modeCount) {
					mode = ii - 1;
					modeCount = count;
				}
				current = ii;
				count = 1;
			}
		}
		
		return vals[mode];
	}
	
	private int[] extractOneScore(int scoreIndex) {
	
		int myInts[] = new int[scores.size()];
		int ii=0;
		
		for (Scores s : scores) {
			myInts[ii]=s.getScores()[scoreIndex];
			ii++;
		}
		
		return myInts;
	}
	
	public String toString() {
		String ret = "";
		
		for (Scores s : scores) {
			ret += s + "\n";
		}
		return ret;
	}
	
	

}
