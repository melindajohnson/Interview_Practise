import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int rows = 323;
        int columns = 31;
        char[][] myArray = new char[rows][columns];

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("input.txt")));
                for (int i = 0; i < rows; i++) {
                    char[] line = sc.nextLine().toCharArray();
                    for (int j = 0; j < columns; j++) {
                        myArray[i][j] = line[j];
                    }
                }
        }catch (FileNotFoundException e){
            System.out.println("error");
        }

        System.out.println(route(myArray));
    }


    public static long routeHelper(char [][] matrix, int right, int bottom) {
        int numberOfRows  = matrix.length;
        int numberOfCols  = matrix[0].length;

        int bottomIterator =0;
        int rightIterator =0;
        int rightIndex = 0;

        long numberOfTrees = 0;
        while(bottomIterator <  numberOfRows){
            rightIndex = rightIterator%numberOfCols;
            if(matrix[bottomIterator][rightIndex]=='#')  numberOfTrees++;
            bottomIterator += bottom;
            rightIterator += right;
        }
        return numberOfTrees;

    }

    public static long route(char [][] matrix){
        long result = 1;
        result *=(routeHelper(matrix,1,1));
        result *=(routeHelper(matrix,3,1));
        result *=(routeHelper(matrix,5,1));
        result *=(routeHelper(matrix,7,1));
        result *=(routeHelper(matrix,1,2));
         return result;

    }
}
