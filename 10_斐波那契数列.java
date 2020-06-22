/*      
    类似问题：青蛙跳台阶
*/


//动态规划 100 100
class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){ //是从2开始噢
            dp[i] = dp[i-1]+dp[i-2];
            dp[i] %= 1000000007;  //最终返回取余和每次计算取余等价(x+y)⊙p=(x⊙p+y⊙p)⊙p 。
        }
        return dp[n];
    }
}

//或者交换加数的方法，注意return a
//原因：第一遍的时候就相加了，相当于超前了一步
//1000 1000
class Solution {
    public int fib(int n) {
        int a=0,b=1,sum=0;
        for(int i=0;i<n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }
}

/*  递归
    缺点：有大量节点的重复，时间复杂度巨高
*/
class Solution {
    public int fib(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fib(n-1)+fib(n-2);
    }
}