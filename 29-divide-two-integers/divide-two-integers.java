class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE &&
            divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and make positive
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        while (a >= b) {

            long value = b;
            long multiple = 1;

            // Find the largest doubled divisor
            while (a >= (value << 1)) {
                value = value << 1;
                multiple = multiple << 1;
            }

            // Subtract it
            a = a - value;

            // Add corresponding multiple
            quotient = quotient + multiple;
        }

        // Apply sign
        if (negative) {
            quotient = -quotient;
        }

        // 32-bit range handling
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}