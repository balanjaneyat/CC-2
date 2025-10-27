import java.util.*;
public class LetterCombinations {
 static Map<Character,String> m=Map.of(
 '2',"abc",'3',"def",'4',"ghi",'5',"jkl",
 '6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz"
 );
 static void backtrack(List<String> r,StringBuilder c,String s,int i){
 if(i==s.length()){ r.add(c.toString()); return; }
 for(char ch:m.get(s.charAt(i)).toCharArray()){
 c.append(ch); backtrack(r,c,s,i+1); c.deleteCharAt(c.length()-1);
 }
 }
 public static void main(String[] a){
 String s="23"; List<String> r=new ArrayList<>();
 backtrack(r,new StringBuilder(),s,0);
 System.out.println(r);
 }
}
