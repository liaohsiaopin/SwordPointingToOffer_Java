/*  思路：摩尔投票
    1. 设当前的首个元素是众数
    2. 如果vote不等于0，则继续往后，数字等于众数则加1，不等于则-1
    3. 如果vote等于0，设置当前的数字为众数
*/
class Solution {
    public int majorityElement(int[] nums) {
        int res=0,sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum=0){
                res=nums[i];
                sum++;
            }
            else if(nums[i]!=res)   sum--;
            else sum++;
        }
        return res;
    }
}