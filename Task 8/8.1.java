import java.util.*;

public class CheapestFlight {
    static class Flight {
        int to, cost;
        Flight(int t, int c) {
            to = t;
            cost = c;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst) {
        Map<Integer, List<Flight>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], k -> new ArrayList<>()).add(new Flight(f[1], f[2]));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(src, 0);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int city = cur[0], cost = cur[1];
            if (city == dst) return cost;

            if (graph.containsKey(city)) {
                for (Flight f : graph.get(city)) {
                    int newCost = cost + f.cost;
                    if (newCost < dist.getOrDefault(f.to, Integer.MAX_VALUE)) {
                        dist.put(f.to, newCost);
                        pq.add(new int[]{f.to, newCost});
                    }
                }
            }
        }
        return -1; // <-- This must be outside the while loop
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500},
            {2, 3, 200},
            {3, 4, 100}
        };
        int src = 0, dst = 4;
        System.out.println("Cheapest Cost: " + findCheapestPrice(n, flights, src, dst));
    }
}
