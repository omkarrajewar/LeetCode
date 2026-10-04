import java.util.*;

class Solution {
    public int countPairs(List<Integer> nums, int target) {

        Collections.sort(nums);

        int count = 0;
        int n = nums.size();

        for (int i = 0; i < n - 1; i++) {

            int low = i + 1;
            int high = n - 1;
            int pos = n;

            // Find first index where:
            // nums[i] + nums[mid] >= target
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (nums.get(i) + nums.get(mid) >= target) {
                    pos = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // All elements from i+1 to pos-1 are valid
            count += pos - i - 1;
        }

        return count;
    }
}