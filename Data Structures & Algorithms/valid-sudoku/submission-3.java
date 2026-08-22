class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Validate each row, column, and box
        // Normal algorithm would be constant time for both space and memory because n is constant
        // But can be futher optimized with bit manipulation becasue each number is betweeen 1-9

        int n = 9;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] boxes = new int[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Skip non numbers
                if (board[row][col] == '.') continue;

                // Calculate number as bit
                int numBit = 1 << (board[row][col] - '1');
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Check for validated rules
                if (
                    (rows[row] & numBit) > 0 ||
                    (cols[col] & numBit) > 0 ||
                    (boxes[boxIndex] & numBit) > 0
                ) return false;

                // Update rows and columns
                rows[row] |= numBit;
                cols[col] |= numBit;
                boxes[boxIndex] |= numBit;
            }
        }

        return true;
    }
}
