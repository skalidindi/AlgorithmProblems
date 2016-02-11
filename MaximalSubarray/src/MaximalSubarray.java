
public class MaximalSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = new int[10];
		ary[0] = 15;
		ary[1] = 0;
		ary[2] = 10;
		ary[3] = 23;
		ary[4] = -1;
		ary[5] = 5;
		ary[6] = 8;
		ary[7] = -20;
		ary[8] = 11;
		ary[9] = -1;
		
		int maxSum = maximalSubarrayDP(ary);
		System.out.println("Max sum: " + maxSum);
	}
	
	public static int maximalSubarrayBrute(int []array) {
		int max_sum = 0;
		
		for (int start = 0 ; start < array.length; start++) {
			for (int end = start; end < array.length; end++) {
				int sum = 0;
				for (int i = start; i <= end; i++) {
					sum += array[i];
				}
				max_sum = Integer.max(max_sum, sum);
			}
		}
		
		return max_sum;
	}
	
	public static int maximalSubarrayDP(int []array) {
		int[] subProblems = new int[array.length];
		
		subProblems[0] = Integer.max(array[0], 0);
		for (int i = 1; i < array.length; i++) {
			subProblems[i] = Integer.max(subProblems[i - 1] + array[i], 0);
		}
		
		for (int i = 0 ; i < array.length; i++) {
			System.out.println(subProblems[i]);
		}
		
		int max = 0;
		for (int i = 0 ; i < array.length; i++) {
			max = Integer.max(max, subProblems[i]);
		}
		
		return max;
	}

}
