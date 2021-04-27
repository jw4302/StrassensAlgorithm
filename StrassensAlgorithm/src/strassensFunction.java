import com.google.common.base.Stopwatch;

public class strassensFunction {

	public int [][] bruteForce(int [][] A, int [][] B) {
		// c = a*b = 0(c2)10^2 + (c1)10^1 + (c0)
		// c2 = a1 * b1 product of their first digits
		// c0 = a0 * b0 is the product of their second digits,
		// c1 = (a1 + a0) * (b1 + b0) - (c2 + c0) product of the sum of a digits
		// and the sum of bs difits minus the sum of c2 and c0. 
	}
	
	public int[][] simpleStrassen( int [][] A, int [][] B) {
		
		
	}
	
	public void mixedBruteStrassen() {
		
	}
	
	
	//this can be as small or as big as you need it to be
	//you just need to show that there is a difference and you can record it
	public void strassenTimed() {
	//
		Stopwatch timer = Stopwatch.createUnstarted();
		//put algorithm here
		//call to simple Strassen();
		
		LOG.info("Method toook:  " = timer.stop());

	}
}
