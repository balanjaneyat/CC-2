import java.util.*;
public class MaxSubarraySum {
 static Integer[] memo;
 static int[] arr;
 static int maxSubArray(int i) {
 if (i == 0) return arr[0];
 if (memo[i] != null) return memo[i];
 memo[i] = Math.max(arr[i], arr[i] + maxSubArray(i - 1));
 return memo[i];
 }
 public static int findMaxSum(int[] nums) {
 arr = nums;
 memo = new Integer[nums.length];
 int maxSum = nums[0];
 for (int i = 0; i < nums.length; i++)
 maxSum = Math.max(maxSum, maxSubArray(i));
 return maxSum;
 }
 public static void main(String[] args) {
 int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
 System.out.println("Maximum Subarray Sum: " + findMaxSum(nums));
 }
}
