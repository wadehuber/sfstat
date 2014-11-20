package sfstat;

public class Entry 
{
	private String entry;
	private int[] score;

	public Entry(String entry, int[] score)
	{
		setEntry(entry);
		setScore(score);
	}
	public void setEntry(String entry)
	{
		this.entry = entry;
	}
	public void setScore(int[] score)
	{
		this.score = score;
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
