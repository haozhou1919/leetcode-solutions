/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
// improved solution
/**
 * use hashmap to keep track of visited number and their index
 * check if there is a number in the hashmap can sum up to the targer
 * as we traverse the array
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
// my original solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] an = new int[2];
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j]== target && i != j){
                    an[0]=i;
                    an[1]=j;
                    a = 1;
                    break;
                }
            }
            if(a != 0) break;
        }
        return an;
    }
   
}
// @lc code=end
