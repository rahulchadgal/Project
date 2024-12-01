package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrainPlatform {

	static int findPlatform(int arr[], int dep[]) {

		int n =  arr.length;
		Arrays.sort(arr);
		Arrays.sort(dep);
		int count = 1;
		int platform = 1;
		int  i= 1 , j =0;
		while ( i< n && j<n) {
			if(arr[i] <= dep[j]) {
				platform++;
				i++;
			}else if(arr[i] > dep[j]) {
				platform--;
				j++;
			}
			
			if(count < platform) {
				count = platform;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

		System.out.println(findPlatform(arr, dep));
	}

}
