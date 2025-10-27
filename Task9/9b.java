public class RegexMatching {
 static boolean match(String s,String p,int i,int j){
 if(j==p.length()) return i==s.length();
 boolean f=i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
 if(j+1<p.length()&&p.charAt(j+1)=='*')
 return match(s,p,i,j+2)||(f&&match(s,p,i+1,j));
 else return f&&match(s,p,i+1,j+1);
 }
 public static void main(String[] a){
 System.out.println(match("aa","a*",0,0));
 System.out.println(match("mississippi","mis*is*p*.",0,0));
 System.out.println(match("ab",".*",0,0));
 System.out.println(match("aab","c*a*b",0,0));
 }
}
