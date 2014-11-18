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
		scores = new int[scoreCount];
		for(int ii=0;ii<scoreCount;ii++) 
		{
			scores[ii] = Integer.parseInt(splitLine[ii+3]); 
		}
	}
	public Scores(String judge, int[] scores) 
	{
		super();
		this.judge = judge;
		this.scores = scores;
		count = scores.length;
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
	
	public String toString() 
	{
		return "Judge " + judge + ":" + Arrays.toString(scores);
	}
}
