package leetcode.Q01284;

import java.util.*;

public class Solution {
    private static int[] mx = {0, 1, 0, -1};
    private static int[] my = {1, 0, -1, 0};

    public int minFlips(int[][] mat) {
        Set<Matrix> set = new HashSet<>();
        Queue<Matrix> q = new LinkedList<>();

        Matrix matrix = new Matrix(mat, 0);
        set.add(matrix);
        q.add(matrix);

        while(!q.isEmpty()) {
            Matrix curMatrix = q.poll();

            if(curMatrix.isZeroMatrix()) {
                return curMatrix.flipCount;
            }

            for(int y = 0 ; y < mat.length ; ++y) {
                for(int x = 0 ; x < mat[0].length ; ++x) {
                    int[][] nextMat = curMatrix.flip(y, x);
                    int flipCount = curMatrix.flipCount + 1;

                    Matrix nextMatrix = new Matrix(nextMat, flipCount);

                    if(set.contains(nextMatrix)) {
                        continue;
                    }

                    set.add(nextMatrix);
                    q.add(nextMatrix);
                }
            }
        }

        return -1;
    }


    protected class Matrix {
        int[][] matrix;
        int flipCount;
        String matrixString;

        Matrix(int[][] matrix, int flipCount) {
            this.matrix = matrix;
            this.flipCount = flipCount;
        }

        public int[][] flip(int y, int x) {
            int[][] newMat = new int[matrix.length][matrix[0].length];

            for(int i = 0 ; i < matrix.length ; ++i) {
                for(int j = 0 ; j < matrix[0].length ; ++j) {
                    newMat[i][j] = matrix[i][j];
                }
            }

            flip(newMat, y, x);

            for(int move = 0 ; move < mx.length ; ++move) {
                flip(newMat, y + my[move], x + mx[move]);
            }

            return newMat;
        }

        private void flip(int[][] matrix, int y, int x) {
            if(y < 0 || x < 0 || y >= matrix.length || x >= matrix[0].length) {
                return;
            }

            matrix[y][x] = 1 - matrix[y][x];
        }

        public String matrixString() {
            if(matrixString != null) {
                return matrixString;
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < matrix.length ; ++i) {
                sb.append(Arrays.toString(matrix[i]));
            }

            matrixString = sb.toString();

            return matrixString;
        }

        public boolean isZeroMatrix() {
            for(int i = 0 ; i < matrix.length ; ++i) {
                for(int j = 0 ; j < matrix[i].length ; ++j) {
                    if(matrix[i][j] == 1) {
                        return false;
                    }
                }
            }

            return true;
        }

        @Override
        public boolean equals(Object o) {
            Matrix matrix1 = (Matrix) o;
            return matrixString().equalsIgnoreCase(matrix1.matrixString());
        }

        @Override
        public int hashCode() {
            return Objects.hash(matrixString());
        }
    }
}
