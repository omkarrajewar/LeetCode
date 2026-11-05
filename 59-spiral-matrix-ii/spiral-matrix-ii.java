
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int num = 1;

        while (num <= n * n) {

            // Move right
            for (int i = left; i <= right && num <= n * n; i++) {
                ans[top][i] = num++;
            }
            top++;

            // Move down
            for (int i = top; i <= bottom && num <= n * n; i++) {
                ans[i][right] = num++;
            }
            right--;

            // Move left
            for (int i = right; i >= left && num <= n * n; i--) {
                ans[bottom][i] = num++;
            }
            bottom--;

            // Move up
            for (int i = bottom; i >= top && num <= n * n; i--) {
                ans[i][left] = num++;
            }
            left++;
        }

        return ans;
    }
}
