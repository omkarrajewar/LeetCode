import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            // Count characters
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Create unique key
            StringBuilder key = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                key.append('#');
                key.append(count[i]);
            }

            // Add string to its group
            map.computeIfAbsent(key.toString(),
                    k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
