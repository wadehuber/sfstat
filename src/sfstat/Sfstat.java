package sfstat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Sfstat 
{
	public static void main(String[] args) 
	{
		Scanner dataFile;
		String line;
		String filename="sfdata.csv";
		Scores tempScore;
		StatGenerator stats = new StatGenerator();
		int SCORE_COUNT = 20;
		
		try 
		{
			dataFile = new Scanner(new File(filename));
			// loop to add scores 
			while (dataFile.hasNext()) 
			{
				String thisEntry;
				String entry, scores, judge;
				int[] thisScore;

				line = dataFile.nextLine();
				tempScore = new Scores(line, SCORE_COUNT);
				stats.addScore(tempScore); // Add all scores to a StatGenerator
				String[] splitLine = line.split(",");
				thisEntry = splitLine[0];
				thisScore = tempScore.getScores(); 
				Entry nEntry = new Entry(thisEntry, thisScore);

				entry = nEntry.getEntry();
				scores = Arrays.toString(nEntry.getScore());
				judge = tempScore.getJudge();
				
				System.out.println(" Entry: " + entry + " Judge: " + judge + " Scores: " + scores);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error Reading file");
		}
		
		System.out.println("All Stats: \n" + stats);
	}
}
