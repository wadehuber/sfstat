package sfstat;

import java.util.ArrayList;

public class Entry 
{
	private String entry;
	private int grade;
	private ArrayList<Scores> scores;


	public Entry(String entry, int grade) {
		super();
		this.entry = entry;
		this.grade = grade;
		scores = new ArrayList<Scores>();
	}

	public void setEntry(String entry)
	{
		this.entry = entry;
	}
	public void addScores(Scores tempScore)
	{
			scores.add(tempScore);
	}
	public String getEntry()
	{
		return entry;
	}

	public ArrayList<Scores> getALScores()
	{
		return scores;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
