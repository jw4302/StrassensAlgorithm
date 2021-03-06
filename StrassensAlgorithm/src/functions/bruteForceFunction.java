package functions;

public class bruteForceFunction implements matrixFunction{
	
	private static bruteForceFunction instance; 
	
	public static bruteForceFunction getInstance() {
		if (instance == null) {
			instance = new bruteForceFunction();
		}
		return instance;
	}
	

	public int [][] execute(int [][] matrixOne, int [][] matrixTwo) {
		
		 int size = matrixOne.length;
	     int [][] result = new int[size][size];

	     for(int i = 0; i < size; i++) {
	         for(int j = 0; j < size; j++) {
	             for(int k = 0; k < size; k++) {
	                 result[i][j] += matrixOne[i][k] * matrixTwo[k][j];
	             }
	         }
	     }
	     return result;

	}
}
