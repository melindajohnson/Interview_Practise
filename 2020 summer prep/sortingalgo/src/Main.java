
import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) {

        int[] quickSortTEST = {3,1,5,6,7,0};
        System.out.println("Before");
        displayArray(quickSortTEST);
        quickSort(quickSortTEST,0,5);
        System.out.println("After sorting");
        displayArray(quickSortTEST);

        int[] mergeSortTEST = {3,1,5,6,7,0};
        System.out.println("Before");
        displayArray(mergeSortTEST);
        mergesort(mergeSortTEST);
        System.out.println("After sorting");
        displayArray(mergeSortTEST);

        int[] selectionSortTEST = {3,1,5,6,7,0};
        System.out.println("Before");
        displayArray(selectionSortTEST);
        selectionSort(selectionSortTEST);
        System.out.println("After sorting");
        displayArray(selectionSortTEST);

        int[] bubbleSortTEST = {3,1,5,6,7,0};
        System.out.println("Before");
        displayArray(bubbleSortTEST);
        bubbleSort(bubbleSortTEST);
        System.out.println("After sorting");
        displayArray(bubbleSortTEST);
    }

    //Quick Sort
    //Time Complexity : O(n log n) best case & average case, O(n^2) worst case
    //Space Complexity: O(log n)
    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // Sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) { // Sort right half
            quickSort(arr, index, right);
        }
    }

    public static int partition(int arr[], int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be an element.

        while (left <= right) { // Until we've gone through the whole array
            // Find element on left that should be on right
            while (arr[left] < pivot) {
                left++;
            }

            // Find element on right that should be on left
            while (arr[right] > pivot) {
                right--;
            }

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }



    //Merge Sort
    //Time Complexity : O(n log n) worst case & average case
    //Space Complexity: O(n)
    public static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle); // Sort left half
            mergesort(array, helper, middle+1, high); // Sort right half
            merge(array, helper, low, middle, high); // Merge them
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /* Copy both halves into a helper array */
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /* Iterate through helper array. Compare the left and right
         * half, copying back the smaller element from the two halves
         * into the original array. */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* Copy the rest of the left side of the array into the
         * target array */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }


    //Selection Sort
    //Time Complexity : O(n^2) worst case & average case
    //Space Complexity: O(1)
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int min_Index = i;
            for (int k = i+1; k < array.length ; k++) {
                if(array[min_Index] > array[k]) {
                    min_Index = k;
                }
            }
            swap(array,min_Index,i);
        }
    }

    //Bubble Sort
    //Time Complexity : O(n^2) worst case & average case
    //Space Complexity: O(1)
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int k = 0; k < array.length - 1-i; k++) {
                swapped = false;
                if (array[k] > array[k + 1]) {
                    swap(array, k, k + 1);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static void swap(int[] array, int current, int next) {
        int temp = array[current];
        array[current] = array[next];
        array[next] = temp;
    }

    static void displayArray(int mat[]) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print(" " + mat[i]);
        }
        System.out.print("\n");
    }
}

