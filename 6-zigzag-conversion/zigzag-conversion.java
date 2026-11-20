
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        // Initialize each row
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1;

        // Traverse each character
        for (int i = 0; i < s.length(); i++) {

            rows[currentRow].append(s.charAt(i));

            // Change direction at top or bottom
            if (currentRow == 0) {
                direction = 1;
            }
            else if (currentRow == numRows - 1) {
                direction = -1;
            }

            currentRow += direction;
        }

        // Merge all rows
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }
}
