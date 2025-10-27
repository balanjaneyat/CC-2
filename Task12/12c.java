public class WaterBottleExchange {
 public static int numWaterBottles(int numBottles, int exchange) {
 int total = numBottles;
 int empty = numBottles;
 while (empty >= exchange) {
 int newBottles = empty / exchange;
 total += newBottles;
 empty = newBottles + (empty % exchange);
 }
 return total;
 }
 public static void main(String[] args) {
 int numBottles = 9;
 int exchange = 3;
 System.out.println("Total Bottles Drunk: " + numWaterBottles(numBottles,
exchange));
 }
}
