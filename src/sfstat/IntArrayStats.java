package sfstat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IntArrayStats {
	
	public static double mean (int [] a) {
		int total = 0;
		for (int ii=0;ii<a.length;ii++) {
			total += a[ii];
		}
		return (total / (double) a.length);
	}
	
	public static double median(int[] a) {
		int[] vals = a.clone();
		Arrays.sort(vals);
		double ret = 0;

		if (vals.length % 2 != 0) {
			ret = (double) vals[vals.length / 2];
		}
		else {
			ret = (vals[vals.length / 2] + vals[(vals.length / 2) + 1]) / 2.0;
		}
		
		return ret;
	}
	
	public static int mode(int[] a) {
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		int mode = 0;
		
		for (int ii=0;ii<a.length;ii++) {
			if (counts.containsKey(a[ii])) {
				Integer newCount = counts.get(a[ii]) + 1;
				counts.put(a[ii], newCount);
			}
			else {
				counts.put(a[ii], 1);
			}
		}
		
	    int maxCount = (Collections.max(counts.values()));
	    for (Map.Entry<Integer,Integer> countEntry : counts.entrySet()) {
	    	if (countEntry.getValue() == maxCount) {
	    		mode = countEntry.getKey();
	    	}
	    }
		
		return mode;
	}
		
	
	// unimplemented.
	public static void getClusters(int[] a) {
		
		int[] b = a.clone();
		Arrays.sort(b);
		
		System.out.print("Sorted: ");
		for(int ii=1;ii<b.length;ii++) {
				System.out.print(" " + b[ii]);
		}
		System.out.println();
		
		int[] diffs = new int[b.length-1];
		
		for(int ii=0;ii<b.length-1;ii++) {
			diffs[ii] = b[ii+1] - b[ii];
		}
		
		Arrays.sort(diffs);
		
		// print uniques
		System.out.print("Gap sizes: ");
		System.out.print(diffs[0]);
		for(int ii=1;ii<diffs.length;ii++) {
		   if(diffs[ii] != diffs[ii-1]) {
				System.out.print(" " + diffs[ii]);
		   }
		}
	
	}
	
	public static  void printArray(int[] a) {
	
		System.out.print("[ ");
		for (int ii=0;ii<a.length;ii++ ) {
			System.out.print(a[ii] + " ");
		}
		System.out.print("]");

	}
}
