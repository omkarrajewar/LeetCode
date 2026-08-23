import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Max heap: [character, frequency]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] previous = null;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            // Use current character
            result.append((char) (current[0] + 'a'));
            current[1]--;

            // Put previous character back into heap
            if (previous != null && previous[1] > 0) {
                pq.offer(previous);
            }

            // Current becomes previous
            previous = current;
        }

        // If not all characters were used
        if (result.length() != s.length()) {
            return "";
        }

        return result.toString();
    }
}