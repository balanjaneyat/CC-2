import java.util.*;
public class SequentialDigits {
 static void gen(int d,int n,int l,int h,List<Integer> r){
 if(n>=l&&n<=h) r.add(n);
 if(n>h||d>9) return;
 gen(d+1,n*10+d,l,h,r);
 }
 public static void main(String[] a){
 List<Integer> r=new ArrayList<>();
 for(int i=1;i<=9;i++) gen(i,0,100,300,r);
 Collections.sort(r);
 System.out.println(r);
 }
}
