package Arrays1DAnd2D;

import java.util.Arrays;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int[]numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum1(numbers,target)));
    }
    //Brute Force solution
    static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length ; j++) {
                if(numbers[i]+numbers[j]==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{-1,-1};
    }
    //Two Pointer Approach to reduce time complexity
    static int[] twoSum1(int[] numbers, int target) {
         int i=0;
         int j=numbers.length-1;
         while (i<j){
             int sum=numbers[i]+numbers[j];
             if(sum>target){
                 j--;
             } else if (sum<target) {
                 i++;
             }
             else {
                 return new int[]{i+1,j+1};// if target==sum so we found ith and jth index;
             }
         }
         return new int[]{-1,-1};
    }
}