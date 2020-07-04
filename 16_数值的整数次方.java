/*  思路一：直接乘n次
    不足：指数小于1,为0和负数的时候怎么办
    改进：
            1.负数的时候，先指数再求大倒数。
            2.0的0次方没有意义，返回0或者1都可
            3.4=2*2 每次用一半相乘可减少计算次数
*/

/*  思路二：  如果n是偶数，n/2 * n/2
             如果n是奇数，n-1/2 * n-1/2 * 1
*/
//这个我没有好好理解，之后再看 93.89% 100%
class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        long b=n;
        double res=1.0;
        if(b<0){
            x=1/x;
            b=-b;
        }
        //类似于模拟递归自底向上
        while(b>0){
            //将当前x存入res
            if((b&1)==1) res*=x; // 与运算代替% 来判断一个数是不是奇数  
            x*=x;  // 执行x=x^2
            b>>=1; //右移  右移代替除以二
        }
        return res;
    }
}

//递归实现  没有跑通
class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        long b=n;
        double res=unsigned(x,b);
        return res;
    }

    public double unsigned(double x,long n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }

        double res=unsigned(x,n>>1);
        res*=res;
        if((n&1)==1){
            res*=x;
        }
        return res;
    }
}