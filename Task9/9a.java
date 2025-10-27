import java.util.*;
public class CheapestFlight {
 static int findCheapest(int n, int[][] flights, int src, int dst){
 Map<Integer,List<int[]>> g=new HashMap<>();
 for(int[] f:flights) g.computeIfAbsent(f[0],k->new ArrayList<>()).add(new
int[]{f[1],f[2]});
 int[] dist=new int[n]; Arrays.fill(dist,Integer.MAX_VALUE); dist[src]=0;
 PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
 pq.add(new int[]{src,0});
 while(!pq.isEmpty()){
 int[] cur=pq.poll();
 if(cur[0]==dst) return cur[1];
 if(cur[1]>dist[cur[0]]) continue;
 for(int[] e:g.getOrDefault(cur[0],new ArrayList<>())){
 int next=e[0], nd=cur[1]+e[1];
 if(nd<dist[next]){ dist[next]=nd; pq.add(new int[]{next,nd}); }
 }
 }
 return -1;
 }
 public static void main(String[] a){
 int[][] flights={{0,1,100},{1,2,100},{0,2,500}};
 int cost=findCheapest(3,flights,0,2);
 System.out.println("Cheapest cost from city 0 to 2 = "+cost);
 }
}
