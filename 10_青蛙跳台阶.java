/*  依旧是动态规划
    n=0的时候也是1 
*/
class Solution {
    public int numWays(int n) {
        int[] res=new int[n+1];

        if(n<=1)
            return 1;

        res[0]=1;
        res[1]=1; 
        for(int i=2;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
            res[i] %=1000000007;
        }
        return res[n];
    }
}