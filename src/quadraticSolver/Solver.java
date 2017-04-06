package quadraticSolver;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;

public class Solver {
	/**
	 * Class with main method for objects instantiation, functions calls and script output
	 * @param args
	 * @throws FileNotFoundException
	 */

	public static void main(String[] args) throws FileNotFoundException {
		//final String FILENAME = "resources/input.txt";
		String FILENAME = args[0];
		Reader parser = new Reader(FILENAME); //instantiation of object of class Reader which contains Double array

		BigDecimal [][] dataSet = parser.getValues(); //passing Double array from object to local array

		for (int l = 0; l < dataSet.length; l++) {
			QaSolver dataCoef = new QaSolver();////instantiation of object of class QaSolver which handles math
			//Output of initial coefficients with corresponding roots of equation. Also with math function call.
			System.out.println("input: "+Arrays.toString(dataSet[l])+" ==> "+"output: "+(Arrays.toString(dataCoef.qaSolver(dataSet[l][0], dataSet[l][1], dataSet[l][2]))));


		}		
	}
}
