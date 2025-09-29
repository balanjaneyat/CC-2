import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int idx = 0;

        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                counts.push(count);
            } else if (s.charAt(idx) == '[') {
                result.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                String temp = result.pop();
                int repeat = counts.pop();
                StringBuilder sb = new StringBuilder(temp);
                for (int i = 0; i < repeat; i++) sb.append(res);
                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String encoded = "3[a2[c]]";
        System.out.println("Decoded String: " + decodeString(encoded));
    }
}
