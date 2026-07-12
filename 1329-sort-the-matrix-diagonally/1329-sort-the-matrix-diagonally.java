class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Sort diagonals starting from the first column
        for (int row = 0; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }

        // Sort diagonals starting from the first row
        for (int col = 1; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        List<Integer> diagonal = new ArrayList<>();

        int r = row;
        int c = col;

        // Collect elements
        while (r < mat.length && c < mat[0].length) {
            diagonal.add(mat[r][c]);
            r++;
            c++;
        }

        // Sort the diagonal
        Collections.sort(diagonal);

        // Put sorted elements back
        r = row;
        c = col;
        int index = 0;

        while (r < mat.length && c < mat[0].length) {
            mat[r][c] = diagonal.get(index++);
            r++;
            c++;
        }
    }
}