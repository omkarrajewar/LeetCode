import java.util.*;

class Solution {
    public String longestNiceSubstring(String s) {

        if (s.length() < 2) {
            return "";
        }

        Set<Character> set = new HashSet<>();

        // Store all characters
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        // Find a character whose opposite case is missing
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (set.contains(Character.toLowerCase(ch)) &&
                set.contains(Character.toUpperCase(ch))) {
                continue;
            }

            // ch cannot be part of a nice substring
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));

            // If same length, left comes earlier
            return left.length() >= right.length() ? left : right;
        }

        // Entire string is nice
        return s;
    }
}