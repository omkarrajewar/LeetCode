class Solution {

    public int maxAscendingSum(int[] nums) {

        int maxSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int sum = nums[i];
            maxSum = Math.max(maxSum, sum);

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] > nums[j - 1]) {
                    sum += nums[j];
                    maxSum = Math.max(maxSum, sum);
                } else {
                    break;
                }
            }
        }

        return maxSum;
    }
}