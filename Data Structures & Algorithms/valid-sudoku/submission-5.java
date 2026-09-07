class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Can use numbers to represent the column of a board by using specific bits in the grid
        // Changes the memory to be a smaller constant

        int n = 9;
        int[] rowBits = new int[n];
        int[] colBits = new int[n];
        int[] boxBits = new int[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Skip non numbers
                if (board[row][col] == '.') continue;

                int numBit = 1 << (board[row][col] - '1');
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Validate rules haven't been violated
                // (by checking if the bit is present in the current row / column)
                if (
                    (rowBits[row] & numBit) > 0 || 
                    (colBits[col] & numBit) > 0 || 
                    (boxBits[boxIndex] & numBit) > 0
                ) return false;

                // Update rows and columns
                rowBits[row] |= numBit;
                colBits[col] |= numBit;
                boxBits[boxIndex] |= numBit;
            }
        }

        return true;
    }
}
