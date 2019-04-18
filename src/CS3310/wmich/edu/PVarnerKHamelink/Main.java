package CS3310.wmich.edu.PVarnerKHamelink;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws IOException{
		
		MergeSort sort = new MergeSort();
		sort.sortFile("hw5SampleData.dat");
		
		readFile("hw5SampleData#2.dat");
		
	}
	
	public static void readFile(String file) throws IOException {
		
		RandomAccessFile randFile = new RandomAccessFile(file, "rw");
		long n = randFile.length();
		n = n / 4;
		
		for(int i = 0; i < n; i++) {
			System.out.println(randFile.readInt());
		}
	}

}
