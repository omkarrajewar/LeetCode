
class Solution {
    public int findNthDigit(int n) {
        long digits = 1;
        long count = 9;
        long start = 1;

        // Find the group containing the nth digit
        while (n > digits * count) {
            n -= (int) (digits * count);
            digits++;
            count *= 10;
            start *= 10;
        }

        // Find the number containing the digit
        long number = start + (n - 1) / digits;

        // Find the position of the digit inside that number
        String s = String.valueOf(number);
        int index = (int) ((n - 1) % digits);

        return s.charAt(index) - '0';
    }
}
