class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        // Find middle element
        int mid = left + (right - left) / 2;

        // Create root
        TreeNode root = new TreeNode(nums[mid]);

        // Create left subtree
        root.left = createBST(nums, left, mid - 1);

        // Create right subtree
        root.right = createBST(nums, mid + 1, right);

        return root;
    }
}