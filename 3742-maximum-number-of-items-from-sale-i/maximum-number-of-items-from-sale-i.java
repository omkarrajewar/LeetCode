import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Calculate free-copy bonus for every item type
        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    bonus[i]++;
                }
            }
        }

        // Sort items by price in descending order
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) ->
            Integer.compare(items[b][1], items[a][1])
        );

        // dpHigher[c] = maximum activation reward
        // using items strictly more expensive than current price
        int[] dpHigher = new int[budget + 1];
        Arrays.fill(dpHigher, -1);

        dpHigher[0] = 0;

        int answer = 0;
        int idx = 0;

        while (idx < n) {
            int price = items[order[idx]][1];
            int end = idx;

            // Find all items with this price
            while (end < n && items[order[end]][1] == price) {
                end++;
            }

            // DP for activation subsets containing
            // at least one item of the current price
            int[] dpOne = new int[budget + 1];
            Arrays.fill(dpOne, -1);

            // Process items in the current price group
            for (int k = idx; k < end; k++) {
                int itemIndex = order[k];
                int reward = bonus[itemIndex] + 1;

                // Descending iteration ensures 0/1 selection
                for (int c = budget - price; c >= 0; c--) {
                    if (dpHigher[c] != -1) {
                        dpOne[c + price] = Math.max(
                            dpOne[c + price],
                            dpHigher[c] + reward
                        );
                    }

                    if (dpOne[c] != -1) {
                        dpOne[c + price] = Math.max(
                            dpOne[c + price],
                            dpOne[c] + reward
                        );
                    }
                }
            }

            // Evaluate subsets whose minimum activated
            // item price is exactly the current price
            for (int c = price; c <= budget; c++) {
                if (dpOne[c] != -1) {
                    int total = dpOne[c] + (budget - c) / price;
                    answer = Math.max(answer, total);
                }
            }

            // Add current price group to dpHigher
            // for the next lower price group
            for (int k = idx; k < end; k++) {
                int itemIndex = order[k];
                int reward = bonus[itemIndex] + 1;

                for (int c = budget - price; c >= 0; c--) {
                    if (dpHigher[c] != -1) {
                        dpHigher[c + price] = Math.max(
                            dpHigher[c + price],
                            dpHigher[c] + reward
                        );
                    }
                }
            }

            idx = end;
        }

        return answer;
    }
}