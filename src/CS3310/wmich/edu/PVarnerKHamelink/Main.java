package CS3310.wmich.edu.PVarnerKHamelink;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws IOException{
		
		MergeSort sort = new MergeSort();
		sort.sortFile("hw5SampleData.dat");
		
	}
	
	

}
