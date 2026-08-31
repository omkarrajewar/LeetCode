import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of p
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            windowFreq[s.charAt(right) - 'a']++;

            // Window size greater than p
            if (right - left + 1 > p.length()) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            // Window size == p length
            if (right - left + 1 == p.length()) {

                if (Arrays.equals(pFreq, windowFreq)) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}