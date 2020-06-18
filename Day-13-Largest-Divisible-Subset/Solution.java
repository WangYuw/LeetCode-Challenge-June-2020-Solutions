/**
 * Day 13 - Largest Divisible Subset
 * 
 * Given a set of distinct positive integers, 
 * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *  Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 *  Input: [1,2,3]
 *  Output: [1,2] (of course, [1,3] will also be ok)
 * 
 * Example 2:
 *  Input: [1,2,4,8]
 *  Output: [1,2,4,8]
 * 
 * */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null||nums.length==0)
            return result;

        Arrays.sort(nums);

        int[] arr = new int[nums.length];
        int[] index = new int[nums.length];
        Arrays.fill(arr, 1);
        Arrays.fill(index, -1);

        int max=0;
        int maxIndex=-1;

        for(int i=0; i<arr.length; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j]==0 && arr[j]+1>arr[i]){
                    arr[i]=arr[j]+1;
                    index[i]=j;
                }
            }
            if(max<arr[i]){
                max=arr[i];
                maxIndex=i;
            }
        }
        
        int i=maxIndex;
        while(i>=0){
            result.add(nums[i]);
            i=index[i];
        }

        return result;
    }
}