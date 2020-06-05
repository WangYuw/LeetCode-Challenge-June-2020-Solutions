/**
 * Day 5 - Random Pick with Weight
 * 
 * Given an array w of positive integers, where w[i] describes the weight of index i, 
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 * 
 * Note:
 *  1 <= w.length <= 10000
 *  1 <= w[i] <= 10^5
 *  pickIndex will be called at most 10000 times.
 * 
 * Example 1:
 *  Input: 
 *      ["Solution","pickIndex"]
 *      [[[1]],[]]
 *  Output: [null,0]
 * 
 * Example 2:
 *  Input: 
 *      ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 *      [[[1,3]],[],[],[],[],[]]
 *  Output: [null,0,1,1,1,0]
 * 
 * Explanation of Input Syntax:
 *  The input is two lists: the subroutines called and their arguments. 
 *  Solution's constructor has one argument, the array w. pickIndex has no arguments. 
 *  Arguments are always wrapped with a list, even if there aren't any.
 *  
 */

class Solution {
   
   private int[] nums;
   private int total;
   private Random rand;

   public Solution(int[] w) {
       this.rand = new Random();
       for (int i = 1; i < w.length; i++) {
           w[i] += w[i - 1];
       }
       this.nums = w;
       this.total = w[w.length - 1];
   }
   
   public int pickIndex() {
       if (this.total == 0) return -1;
       int n = this.rand.nextInt(this.total) + 1;
       int lo = 0, hi = this.nums.length - 1;
       while (lo < hi) {
           int mid = lo + (hi - lo) / 2;
           if (this.nums[mid] == n)
               return mid;
           else if (this.nums[mid] < n)
               lo = mid + 1;
           else hi = mid; 
       }
       return lo;
   }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(w);
* int param_1 = obj.pickIndex();
*/

