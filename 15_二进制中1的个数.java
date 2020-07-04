/*  思考的问题：
    1. 如果是负数，右移有问题
    2. 右移等于除2，但右移速度远远快于除法
*/

/*  思路一： 每次右移一位，与1统计结果
            n&1=0：最右边的是0 
            n&1=1=1：最右边的是1
            移位运算 n>>=1
            
*/
//结果：99.32 100
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res+=n&1;
            n>>=1;
        }
        return res;
    }
}

/* 思路二：n&n-1 有几个1就会循环几次
            n-1会把最右边的1变成0，把其左边的0变成1
            n&n-1每次都能消除一个1
*/
//结果：99.32 100
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res++;
            n &= n-1;
        }
        return res;
    }
}