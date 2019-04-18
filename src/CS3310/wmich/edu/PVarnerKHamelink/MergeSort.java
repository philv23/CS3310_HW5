package CS3310.wmich.edu.PVarnerKHamelink;

public class MergeSort {
	
	public static void MergeSort(int [] a, int n) 
	{
		if (n<2)
		{
			return;
		}
		
		
		
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for (int i = 0; i < mid; i++) 
		{
			left[i] = a[i];
		}
		
		for (int i = mid; i < n; i++)
		{
			right[i - mid] = a[i];
		}
		
		MergeSort(left, mid);
		MergeSort(right, n-mid);
		
		Merge(a, left, right, mid, n - mid);		
		
	}
	
	private static void Merge(int[] a, int[] l, int[] r, int left, int right)
	{
		int i = 0; int j = 0; int k = 0;
		while (i < left && j < right)
		{
			if (l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		while (i < left)
		{
			a[k++] = l[i++];
		}
		while (j < right)
		{
			a[k++] = r[j++];
		}
	}

}
