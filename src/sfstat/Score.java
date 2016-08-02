package sfstat;

import java.util.Arrays;

/**
 * Score class
 * Each Score object contains the scores across all categories from a single judge
 * 
 * @author Wade Huber & Mitch Jenkins
 * 
 */
public class Score 
{
	private String judge;
	private int[] scores;
	private int count;
	
	/**
	 * Full string constructor used when reading raw input
	 * 
	 * @param fileString Line containing scores
	 * @param scoreCount Number of scores
	 */
	public Score(String fileString, int scoreCount) 
	{
		String[] splitLine = fileString.split(",");
		judge = splitLine[2];
		gatherScores(scoreCount, splitLine);
	}
	
	/** 
	 * Constructor for processed data
	 * 
	 * @param judge Judges name
	 * @param scores Array of scores
	 */
	public Score(String judge, int[] scores) 
	{
		super();
		this.judge = judge;
		this.scores = scores;
		count = scores.length;
	}
	
	/**
	 * 
	 * @param scoreCount The number of scores
	 * @param splitLine Array of scires (as strings)
	 */
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
		String padding = "";
		if (judge.length() < 3) {
			padding = " ";
		}
		return padding + "Judge " + judge + ": " + getTotal() + "  scores: " + Arrays.toString(scores);
	}
}
