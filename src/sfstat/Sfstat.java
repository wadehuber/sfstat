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
		
		int ii = 0;
		
		try 
		{
			dataFile = new Scanner(new File(filename));
			while (dataFile.hasNext()) 
			{
				line = dataFile.nextLine();
				tempScore = new Scores(line, SCORE_COUNT);
				Entry nEntry = new Entry(ii);
				System.out.println(nEntry.getEntry());
				System.out.println("Line " + ii + ": " + tempScore);
				ii ++;
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error Reading file");
		}
	}
}
