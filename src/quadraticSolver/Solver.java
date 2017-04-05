package quadraticSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Reader {
	/**
	 * Class for reading file as stdin and creating Double array
	 */

	int i = 0;
	String data;
	String [] values;
	Double [][] numvalues;
	//Double numdata;

	public Reader(String FILENAME) throws FileNotFoundException {

		File file = new File(FILENAME);
		Scanner inputStreamArray = new Scanner(file);
		while (inputStreamArray.hasNextLine()) { //defining number of lines in source file 
			inputStreamArray.nextLine();
			i++;
		}
		inputStreamArray.close();
		Scanner inputStream = new Scanner(file);
		while (inputStream.hasNextLine()) {

			numvalues = new Double[i][3]; 
			for (int l = 0; l < i; l++) { //populating two dimensional Double array
				data = inputStream.nextLine();
				values = (data.split(" "));
				for (int k = 0; k < 3; k++) {
					numvalues [l][k] = Double.parseDouble(values[k]);//converting parsed string values to Double	
				}		
			}
		}
		inputStream.close();
	}

	public Double[][] getValues() {// method for getting two-dimensional array 
		return this.numvalues;
	}

	public String toString() {//overriding to String method for printing two dimensional array. For debugging purposes.
		String name = "";
		for ( int n = 0; n < numvalues.length; n++) {
			for (int k = 0; k < numvalues[n].length; k++) { 
				name += " " + numvalues[n][k];
			} 
		}
		return name.toString();		
	}
}

class QaSolver {
	/**
	 * class containing method for solving quadratic equattion
	 */
	Double rootFirst, rootSecond, Dicmnt, a, b, c;

	public Double[] qaSolver(Double a, Double b, Double c) {
		Dicmnt = b * b - 4 * a * c;

		if (Dicmnt > 0) {// discriminant is greater than zero ==> two roots of quadratic equation
			rootFirst = ( - b + Math.sqrt(Dicmnt))/(2*a);
			rootFirst  = (double)Math.round(rootFirst * 10) / 10;
			rootSecond = (- b - Math.sqrt(Dicmnt))/(2*a);
			rootSecond = (double)Math.round(rootSecond * 10) / 10;
			Double[] array = {rootFirst, rootSecond};
			return array;
		}
		else if (Dicmnt == 0) {//discriminant is equals zero ==> one roots of quadratic equation
			rootFirst = (- b + Math.sqrt(Dicmnt))/(2*a);
			rootFirst  = (double)Math.round(rootFirst * 10) / 10;
			Double[] array = {rootFirst};
			return array;
		}		
		else {//discriminant is less than zero ==> no real roots of quadratic equation
			rootFirst = null;
		}
		return null;
	}	
}
public class Solver {
	/**
	 * Class with main method for objects instantiation, functions calls and script output
	 * @param args
	 * @throws FileNotFoundException
	 */

	public static void main(String[] args) throws FileNotFoundException {
		final String FILENAME = "resources/input.txt";
		Reader parser = new Reader(FILENAME); //instantiation of object of class Reader which contains Double array

		Double [][] dataSet = parser.getValues();//passing Double array from object to local array

		for (int l = 0; l < dataSet.length; l++) {
			QaSolver dataCoef = new QaSolver();////instantiation of object of class QaSolver which handles math
			//Output of initial coefficients with corresponding roots of equation. Also with math function call.
			System.out.println("input: "+Arrays.toString(dataSet[l])+" ==> "+"output: "+(Arrays.toString(dataCoef.qaSolver(dataSet[l][0], dataSet[l][1], dataSet[l][2]))));
		}		
	}
}
