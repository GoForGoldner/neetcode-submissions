class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Associate each number on the board as a bit

        // For the row, column and diagonal see if that bit is already present in the
        //  respective category

        // If it's not set the bit

        int n = 9;

        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] boxes = new int[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Skip empty cells
                if (board[row][col] == '.') continue;

                // Converting the char into a int and then bitshifting that many times
                int numBit = 1 << (board[row][col] - '1');
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Check if the bit is present in the current list
                if (
                    (rows[row] & numBit) > 0 ||
                    (cols[col] & numBit) > 0 ||
                    (boxes[boxIndex] & numBit) > 0
                ) {
                    return false;
                }

                // Update the lists
                rows[row] |= numBit;
                cols[col] |= numBit;
                boxes[boxIndex] |= numBit;
            }
        }

        return true;
    }
}
