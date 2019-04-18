package CS3310.wmich.edu.PVarnerKHamelink;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile randFile = new RandomAccessFile("hw5SampleData.dat", "rw");
		long n = randFile.length();
		n = n / 4;
		int length = (int) n;
		int[] arr = new int[length];
		for(int i = 0; i < length; i++) {
			arr[i] = randFile.readInt();
			System.out.println(arr[i]);
		}
		
		System.out.println("------------------------------");
		
		MergeSort.MergeSort(arr, length);
		
		for(int i = 0; i < length; i++) {
			System.out.println(arr[i]);
		}
				
		randFile.close();
	}

}
