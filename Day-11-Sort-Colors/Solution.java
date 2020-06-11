/**
 * Day 11 - Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 *  Input: [2,0,2,1,1,0]
 *  Output: [0,0,1,1,2,2]
 * 
 * Follow up: a one-pass algorithm using only constant space?
 * 
 * */

class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

