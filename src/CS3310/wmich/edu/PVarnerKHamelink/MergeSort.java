package CS3310.wmich.edu.PVarnerKHamelink;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MergeSort {

	static int[] buffer;
	static int[] values;

	static LinkedList list = new LinkedList();

	public static void sortFile(String file) throws IOException {
		LinkedList list2 = new LinkedList();

		RandomAccessFile randFile = new RandomAccessFile(file, "rw");
		long n = randFile.length();
		n = n / 8;
		int length = (int) n;
		int[] arr1 = new int[length];
		int[] arr2 = new int[length];
		for (int i = 0; i < length; i++) {
			arr1[i] = randFile.readInt();
			arr2[i] = randFile.readInt();
		}

		buffer = arr1;
		values = arr2;
		randFile.close();

		for (int j = 0; j < length; j++) {
			list2.add(buffer[j], values[j]);
		}

		list = list2;

		/*
		 * for(int i = 0; i < length; i++) { System.out.println(buffer[i]);
		 * System.out.println(values[i]); }
		 */

		int num = length / 2;
		MergeSort(buffer, num);
		
		String file2 = "hw5SampleData#2.dat";
		RandomAccessFile randFile2 = new RandomAccessFile(file2, "rw");
		
		for(int k = 0; k < buffer.length; k++) {
			randFile2.writeInt(buffer[k]);
			randFile2.writeInt(list.search(buffer[k]));
		}
		randFile2.close();

	}

	public static void MergeSort(int[] a, int n) {
		if (n < 2) {
			return;
		}

		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		for (int i = mid; i < n; i++) {
			right[i - mid] = a[i];
		}

		MergeSort(left, mid);
		MergeSort(right, n - mid);

		Merge(a, left, right, mid, n - mid);

	}

	private static void Merge(int[] a, int[] l, int[] r, int left, int right) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

}
