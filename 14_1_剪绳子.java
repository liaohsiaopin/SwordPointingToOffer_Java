/*  动态规划 把大问题分解成小问题 在各个小问题中选择最优解
    贪心：每一次都是最优解
*/

//  m是自己寻求的解，而非题目给出


// 数学推导的方法，也就是贪心，直接分析出最后的结果！
/*  推论一：  将绳子以相等的长度划分为多段，得到的乘积最大
    推论二：  将绳子长度尽可能切分为3，得到的成绩最大(3接近e) x=e
    最优：切分为3，然后剩余0,1,2
    次优：最后一段为2 保留
    最差：1，把3+1切换成2+2
    O(1) O(1)  100% 100%
*/
class Solution {
    public int cuttingRope(int n) {
        if(n<=3){  //因为必须要切一刀，所以三的时候是2+1
            return n-1;
        }
        int a=n/3,b=n%3;
        if(b==0){
            return (int)Math.pow(3,a);
        }
        if(b==1){
            return (int)Math.pow(3, a-1)*4;
        }
        return (int)Math.pow(3,a)*2;  //这里没有-1
    }
}

/* 模拟剪绳子 100 100
*/
class Solution {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int res=1;
        while(n>4){//不能等于，当剩下长度4的时候，是2x2而非3x1
            res*=3;
            n-=3;
        }
        return res*n;
    }
}

/*  动态规划：推论，只有长度为2或3的绳子不切分，且3比2优先
    思路：从长度4开始，依次递推到n，每次递推的时候，计算在位置j剪一刀的结果，保存结果的最大值
    max(f(j)*f(i-j))
    100 100
*/

class Solution {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;  //因为之后是从4开始考虑的，必须剪

        int max=0;
        for(int i=4;i<=n;i++){ //长度递增，自底向上
            max=0;
            for(int j=1;j<=i/2;j++){   //切一刀，分析结果，保存最大值
                int temp=dp[j]*dp[i-j];
                if(temp>max) max=temp;      
            }
            dp[i]=max;
        }
        return dp[n];
    }
}