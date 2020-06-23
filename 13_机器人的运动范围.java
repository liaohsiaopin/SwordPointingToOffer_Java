/*  思路：

*/
class Solution {
    int x,y,k;
    
    //这个必须有，否则会有重复
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.x=m;
        this.y=n;
        this.k=k;
        this.visited=new boolean[m][n];
        return dfs(0,0,0,0);
    }

    //sumX sumY表示当前位置x,y分别的和
    public int dfs(int x,int y,int sumX,int sumY){
        //下标越界 数位和大于指定值 直接返回 不往左和上 不需要判断
        if(x>=this.x||y>=this.y||sumX+sumY>this.k||visited[x][y])
            return 0;
        
        //没有越界，继续查找
        visited[x][y]=true;

        //1.    当x或者y从n9进位到(n+1)0的时候，数位和减少8
        //2.    当x或y在个位数从0~8范围内增加1，数位和增加1
        //      只需要向右或者向下扩张，左边的都是走过的
        return 1+dfs(x+1,y,(x+1)%10==0?sumX-8:sumX+1,sumY)+dfs(x,y+1,sumX,(y+1)%10==0?sumY-8:sumY+1);      
    }
}