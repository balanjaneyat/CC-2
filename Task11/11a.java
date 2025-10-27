import java.util.*;
public class LongestPalindromicSubstring {
 static Boolean[][] memo;
 static boolean isPalindrome(String s, int l, int r) {
 if (l >= r) return true;
 if (memo[l][r] != null) return memo[l][r];
 if (s.charAt(l) == s.charAt(r))
 return memo[l][r] = isPalindrome(s, l + 1, r - 1);
 return memo[l][r] = false;
 }
 public static String longestPalindrome(String s) {
 int n = s.length();
 memo = new Boolean[n][n];
 int start = 0, maxLen = 1;
 for (int i = 0; i < n; i++) {
 for (int j = i; j < n; j++) {
 if (isPalindrome(s, i, j) && (j - i + 1) > maxLen) {
 start = i;
 maxLen = j - i + 1;
 }
 }
 }
 return s.substring(start, start + maxLen);
 }
 public static void main(String[] args) {
 String s = "babad";
 System.out.println("Longest Palindromic Substring: " + longestPalindrome(s));
 }
}
