package quadraticSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

class Reader {
	/**
	 * Class for reading file as stdin and creating Double array
	 */
	int i = 0;
	String data;
	String [] values;
	BigDecimal [][] numvalues;
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

			numvalues = new BigDecimal[i][3]; 
			for (int l = 0; l < i; l++) { //populating two dimensional Double array
				data = inputStream.nextLine();
				values = (data.split(" "));
				for (int k = 0; k < 3; k++) {
					//numvalues [l][k] = Double.valueOf(values[k]);
				numvalues [l][k] = new BigDecimal(values[k]);//converting parsed string values to Double	
				}		
			}
		}
		inputStream.close();
	}

	public BigDecimal[][] getValues() {// method for getting two-dimensional array 
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