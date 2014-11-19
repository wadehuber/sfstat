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
		String entry;
		Scores tempScore;
		int SCORE_COUNT = 20;
		
		try 
		{
			dataFile = new Scanner(new File(filename));
			while (dataFile.hasNext()) 
			{
				String thisEntry;
				line = dataFile.nextLine();
				tempScore = new Scores(line, SCORE_COUNT);
				String[] splitLine = line.split(",");
				
				thisEntry = splitLine[0];
				System.out.print("Entry " + thisEntry);
			//	Entry nEntry = new Entry(thisEntry);
				// loop to add scores 

				Entry nEntry = new Entry(line);
				entry = nEntry.getEntry();
				System.out.println(" Entry " + nEntry.getEntry() + ": " + tempScore);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error Reading file");
		}
	}
}
