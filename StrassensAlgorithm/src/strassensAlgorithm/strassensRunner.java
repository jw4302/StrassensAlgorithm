package strassensAlgorithm;
import java.util.Scanner;



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
	
	

	
	public static void Main(String args) {
		
        Scanner scan = new Scanner(System.in);
        System.out.println("Strassen Multiplication Algorithm Test\n");
//        Strassen s = new Strassen();

        System.out.println("Enter order n :");

        int N = scan.nextInt();

        /** Accept two 2d matrices **/

        System.out.println("Enter N order matrix 1\n");

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	
       
                A[i][j] = scan.nextInt();
            }
        }
        System.out.println("Enter N order matrix 2\n");

        int[][] B = new int[N][N];

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                B[i][j] = scan.nextInt();
            }
        }
        
        int[][] C = strasseens(A, B);

        System.out.println("\nProduct of matrices A and  B : ");

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {

                System.out.print(C[i][j] +" ");
            }
        
            System.out.println();
        }
        scan.close();
	}

	public int [][] bruteForce(int [][] matrixOne, int [][] matrixTwo) {
	
		 int size = matrixOne.length;
	     int [][] result = new int[size][size];
//	     Stopwatch timer = new Stopwatch();
//	     timer.start();
	     for(int i = 0; i < size; i++) {
	         for(int j = 0; j < size; j++) {
	             for(int k = 0; k < size; k++) {
	                 result[i][j] += matrixOne[i][k] * matrixTwo[k][j];
	             }
	         }
	     }
	     return result;
//	     timer.stop();
//	     System.out.println(timer);
	}
	
	
	 public static int[][] strasseens(int[][] A, int[][] B)
	    {
	        int n = A.length;
	        int[][] R = new int[n][n];
//	        Stopwatch timer = new Stopwatch();
//	        timer.start();
	        
	        //checking if there is only one element to multiply
	        if (n == 1)
	            R[0][0] = A[0][0] * B[0][0];
	 
	        else {
	        	
	            int[][] A11 = new int[n / 2][n / 2];
	            int[][] A12 = new int[n / 2][n / 2];
	            int[][] A21 = new int[n / 2][n / 2];
	            int[][] A22 = new int[n / 2][n / 2];
	            int[][] B11 = new int[n / 2][n / 2];
	            int[][] B12 = new int[n / 2][n / 2];
	            int[][] B21 = new int[n / 2][n / 2];
	            int[][] B22 = new int[n / 2][n / 2];
	 
	            split(A, A11, 0, 0);
	            split(A, A12, 0, n / 2);
	            split(A, A21, n / 2, 0);
	            split(A, A22, n / 2, n / 2);
	 
	            split(B, B11, 0, 0);
	            split(B, B12, 0, n / 2);
	            split(B, B21, n / 2, 0);
	            split(B, B22, n / 2, n / 2);
	 
	 
	            // M1:=(A1+A3)×(B1+B2)
	            int[][] M1= strasseens(add(A11, A22), add(B11, B22));
	           
	            // M2:=(A2+A4)×(B3+B4)
	            int[][] M2 = strasseens(add(A21, A22), B11);
	           
	            // M3:=(A1−A4)×(B1+A4)
	            int[][] M3 = strasseens(A11, sub(B12, B22));
	           
	            // M4:=A1×(B2−B4)
	            int[][] M4 = strasseens(A22, sub(B21, B11));
	           
	            // M5:=(A3+A4)×(B1)
	            int[][] M5 = strasseens(add(A11, A12), B22);
	           
	            // M6:=(A1+A2)×(B4)
	            int[][] M6 = strasseens(sub(A21, A11), add(B11, B12));
	           
	            // M7:=A4×(B3−B1)
	            int[][] M7 = strasseens(sub(A12, A22), add(B21, B22));
	 
	            // P:=M2+M3−M6−M7
	            int[][] C11 = add(sub(add(M1, M4), M5), M7);
	           
	            // Q:=M4+M6
	            int[][] C12 = add(M3, M5);
	           
	            // R:=M5+M7
	            int[][] C21 = add(M2, M4);
	           
	            // S:=M1−M3−M4−M5
	            int[][] C22 = add(sub(add(M1, M3), M2), M6);
	 
	            join(C11, R, 0, 0);
	            join(C12, R, 0, n / 2);
	            join(C21, R, n / 2, 0);
	            join(C22, R, n / 2, n / 2);
	        }
	 
	        return R;
	    }
	 //to complete strassens part 1
	 // Function to subtract two matrices
    public static int[][] sub(int[][] A, int[][] B) {
    	
        int n = A.length;
        int[][] C = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }
    
    //to complete strassens part 2
    // Function to add two matrices
    public static int[][] add(int[][] A, int[][] B){
 
        int n = A.length;
        int[][] C = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
    //to complete strassens part 3
    // Function to split parent matrix into child matrices
    public static void split(int[][] P, int[][] C, int iB, int jB) {
        
    	for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
 
                C[i1][j1] = P[i2][j2];
            }
        }
    }
    //final function needed to complete strassens
    // Function to join child matrices into parent matrix
    public static void join(int[][] C, int[][] P, int iB, int jB){
    	
    	for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
        	 for (int j1 = 0, j2 = jB; j1 < C.length;j1++, j2++) { 
            
        		 P[i2][j2] = C[i1][j1];
        	 }
    	}
    }
	
}
	

