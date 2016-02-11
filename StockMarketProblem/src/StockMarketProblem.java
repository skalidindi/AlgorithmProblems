import java.util.Arrays;

public class StockMarketProblem {
	public static void main(String[] args) {
		int[] ary = new int[4];
		ary[0] = 15;
		ary[1] = 2;
		ary[2] = 10;
		ary[3] = 23;
//		ary[4] = 1;
//		ary[5] = 5;
//		ary[6] = 8;
//		ary[7] = 20;
//		ary[8] = 100;
//		ary[9] = 0;
		
		int maxProfit = maxProfitMerge(ary);
		System.out.println(maxProfit);
	}
	
	public static int maxProfitBrute(int []array) {
		int max_profit = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				max_profit = Integer.max(max_profit, array[j] - array[i]);
			}
		}
		
		return max_profit;
	}
	
	public static int maxProfitMerge(int []array) {
		if (array.length == 0) {
			return 0;
		}
		
		if (array.length == 1) {
			return Integer.max(array[0], 0);
		}
		
		int half = array.length / 2;
		int left_stocks = maxProfitMerge(Arrays.copyOfRange(array, 0, half));
		int right_stocks = maxProfitMerge(Arrays.copyOfRange(array, half, array.length));
		int left_min = array[0];
		for (int i = 0; i < half; i++) {
			left_min = Integer.min(left_min, array[i]);
		}
		
		int right_max = array[half];
		for (int i = half; i < array.length; i++) {
			right_max = Integer.max(right_max, array[i]);
		}
		
		int mid_stocks = right_max - left_min;
				
		
		return Integer.max(left_stocks,  Integer.max(right_stocks, mid_stocks));
	}
	
	public static int maxProfitDP(int []array) {
		int[] deltas = new int[array.length];
		
		deltas[0] = 0;
		for (int i = 1; i < array.length; i++) {
			deltas[i] = array[i] - array[i-1];
		}
		
		return maximalSubarrayDP(deltas);
	}
	
	public static int maximalSubarrayDP(int []array) {
		int[] subProblems = new int[array.length];
		
		subProblems[0] = Integer.max(array[0], 0);
		for (int i = 1; i < array.length; i++) {
			subProblems[i] = Integer.max(subProblems[i - 1] + array[i], 0);
		}
		
		int max = 0;
		for (int i = 0 ; i < array.length; i++) {
			max = Integer.max(max, subProblems[i]);
		}
		
		return max;
	}
}
