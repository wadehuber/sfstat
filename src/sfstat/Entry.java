package sfstat;

import java.util.ArrayList;

public class Entry 
{
	private String entry;
	private int[] score;

	public Entry(String lastEntry, String entry, Scores tempScore, ArrayList<Scores> ALScores)
	{
		setEntry(entry);
		setScore(tempScore.getScores());
		setALScores(lastEntry, entry, tempScore, ALScores);
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
			ALScores = new ArrayList<Scores>();
			ALScores.add(tempScore);
		}
	}
	public String getEntry()
	{
		return entry;
	}
	public int[] getScore()
	{
		return score;
	} 
}
