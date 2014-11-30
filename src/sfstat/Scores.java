package sfstat;

import java.util.Arrays;

public class Scores 
{
	private String judge;
	private int[] scores;
	private int count;
	
	// Constructors
	public Scores(String fileString, int scoreCount) 
	{
		String[] splitLine = fileString.split(",");
		judge = splitLine[2];
		gatherScores(scoreCount, splitLine);
	}
	public Scores(String judge, int[] scores) 
	{
		super();
		this.judge = judge;
		this.scores = scores;
		count = scores.length;
	}
	public void gatherScores(int scoreCount, String[] splitLine)
	{
		scores = new int[scoreCount];
		count = scoreCount;
		for(int ii=0;ii<scoreCount;ii++) 
		{
			scores[ii] = Integer.parseInt(splitLine[ii+3]); 
		}
	}
	public String getJudge() 
	{
		return judge;
	}
	public void setJudge(String judge) 
	{
		this.judge = judge;
	}
	public int[] getScores() 
	{
		return scores;
	}
	public void setScores(int[] scores) 
	{
		this.scores = scores;
	}
	public int getCount() 
	{
		return count;
	}
	public int getScoreCount() { 
		return scores.length;
	}
	public int getTotal()
	{
		int sum = 0;
		for(int ii=0;ii<count;ii++)
		{
			sum += scores[ii];  
		}
		return sum;	
	}
	public String toString() 
	{
		return "Judge " + judge + ": " + getTotal() + "   scores: " + Arrays.toString(scores);
	}
}
