/*  思路：划分为两个部分，左部分是正确的，右部分的第一个是缺失的
    使用二分查找，当m==Nums[m] 表示要继续往前查找，当不等的时候，要停下步伐
    最后停止的时候，i是那个地方
*/  
class Solution {
    public int missingNumber(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]==m)  i=m+1;
            else j=m-1;
        }
        return i;
    }
}