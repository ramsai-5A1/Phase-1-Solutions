

// User function Template for Java



class GFG {
    static void rotate(int mat[][]) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
             
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    static void printMatrix(int mat[][]) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(mat1);
        printMatrix(mat1);

        System.out.println();

        int[][] mat2 = {
            {1, 2},
            {3, 4}
        };
        rotate(mat2);
        printMatrix(mat2);

        System.out.println();

        int[][] mat3 = {
            {1}
        };
        rotate(mat3);
        printMatrix(mat3);
    }
}