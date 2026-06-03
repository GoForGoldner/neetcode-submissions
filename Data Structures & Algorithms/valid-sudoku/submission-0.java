class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] boxes = new int[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Skip empty cells
                if (board[row][col] == '.') continue;

                int num = board[row][col] - '1';
                int numBit = 1 << num;
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Make sure the number is valid
                if (
                    (rows[row] & numBit) > 0 ||
                    (cols[col] & numBit) > 0 ||
                    (boxes[boxIndex] & numBit) > 0
                ) {
                    return false;
                }

                // Add number to spots
                rows[row] |= numBit;
                cols[col] |= numBit;
                boxes[boxIndex] |= numBit;
            }
        }

        return true;
    }
}
