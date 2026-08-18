import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int player = 0;
        int trainer = 0;
        int count = 0;

        while (player < players.length && trainer < trainers.length) {

            if (players[player] <= trainers[trainer]) {
                // Match found
                count++;

                player++;
                trainer++;
            } else {
                // Trainer is too weak
                trainer++;
            }
        }

        return count;
    }
}