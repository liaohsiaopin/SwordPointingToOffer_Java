/*  思路：第i个位置的数字m
    i=m -> i++
        第m个位置的数字等于m ->重复
            不等于-> 交换位置m和位置i
*/
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]!=i){  //不相等 判断 如果相等则继续
                if(nums[i]==nums[nums[i]]) //相等 存在冲突
                    return nums[i];
                int temp=nums[i];  //不等 换到它需要的位置
                nums[i]=nums[nums[i]];
                nums[temp]=temp;  //下标必须是temp 不能是nums[i]
            }
        }
        return -1;
    }
}
//时间复杂度O(n) 空间复杂度O(1) 每个数字最多经过2次交换  

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set =new HashSet<Integer>();
        int index=-1;
        for(int num:nums){
            if(!set.add(num)){
                index=num;
                break;
            }
        }
        return index;
    }
//时间复杂度O(n) 空间复杂度O(n)   哈希表是O(n)
//没有尝试二分法
