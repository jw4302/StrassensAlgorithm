import java.io.*;
import java.util.Scanner;
import com.google.common.base.Stopwatch;


/*
 * Find a resonable and possibly optimal arrayt sizse for strassesn's to 
 * switch from a recusive solution back to a brute force method
 * 
 */

// to creat your own random array in excel =RANDARRAY(512, 512,0,9,TRUE) 
public class strassensRunner {

	//TODO Implement Brute Force
	//TODO IMprement Strassens Algorithm
	//TODO Do not for getht ta you have to run an informal investitagtion to determine how large the matrixes need to be before the theoretical
	//advantages of strassen's Algorithm start to show
	public File pairFile = new File('/StrassensAlgorithm/src/example - 20 pairs.csv');
	public File matrixFile = new File('/StrassensAlgorithm/src/example - 20 pairs.csv');
	
	public static void Main(String args) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("What algorithm would you like to try?");
		System.out.println(" 1 foor Brute Force or 2 for Strassnes");
		
		int userChoice = userInput.netInt();
		
		switch(userChoice) {
		case 1:
			System.out.println("this is for brute force");
			//scan in from the 20 pairs example
			Scanner pairFile = new Scanner(pairFile);
			break;
		case 2:
			System.out.println("This is for Strassen's Algorithm");
			//scan in from the single matrix pair
			Scanner matrixFile = new Scanner(matrixFile);
			break;
		case 3:
			System.out.println("This is for Strassens but with ");
			break;
		default:
			System.out.println("This was not an option try again");
		}
		

	}
	
	
	public int randomNumGen(int n, int [][] A) {
		
		for(int i = 0; i <= n; i++) {
			int j =  i * math.random();
			int k =  i * math.random();
			A[i][h] +=
		}
	}
	
}
