package sfstat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sfstat 
{
	public static void main(String[] args) 
	{
		Scanner dataFile;
		String line;
		String filename="sfdata.csv";
		Scores tempScore;
		int SCORE_COUNT = 20;
		int entry = 0;
		
		try 
		{
			dataFile = new Scanner(new File(filename));
			while (dataFile.hasNext()) 
			{
				line = dataFile.nextLine();
				tempScore = new Scores(line, SCORE_COUNT);
				entry = getEntry(entry, tempScore);
				Entry nEntry = new Entry(entry);
				System.out.println("Entry " + nEntry.getEntry() + ": " + tempScore);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error Reading file");
		}
	}
	public static int getEntry(int entry, Scores tempScore)
	{
		if (entry == 0)
		{
			return 1;
		}
		else if (tempScore.getJudge().charAt(0) != 'A')
		{
			return entry;
		}
		else
		{
			return entry + 1;
		}
	}
}
