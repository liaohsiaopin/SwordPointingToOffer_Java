/*  题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    最简单的办法：遇到偶数 后面的数字前移 再把偶数放到最后 O(n2)
*/

/*  思路一： 两个指针，一个在最前面，一个在最后面，依次往前扫描交换
    99.81  100
*/
class Solution {
    public int[] exchange(int[] nums) {
        int start=0,end=nums.length-1;
        while(start<end){  //不能相等
            while((nums[start]&1)==1 && start<end){  //奇数  &和%结果相同，并没有速度上的提升噢
                start++;
            }

            while((nums[end] &1) !=1&& start<end){
                end--;
            }
            if(start<end){
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
            }
        }
        return nums;
    }
}

//便于扩展：可以用于任何的分类，将大于小于放在其他函数中，也就可以由不同的标准了！

/*  思路二：快慢指针
    slow在fast遇到奇数的时候往前走，遇到偶数的时候停下.
    slow保留的是下一个奇数要保存的位置！由于fast走在前面，fast保证slow如果遇到偶数会停下，遇到奇数会继续往前
    slow不具备往前扫描的功能，当fast往前扫描且是奇数的时候才会发生交换。只要slow和fast指向不同位置的时候，slow就一直指着偶数了
*/
//  99.81  100
class Solution {
    public int[] exchange(int[] nums) {
        int fast=0,slow=0,temp=0;
        while(fast<nums.length-1){
            if((nums[fast] & 1)==1){  //遇到奇数的时候交换，只有遇到奇数了slow才往前
                if(fast!=slow){
                    temp=nums[fast];
                    nums[fast]=nums[slow];
                    nums[slow]=temp;
                }
                slow++;
            }
            fast++;
        }
        return nums;
    }
}