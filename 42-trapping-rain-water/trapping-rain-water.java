import java.util.Stack;

class Solution {
    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() &&
                   height[i] > height[stack.peek()]) {

                int bottom = stack.pop();

                // No left boundary
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();

                // Width between left and right boundary
                int width = i - left - 1;

                // Height of water
                int waterHeight =
                        Math.min(height[left], height[i])
                        - height[bottom];

                water += width * waterHeight;
            }

            stack.push(i);
        }

        return water;
    }
}