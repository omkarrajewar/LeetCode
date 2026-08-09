import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 occurs before the array starts
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int remainder = sum % k;

            if (map.containsKey(remainder)) {

                int previousIndex = map.get(remainder);

                // Subarray length must be at least 2
                if (i - previousIndex >= 2) {
                    return true;
                }

            } else {
                // Store only the first occurrence
                map.put(remainder, i);
            }
        }

        return false;
    }
}