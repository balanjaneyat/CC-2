import java.util.*;
public class KSmallestPairs {
 public static void main(String[] a){
 int[] n1={1,7,11}, n2={2,4,6}; int k=3;
 PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(x-
>n1[x[0]]+n2[x[1]]));
 for(int i=0;i<Math.min(k,n1.length);i++) pq.add(new int[]{i,0});
 List<List<Integer>> r=new ArrayList<>();
 while(k-->0&&!pq.isEmpty()){
 int[] p=pq.poll();
 r.add(Arrays.asList(n1[p[0]],n2[p[1]]));
 if(p[1]+1<n2.length) pq.add(new int[]{p[0],p[1]+1});
 }
 System.out.println(r);
 }
}
