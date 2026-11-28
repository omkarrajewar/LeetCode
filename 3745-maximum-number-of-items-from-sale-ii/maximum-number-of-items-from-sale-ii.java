import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Count factor frequencies
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count item types whose factors are divisible by f
        int[] divCount = new int[n + 1];

        for (int f = 1; f <= n; f++) {
            for (int x = f; x <= n; x += f) {
                divCount[f] += freq[x];
            }
        }

        // Bonus purchase groups: (price, number of bonus slots)
        List<long[]> groups = new ArrayList<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            int bonus = divCount[factor] - 1;

            // Only bonus purchases cheaper than 2 * minPrice
            if (bonus > 0 && price < 2L * minPrice) {
                groups.add(new long[]{price, bonus});
            }
        }

        // Sort bonus purchases by price
        groups.sort(Comparator.comparingLong(a -> a[0]));

        long remaining = budget;
        long bonusTaken = 0;

        // Buy normal items only
        long answer = budget / minPrice;

        for (long[] group : groups) {
            long price = group[0];
            long count = group[1];

            long take = Math.min(count, remaining / price);

            if (take == 0) {
                break;
            }

            remaining -= take * price;
            bonusTaken += take;

            long total = 2 * bonusTaken + remaining / minPrice;
            answer = Math.max(answer, total);

            if (take < count) {
                break;
            }
        }

        return (int) answer;
    }
}