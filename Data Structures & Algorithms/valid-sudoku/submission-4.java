class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] boxes = new int[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Skip non numbers
                if (board[row][col] == '.') continue;

                int numBit = 1 << (board[row][col] - '1');
                int boxIndex = boxIndex(row, col);

                // Check if rules are violated
                if (
                    (rows[row] & numBit) > 0 ||
                    (cols[col] & numBit) > 0 ||
                    (boxes[boxIndex] & numBit) > 0
                ) return false;

                // Update entries
                rows[row] |= numBit;
                cols[col] |= numBit;
                boxes[boxIndex] |= numBit;
            }
        }

        return true;
    }

    private int boxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
}
