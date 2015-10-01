/**
 * Created by zhangyuwei on 9/30/15.
 */

/*
    we look at each even position in the array, we want to make every even position a peak, and odd position a valley.
    So we check if the even number is larger than its neighbors, if not, we switch it with the larger neighbor.
 */
public class Solution11 {
    public static void main(String[] args){
        int[] nums= {5,3,1,2,3};
        peakAndzValley(nums);
    }

    public static void peakAndzValley(int[] nums){
        if(nums.length == 1){
            for(int i:nums)
                System.out.print(i);
            return;
        }
        for(int i = 1; i < nums.length; i += 2){
            if(i == nums.length -1){
                if(nums[i] < nums[i-1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
            else{
                if(nums[i] < nums[i-1] || nums[i] < nums[i+1]){
                    if(nums[i-1] > nums[i+1]){
                        int temp = nums[i];
                        nums[i] = nums[i - 1];
                        nums[i - 1] = temp;
                    }
                    else{
                        int temp = nums[i];
                        nums[i] = nums[i+1];
                        nums[i+1] = temp;
                    }
                }
            }
        }
        for(int i:nums)
            System.out.print(i);
    }
}
