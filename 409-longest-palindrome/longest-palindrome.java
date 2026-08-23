class Solution {
    public int longestPalindrome(String s) {

        int[] count = new int[128];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int freq : count) {

            // Use the largest even portion
            length += (freq / 2) * 2;

            // An odd character can be used in the middle
            if (freq % 2 == 1) {
                hasOdd = true;
            }
        }

        // One odd character can be placed in the center
        if (hasOdd) {
            length++;
        }

        return length;
    }
}