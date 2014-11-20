package sfstat;

import java.util.ArrayList;

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
		for (int ii=0;ii<numSubScores;ii++) {
			averages[ii]=0.0;
		}

		
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
	
	public String toString() {
		String ret = "";
		
		for (Scores s : scores) {
			ret += s + "\n";
		}
		return ret;
	}
	
	

}