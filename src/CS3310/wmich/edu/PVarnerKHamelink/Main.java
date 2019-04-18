package CS3310.wmich.edu.PVarnerKHamelink;

import java.io.IOException;

public class Main {

	/**
	 * Calls MergeSort on binary File
	 * 
	 * @param String[] args
	 */

	public static void main(String[] args) throws IOException {

		MergeSort sort = new MergeSort();
		// sort.sortFile("hw5SampleData.dat");
		sort.sortFile("hw5LargeData.dat");

		System.out.println("Done");

	}

}
