//Sliding window Questions

public class Main {

    public static void main(String[] args) {
//        System.out.println("Maximum sum of a subarray of size K: "
//                + findMaxConsecutiveOnes(new int[] { 1,1,1,0,1,0,1,1,1,1,1 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + smallestSubarray( new int[] { 1,2, 1,1,1,1 }, 5));
    }

//
//    public static int[] findMaxSumSubArray(int k, int[] array){
//        int maxSum = Integer.MIN_VALUE;
//        for(int i =0; i< array.length-k; i++){
//            int curSum = 0;
//            for(int j = i; j< i+k; j++){
//                curSum += array[j];
//            }
//            maxSum = Math.max(maxSum,curSum);
//        }
//        return maxSum;
//    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int num = 0;
        int windowStart = 0;
        int windowEnd = 0;
        for(int i =0; i< nums.length; i++){
            if(nums[i] == 1){
                windowEnd = i;
                num++;
                result = Math.max(result,num);
            }
            else{
                windowStart = i+1;
                windowEnd = i+1;
                num = 0;
            }
        }
        return result;
    }

    public static int smallestSubarray(int[] nums, int sum) {
        int length = Integer.MAX_VALUE;
        int sumCheck = 0;
        int windowStart = 0;
        for(int windowEnd =0; windowEnd< nums.length; windowEnd++){
            sumCheck+=nums[windowEnd];

            while(sumCheck >=sum){
                length = Math.min(windowEnd-windowStart+1,length);
                sumCheck -= nums[windowStart];
                windowStart++;


            }
        }
        return length;
    }
}
