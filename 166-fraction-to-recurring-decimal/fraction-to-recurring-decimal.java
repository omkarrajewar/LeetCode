
import java.util.*;

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        // Check negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        // Convert to long to avoid integer overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Calculate integer part
        sb.append(num / den);

        long remainder = num % den;

        // If no fractional part
        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");

        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {

            // Check whether remainder already exists
            if (map.containsKey(remainder)) {

                int position = map.get(remainder);

                sb.insert(position, "(");
                sb.append(")");

                break;
            }

            // Store remainder and current position
            map.put(remainder, sb.length());

            remainder *= 10;

            // Append next decimal digit
            sb.append(remainder / den);

            remainder %= den;
        }

        return sb.toString();
    }
}
