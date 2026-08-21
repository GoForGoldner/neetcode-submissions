class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        int[] cols = new int[n];
        int[] rows = new int[n];
        int[] boxes = new int[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Skip not a number
                if (board[row][col] == '.') continue;

                int boxIndex = (row / 3) * 3 + (col / 3);

                // Calculate the number as a bit
                int numBit = 1 << (board[row][col] - '1');

                // Check if rules are violated
                if (
                    (rows[row] & numBit) > 0 ||
                    (cols[col] & numBit) > 0 ||
                    (boxes[boxIndex] & numBit) > 0
                ) return false;

                // Add number to current rules
                rows[row] |= numBit;
                cols[col] |= numBit;
                boxes[boxIndex] |= numBit;
            }
        }

        return true;
    }
}
