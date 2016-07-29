package sfstat;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
public class Sfstat 
{
	public static void main(String[] args) 
	{
		Scanner dataFile;
		String line;
		String filename="sfdata.csv";
		Score tempScore;
		StatGenerator stats = new StatGenerator();
		int SCORE_COUNT = 20;
		String lastEntry = "";
		ArrayList<Score> ALScores = new ArrayList<Score>();
		ArrayList<Entry> ALEntries = new ArrayList<Entry>();
		HashMap<String, Entry> entries = new HashMap<String,Entry>();
		
		try 
		{
			dataFile = new Scanner(new File(filename));
			// loop to add scores 
			while (dataFile.hasNext()) 
			{
				String thisEntry;
				int thisGrade;

				line = dataFile.nextLine();
				tempScore = new Score(line, SCORE_COUNT);
				stats.addScore(tempScore); // Add all scores to a StatGenerator
				String[] splitLine = line.split(",");
				thisEntry = splitLine[0];
				thisGrade = Integer.parseInt(splitLine[1]);
				Entry nEntry = new Entry(thisEntry, thisGrade);
				System.out.println("thisEntry: " + thisEntry + " " + tempScore.toString());
				lastEntry = thisEntry;
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error Reading file");
		}

		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println("\nAverage total: " + df.format(stats.getAverageTotal()));
		System.out.print("Mean scores: [");
		double averages[] = stats.getAverageScores();
		for(int ii=0;ii<averages.length-1;ii++) 
		{
			System.out.print(df.format(averages[ii]) + ", ");
		}
		
		System.out.println(df.format(averages[averages.length-1]) + "]");

		int modes[] = stats.getModeScores();
		System.out.print("Modes: ");
		IntArrayStats.printArray(modes);
		
		double medians[] = stats.getMedianScores();
		System.out.print("\nMedians: [ ");
		for (int ii=0;ii<medians.length;ii++ ) 
		{
			System.out.print(medians[ii] + " ");
		}
		System.out.println(" ]");
		
		int totals[] = stats.getTotalsArray();
		System.out.print("Totals: ");
		IntArrayStats.printArray(totals);
		
		System.out.print("\nClusters: ");
		IntArrayStats.getClusters(totals);
	}
	

}
