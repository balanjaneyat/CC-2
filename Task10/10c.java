import java.util.*;
public class KClosestPoints {
 public static void main(String[] a){
 int[][] p={{3,3},{5,-1},{-2,4}}; int k=2;
 PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->(y[0]*y[0]+y[1]*y[1])-
(x[0]*x[0]+x[1]*x[1]));
 for(int[] pt:p){ pq.add(pt); if(pq.size()>k) pq.poll(); }
 int[][] r=new int[k][2];
 for(int i=0;i<k;i++) r[i]=pq.poll();
 for(int[] x:r) System.out.println(Arrays.toString(x));
 }
}
