package sfstat;

import java.util.ArrayList;

public class Entry 
{
	private String entry;
	private int[] score;
	private ArrayList<Scores> ALScores;

	public Entry(String lastEntry, String entry, Scores tempScore)
	{
		setEntry(entry);
		setScore(tempScore.getScores());
	}
	public void setEntry(String entry)
	{
		this.entry = entry;
	}
	public void setScore(int[] score)
	{
		this.score = score;
	}
	public void setALScores(String lastEntry, String thisEntry, Scores tempScore, ArrayList<Scores> ALScores)
	{
		if (lastEntry.equals(thisEntry) && lastEntry != "")
		{
			ALScores.add(tempScore);
		}
		else
		{
			ALScores.clear();
			ALScores = new ArrayList<Scores>();
			ALScores.add(tempScore);
		}
		this.ALScores = ALScores;
	}
	public String getEntry()
	{
		return entry;
	}
	public int[] getScore()
	{
		return score;
	} 
	public ArrayList<Scores> getALScores()
	{
		return ALScores;
	}
}
