package sfstat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sfstat {

	public static void main(String[] args) {

		Scanner dataFile;
		String line;
		String filename="sfdata.csv";
		Scores tempScore;
		
		int ii = 0;
		
		try {
			dataFile = new Scanner(new File(filename));
			while (dataFile.hasNext()) {
				line = dataFile.nextLine();
				tempScore = new Scores(line, 20);
				System.out.println("Line " + ii + ": " + tempScore);
				ii ++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error Reading file");
		}


	}

}
