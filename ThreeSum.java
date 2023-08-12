package Arrays1DAnd2D;
//https://leetcode.com/problems/3sum/description/
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
       int[]nums = {-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(new List[]{threeSum1(nums)}));
    }
    static  List<List<Integer>>ans=new ArrayList<>();
    static List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3){
            return new ArrayList<>();
        }
        ans.clear();
        Arrays.sort(nums);
        // for n1
        //n2+n3=-n1(target);
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int n1=nums[i];//for n1 needs to be fixed and not duplicates
            int target=-n1;
            twosum(nums,target,i+1,nums.length-1);
        }
          return ans;
    }
    static void twosum(int[]nums,int target,int i,int j){
        while (i<j){
            if(nums[i]+nums[j]<target){
                i++;
            }
            else if (nums[i]+nums[j]>target){
                j--;
            }
            else {
                while (i<j&&nums[i]==nums[i+1]){
                    i++;
                }
                while (i<j&&nums[j]==nums[j-1]){
                    j--;
                }
                ans.add(Arrays.asList(-target,nums[i],nums[j]));
                i++;
                j--;
            }
        }
    }
    //Using Hashset Time complexity->O(n^2)
    //Space complexity->O(n)
    static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        if(nums==null||nums.length<3){
            return new ArrayList<>();
        }
        //Sort the element
        Arrays.sort(nums);
        //Now fix the first element and find the other two element
        for (int i = 0; i < nums.length-2; i++) {
            //Find other two element using two sum approach
            int left=i+1;
            int right= nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                } else if (sum>0) {
                    right--;
                }
                else {
                    //Add the set and move to find others triplet
                     ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                     left++;
                     right--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
