package strassensAlgorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

import functions.bruteForceFunction;
import functions.matrixFunction;
import functions.strassensFunction;

public class runner {


	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		File matrixFile = new File("src/output-onlinemathtools(1).csv");
		Scanner fileReader;
		Scanner numberN;
		String timeLog;
		PrintWriter writer;
		
		System.out.println("This program will print out multiplication of Matrixs from 2 power of 1 to 2 power of 10");
		int caseNumber = 1; 
		int caseNumberLimit = 21;
		
		
		while(caseNumber < caseNumberLimit) {
		
			timeLog = ("timeLog" + caseNumber + ".txt");
			 writer = new PrintWriter(timeLog);
			
			for(int j = 1; j < 10; j++) {
				int n = j;
				int result = (int) Math.pow(2,n);
				int[][] A = new int[result][result];
				int row = 0;
				
				try {
					
					fileReader = new Scanner(matrixFile);
					while(fileReader.hasNextLine() && row < result) {
						String line = fileReader.nextLine();
						String[] lineSplit = line.split(",");
						for(int i =0; i < result; i++) {
							A[row][i] = Integer.parseInt(lineSplit[i]);
						}
						row++;
					}
				} catch (FileNotFoundException e) {
		
					//Terminates program if there is a failure
					System.out.println(e.getMessage());
					System.exit(1);
				}
				
				
				
				
				long start = System.nanoTime();
				bruteForceFunction.getInstance().execute(A, A);
				long stop = System.nanoTime();
				long bruteTime = stop - start;
				writer.println("Brute and Strassens Time at 2 power " + n );
				writer.println("Brute Force time for 2 to the " + n + " power was : "+ bruteTime + " nano seconds");
				
				start = System.nanoTime();
				strassensFunction.getInstance().execute(A, A);
				stop = System.nanoTime();
				long strasTime = stop - start;
				writer.println("Strassens Function time for 2 to the " + n + " power was : "+ strasTime + " nano seconds");
	
				long diffTime = strasTime - bruteTime;
				writer.println("Time difference between the two was : " + diffTime + "\n");
				
				LocalDateTime dateTime = LocalDateTime.now();
				writer.println("Done at " + dateTime);
				writer.flush();
				
		
			
			}
			
				writer.close();
				caseNumber++;
			}
		System.out.println("Done");
	}
}
