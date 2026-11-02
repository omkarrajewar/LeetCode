
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // Step 1: XOR all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find the rightmost set bit
        int bit = xor & -xor;

        int a = 0;
        int b = 0;

        // Step 3: Divide numbers into two groups
        for (int num : nums) {
            if ((num & bit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
