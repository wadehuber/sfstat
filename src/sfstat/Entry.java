package sfstat;

import java.util.ArrayList;

public class Entry 
{
	private String entry;
	private int grade;
	private ArrayList<Score> scores;

	public Entry(String entry, int grade) {
		super();
		this.entry = entry;
		this.grade = grade;
		scores = new ArrayList<Score>();
	}

	public void setEntry(String entry)
	{
		this.entry = entry;
	}
	public void addScores(Score tempScore)
	{
			scores.add(tempScore);
	}
	public String getEntry()
	{
		return entry;
	}

	public ArrayList<Score> getALScores()
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
