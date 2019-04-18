package CS3310.wmich.edu.PVarnerKHamelink;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws IOException {
		RandomAccessFile randFile = new RandomAccessFile("hw5SampleData.dat", "rw");
		long n = randFile.length();
		n = n / 4;
		for(int i = 0; i < n; i++) {
			int num = randFile.readInt();
			System.out.println(num);
		}
		
		randFile.close();
		
		
	}

}
