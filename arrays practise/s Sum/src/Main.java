import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5};
        int result = Sumof2(array, 5);

	// write your code here
    }
    //Given an array S of n integers, find two integers in S such that the sum is the given number, target.
    //Return the sum of the two integers.
    //Assume that there will only be one solution

   public static int Sumof2(int[] array, int target){

        if(array.length<=2) return 0;
        Arrays.sort(array);
        int left = 0;
        int right = array.length-1;
        int sum = Integer.MIN_VALUE;
        while(left<right){
            sum = array[left] + array[right];
            if(target==sum){
                return sum;
            }
            else if(target>sum){
                left++;
            }
            else if(target<sum){
                right--;
            }
        }
        return sum;

    }


    public static int Sumof2hash(int[] array, int target){

        HashSet<Integer> h1 = new HashSet<Integer>();
        for(int i = 0; i<array.length; i++){
            int temp = target - array[i];
            if(h1.contains(temp)){
                //found the pair
            }
            h1.add(array[i]);
        }

    }



}
