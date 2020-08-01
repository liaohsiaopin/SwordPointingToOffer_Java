//  统计一个数字在排序数组中出现的次数

// 方法一： 顺序查找  100 92
class Solution {
    public int search(int[] nums, int target) {
        int count=0,i;
        for(i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
                i++;
                break;
            }
        }
        while(nums[i]==target){
            count++;
            i++;
        }
        return count;
    }
}



// 方法二：二分查找  使用i<=j i=m+1 j=m-1 全部对应闭区间
class Solution {
    public int search(int[] nums, int target) {
        //搜索右边界 right
        int i=0, j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]<=target)  i=m+1;
            else j=m-1;
        }

        int right=i;
        //若数组中无target，则提前返回
        if(j>=0 && nums[j]!=target) return 0;

        //搜索左边界
        i=0;
        j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]<target)  i=m+1;  //if的条件不同，等于在那里就表明把相等的值放在那里，因此可以搜索左右边界
            else j=m-1;
        }
        int left=j;
        return right-left-1;
    }
}


//简短一点
class Solution{
    public int search(int[] nums,int target){
        return helper(nums,target)-helper(nums,target-1);
    }

    int helper(int[] nums,int target){
        int i=0,j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]<=target) i=m+1;
            else j=m-1;
        }
        return i;
    }
}