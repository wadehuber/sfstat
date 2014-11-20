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
	
	
	public String toString() {
		String ret = "";
		
		for (Scores s : scores) {
			ret += s + "\n";
		}
		return ret;
	}
	
	

}
