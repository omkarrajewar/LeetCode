import java.util.*;

class Solution {

    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        // Step 1: Copy array
        int[] sorted = score.clone();

        // Step 2: Sort
        Arrays.sort(sorted);

        // Step 3: Store rank of each score
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {

            int rank = n - i;
            int currentScore = sorted[i];

            if (rank == 1) {
                map.put(currentScore, "Gold Medal");
            }
            else if (rank == 2) {
                map.put(currentScore, "Silver Medal");
            }
            else if (rank == 3) {
                map.put(currentScore, "Bronze Medal");
            }
            else {
                map.put(currentScore, String.valueOf(rank));
            }
        }

        // Step 4: Create answer in original order
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = map.get(score[i]);
        }

        return answer;
    }
}