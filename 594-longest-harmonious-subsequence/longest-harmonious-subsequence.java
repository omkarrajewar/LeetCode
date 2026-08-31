import java.util.*;

class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of every number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Check every number
        for (int num : map.keySet()) {

            if (map.containsKey(num + 1)) {

                int length = map.get(num) + map.get(num + 1);

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}