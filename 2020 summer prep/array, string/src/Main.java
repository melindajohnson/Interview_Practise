
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {


    public static void main(String[] args) {

        //You are given two sorted arrays, A and B, where A has a large enough buffer at the
        //end to hold B. Write a method to merge B into A in sorted order.
        /*
        int[] A = new int[6];
        A[0] = 0;
        A[1] = 2;
        A[2] = 5;
        A[3] = 6;
        int[] B = new int[2];
        B[0] = 1;
        B[1] = 7;
        displayArray(A);
        displayArray(B);
        mergeSorted(A,B,3,1);
        displayArray(A);
         */

        //    Write a method to sort an array of strings so that all the anagrams are next to each other.
        /*
        String[] wordList = {"acre","frog","rofg","race","care","ogrf","zxwq"};
        displayStringArray(wordList);
        sortedAnangram(wordList);
        displayStringArray(wordList);
         */



        //Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array.
        // You may assume that the array was originally sorted in increasing order.

        /*
        int[] array1 = {10,15,20,0,5};
        displayArray(array1);
        System.out.println(search(array1,0,4,5));
        int[] array2 = {50,5,20,30,40};
        displayArray(array2);
        System.out.println(search(array2,0,4,5));


         */

        String[] wordsearchList = {"acre","care","","frog","","ogrf","race","","rofg","zxwq",""};

        System.out.println(searchI(wordsearchList,"care",0,wordsearchList.length-1));
    }
    //Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

    public static int searchI(String[] strings, String str, int first, int last) {
        while (first <= last) {
            /* Move mid to the middle */
            int mid = (last + first) / 2;

            /* If mid is empty, find closest non-empty string */
            if (strings[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while (true) {
                    if (left < first && right > last) {
                        return -1;
                    } else if (right <= last && !strings[right].isEmpty()) {
                        mid = right;
                        break;
                    } else if (left >= first && !strings[left].isEmpty()) {
                        mid = left;
                        break;
                    }
                    right++;
                    left--;
                }
            }

            int res = strings[mid].compareTo(str);
            if (res == 0) { // Found it!
                return mid;
            } else if (res < 0) { // Search right
                first = mid + 1;
            } else { // Search left
                last = mid - 1;
            }
        }
        return -1;
    }

    //Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array.
    // You may assume that the array was originally sorted in increasing order.

    public static int search(int[] array, int left,int right,int target){

        int mid = (left+right)/2;
        if(array[mid]==target) return mid;
        if(right<left)  return -1;
        else if(array[left] < array[mid]){//left half is sorted
            if(target >= array[left]  && target <= array[mid] ){
                return search(array,left,mid-1,target); //search left half
            }else{
                return search(array,mid+1,right,target); //search right half
            }
        }
        else if(array[mid] < array[left]){
            if(target >= array[mid]  && target <= array[right] ){
                return search(array,mid+1,right,target); //search right half
            }else{
                return search(array,left,mid-1,target); //search left half
            }
        }else if (array[mid]==array[left]){
            if(array[right]!=array[mid]){
                return search(array,mid+1,right,target);
            }else{
                int result =  search(array,left,mid-1,target);
                if(result!=-1){
                    return search(array,mid+1,right,target);
                }else return result;
            }
        }

        return -1;

    }








//    Write a method to sort an array of strings so that all the anagrams are next to each other.
    public static void sortedAnangram(String[] wordList){

        //create a hashmap of string and linkedlist of strings
        HashMap<String,LinkedList<String>> anagramMap = new HashMap<>();

        //sort each string in wordsList
        for(String s: wordList){
            String key = sortedString(s);
            //add each sorted string into this hash map
            if(!anagramMap.containsKey(key)){
                anagramMap.put(key,new LinkedList<String>());
            }
                LinkedList<String> temp = anagramMap.get(key);
                temp.push(s);

        }
        int index = 0;
        //iterate through the hashmap and add to new array
        for(String key:anagramMap.keySet()){
            LinkedList<String> list  = anagramMap.get(key);
            for(String s:list){
                wordList[index++] = s;
            }
        }
    }

    public static String sortedString(String word) {
        char[] wordArray= word.toCharArray();
        Arrays.sort(wordArray);
        return new String(wordArray);

    }
    //You are given two sorted arrays, A and B, where A has a large enough buffer at the
    //end to hold B. Write a method to merge B into A in sorted order.
    public static void mergeSorted(int[] A, int[] B,int lastA, int lastB){
        int current = A.length-1;
        while(lastB >= 0 && lastA>=0){
            if(A[lastA]>B[lastB]){
                A[current] = A[lastA];
                current--;
                lastA--;
            }else{
                A[current] = B[lastB];
                current--;
                lastB--;
            }
        }
        while(lastB >= 0){
            A[current--] = B[lastB--];
        }
    }

    static void displayArray(int mat[]) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print(" " + mat[i]);
        }
        System.out.print("\n");
    }

    static void displayStringArray(String mat[]) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print(" " + mat[i]);
        }
        System.out.print("\n");
    }
}

