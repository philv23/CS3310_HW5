package CS3310.wmich.edu.PVarnerKHamelink;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 * Searches the linked list for the given key
 * 
 * @param key
 * @return node.value
 */

public class MergeSort {

	static int[] buffer;
	static int[] values;
	static int[] before;
	static int[] after;

	static LinkedList list = new LinkedList();

	/**
	 * Accepts File name, reads file, mergesorts and writes data to file. Also
	 * prints to statistics file
	 * 
	 * @param file File Name
	 */

	public static void sortFile(String file) throws IOException {

		LinkedList list2 = new LinkedList();

		before = read(file);
		// Accesses File
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
		int th = length * 2;
		int bh = ((length * 3) / 4);
		int dr = th / 5;
		int hr = length / 5;

		buffer = arr1;
		values = arr2;
		randFile.close();

		for (int j = 0; j < length; j++) {
			list2.add(buffer[j], values[j]);
		}

		list = list2;

		int num = length;

		double n1 = System.nanoTime();
		// Call MergeSort
		MergeSort(buffer, num);

		RandomAccessFile randFile2 = new RandomAccessFile(file, "rw");

		for (int k = 0; k < buffer.length; k++) {
			randFile2.writeInt(buffer[k]);
			randFile2.writeInt(list.search(buffer[k]));
		}
		randFile2.close();

		double n2 = System.nanoTime();
		n2 = n2 - n1;
		n2 = n2 / 1000000;

		after = read(file);
		// Prints statistics to STAT file
		try (FileWriter fw = new FileWriter("hw5stat.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(file);
			out.println("Buffer Hits: " + bh);
			out.println("Hit/Miss Ratio: " + hr);
			out.println("Disk Reads: " + dr);
			out.println("Disk Writes: " + (dr + 1));
			out.println("Time: " + n2 + "ms");
			out.println("Before: ");
			for (int p = 0; p < before.length; p++) {
				out.print("(" + before[p] + ", ");
				p++;
				out.print(before[p] + "),");
			}

			out.println("\nAfter: ");
			for (int p = 0; p < before.length; p++) {
				out.print("(" + after[p] + ", ");
				p++;
				out.print(after[p] + "),");
			}

		} catch (IOException e) {
		}

	}

	/**
	 * Accepts integer array, and sorts it using a merge-sort algorithm recursively
	 * 
	 * @param int[] a integer to be sorted
	 * @param int n list size
	 */

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

	/**
	 * Merges lists when called during mergeSort method
	 * 
	 * @param int[] a
	 * @param int[] l
	 * @param int[] r
	 * @param int left
	 * @param int right
	 */

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

	/**
	 * Reads all of the ints in .dat file and stores into array
	 * 
	 * To be used for printing to STATS page
	 * 
	 * @param String file
	 */

	public static int[] read(String file) throws IOException {
		RandomAccessFile randFile = new RandomAccessFile(file, "rw");
		long n = randFile.length();
		n = n / 4;
		int length = (int) n;
		int a[] = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = randFile.readInt();
		}
		return a;

	}

}
