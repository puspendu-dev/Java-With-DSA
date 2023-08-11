package Arrays1DAnd2D;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[]nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum1(nums,target)));
    }
    //Time complexity O(n^2) using two loops
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                 if(nums[i]+nums[j]==target){
                     return new int[]{i,j};
                 }
            }
        }
        return new int[]{-1,-1};
    }
    static int[] twoSum1(int[] nums, int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int diff=target-nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i );
        }
        return new int[]{-1,-1};
    }
}
