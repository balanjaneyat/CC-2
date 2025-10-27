public class MinTapsToWaterGarden {
 public static int minTaps(int n, int[] ranges) {
 int[] maxReach = new int[n + 1];
 for (int i = 0; i <= n; i++) {
 int left = Math.max(0, i - ranges[i]);
 int right = Math.min(n, i + ranges[i]);
 maxReach[left] = Math.max(maxReach[left], right);
 }
 int taps = 0, end = 0, farthest = 0;
 for (int i = 0; i <= n; i++) {
 if (i > farthest) return -1;
 farthest = Math.max(farthest, maxReach[i]);
 if (i == end) {
 taps++;
 end = farthest;
 }
 }
 return taps;
 }
 public static void main(String[] args) {
 int n = 5;
 int[] ranges = {3, 4, 1, 1, 0, 0};
 System.out.println("Minimum Taps Required: " + minTaps(n, ranges));
 }
}
