
class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        long moves = 0;

        // Find maximum element
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Calculate required increments
        for (int num : nums) {
            moves += (long) max - num;
        }

        return (int) moves;
    }
}
