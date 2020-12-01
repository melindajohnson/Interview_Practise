import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//	int[][] matrix = new int[][]{{1,3,5,8},{9,11,13,15},{17,19,20,25},{27,30,33,37},{38,39,40,43},{45,47,49,50}};
//	    System.out.println("Test Case 1:input = 0 : Expected: false: Actual: " + searchMatrix(matrix,0));
//        System.out.println("Test Case 1:input = 11 : Expected: true: Actual:" + searchMatrix(matrix,11));
//        System.out.println("Test Case 1:input = 40 : Expected: true: Actual: " + searchMatrix(matrix,40));
//        System.out.println("Test Case 1:input = 50 : Expected: true: Actual:" + searchMatrix(matrix,50));
//        System.out.println("Test Case 1:input = 30 : Expected: true: Actual:" + searchMatrix(matrix,30));
//        System.out.println("Test Case 1:input = 55 : Expected: false: Actual:" + searchMatrix(matrix,55));

        int[][] interval = new int[][]{{1,3},{2,6},{8,10},{15,18}};
       displayMatrix(mergeIntervals(interval));

    }

    public static int[][] mergeIntervals(int[][] intervals){
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval: intervals){
            if(newInterval[1]>=interval[0]){
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
            else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
       // result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    static void displayMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length-1; int cols=matrix[0].length-1;

        int rowNo = searchRows(matrix,target,0,cols);
        if(rowNo <0 || rowNo > rows) return false;
        int colNo = searchCols(matrix,target,rowNo,cols);
        if( colNo<0 || colNo>cols) return false;
        System.out.println(rowNo+"," + colNo);

        return true;
    }

    public static int searchRows(int[][] matrix, int target, int startingRow, int Column){
        int top = startingRow;
        int down = matrix.length-1;
        while(top<down) {
            int mid = (top+down)/2;
            if (matrix[mid][Column] == target) return mid;
            else if (matrix[mid][Column] < target) top = mid+1;
            else down = mid-1;
        }
        if(matrix[top][Column] < target) return top+1;
        return down;
    }


    public static int searchCols(int[][] matrix, int target, int startingCol, int Rows) {
        int left = 0;
        int right = matrix[0].length-1;
        while(left<right) {
            int mid = (left+right)/2;
            if (matrix[startingCol][mid] == target) return mid;
            else if (matrix[startingCol][mid] < target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return right;

    }





//    public static boolean searchMatrix(int[][] matrix, int target){
//        int rows=matrix.length; int cols=matrix[0].length;
//        int i = 0; int j = cols-1;
//        while(i<rows && j>=0){
//            if(matrix[i][j]==target) return true;
//            else if(matrix[i][j] < target) i++;
//            else j--;
//        }
//        return false;
//    }
}
