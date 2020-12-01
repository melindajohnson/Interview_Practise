import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 30,  50,  70,  73},
                {35, 40, 100, 102, 120},
                {36, 42, 105, 110, 125},
                {46, 51, 106, 111, 130},
                {48, 55, 109, 140, 150}};

        displayMatrix(matrix);
        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;
        int littleOverTheMax = matrix[m - 1][n - 1] + 10;
//        for (int i = 0; i < littleOverTheMax; i++) {
//            Coordinate c = findElement(matrix, i);
//            if (c != null) {
//                System.out.println(i + ": (" + c.row + ", " + c.column + ")");
//                count++;
//            }
//        }

        int target = 30;
        Coordinate c =  findElement(matrix, target);
        System.out.println(target + ": (" + c.row + ", " + c.column + ")");
       // System.out.println("Found " + count + " unique elements.");
    }

        public static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int elem) {
            Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
            Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
            Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
            Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);

            Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, elem);
            if (lowerLeft == null) {
                return findElement(matrix, upperRightOrigin, upperRightDest, elem);
            }
            return lowerLeft;
        }

        public static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
            if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
                return null;
            }
            if (matrix[origin.row][origin.column] == x) {
                return origin;
            } else if (!origin.isBefore(dest)) {
                return null;
            }

            /* Set start to start of diagonal and end to the end of the diagonal. Since
             * the grid may not be square, the end of the diagonal may not equal dest.
             */
            Coordinate start = (Coordinate) origin.clone();
            int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
            Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
            Coordinate p = new Coordinate(0, 0);

            /* Do binary search on the diagonal, looking for the first element greater than x */
            while (start.isBefore(end)) {
                p.setToAverage(start, end);
                if (x > matrix[p.row][p.column]) {
                    start.row = p.row + 1;
                    start.column = p.column + 1;
                } else {
                    end.row = p.row - 1;
                    end.column = p.column - 1;
                }
            }

            /* Split the grid into quadrants. Search the bottom left and the top right. */
            return partitionAndSearch(matrix, origin, dest, start, x);
        }

        public static Coordinate findElement(int[][] matrix, int x) {
            Coordinate origin = new Coordinate(0, 0);
            Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
            return findElement(matrix, origin, dest, x);
        }



    static void displayMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }


    }
