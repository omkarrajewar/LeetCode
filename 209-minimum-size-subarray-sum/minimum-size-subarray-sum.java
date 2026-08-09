class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        // Create prefix sum array
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;

        // Try every starting position
        for (int i = 0; i < n; i++) {

            int required = prefix[i] + target;

            // Binary search for first prefix[j] >= required
            int left = i + 1;
            int right = n;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] >= required) {
                    minLen = Math.min(minLen, mid - i);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}