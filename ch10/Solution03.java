/**
 * Created by zhangyuwei on 9/27/15.
 */

/*
    We use binary search here, but modify it a little.
    We check if the middle number is in the small part of the array or the larger part, and if the target is
    smaller of bigger than the middle number.
    Thus we have different conditions and we need to look at them differently.
 */
public class Solution03 {
    public static void main(String[] args){
        int[] a = {15,16,19,20,25,1,3,4,5,7,10,14};
        int result = search(a,5);

        System.out.println(result);
    }
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid=(left+right)/2;
        while(left < right){
            mid = (left + right)/2;
            if(target == nums[mid])
                return mid;
            if(nums[mid] > nums[right]){
                if(target > nums[mid])
                    left = mid + 1;
                else if(target >= nums[left])
                    right = mid;
                else
                    left = mid + 1;
            }
            else{
                if(target < nums[mid])
                    right = mid;
                else if(target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
        }
        if(target == nums[left])
            return left;
        else
            return -1;
    }
}
