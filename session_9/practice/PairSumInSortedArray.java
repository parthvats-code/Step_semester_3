import java.util.*;
public class PairSumInSortedArray {
    static int[] pairSumSorted(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<right) {
            long sum=(long)nums[left]+nums[right];
            if(sum==target) return new int[]{nums[left],nums[right]};
            if(sum<target) left++; else right--;
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairSumSorted(new int[]{-4,-1,0,3,5,9},4)));
        System.out.println(pairSumSorted(new int[]{1,2,3},100)==null ? "Not Found" : "found");
        // O(n) time, O(1) extra space; brute force is O(n^2).
    }
}