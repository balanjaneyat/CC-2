import java.util.*;
public class MinCostTickets {
 static int[] days, costs, memo;
 static int minCost(int i) {
 if (i >= days.length) return 0;
 if (memo[i] != -1) return memo[i];
 int cost1 = costs[0] + minCost(nextDay(i, 1));
 int cost7 = costs[1] + minCost(nextDay(i, 7));
 int cost30 = costs[2] + minCost(nextDay(i, 30));
 return memo[i] = Math.min(cost1, Math.min(cost7, cost30));
 }
 static int nextDay(int i, int duration) {
 int j = i;
 while (j < days.length && days[j] < days[i] + duration) j++;
 return j;
 }
 public static int mincostTickets(int[] d, int[] c) {
 days = d;
 costs = c;
 memo = new int[d.length];
 Arrays.fill(memo, -1);
 return minCost(0);
 }
 public static void main(String[] args) {
 int[] days = {1, 4, 6, 7, 8, 20};
 int[] costs = {2, 7, 15};
 System.out.println("Minimum Cost for Travel: " + mincostTickets(days, costs));
 }
}
