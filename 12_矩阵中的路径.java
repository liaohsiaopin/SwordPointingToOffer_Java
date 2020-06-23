/*  思想：回溯
    对于矩阵的每一个点，想四周找寻，如果不想等或者边界 return false
    只有找完了才return ture，否则继续向四周寻找
    用||得到四周寻找的结果，只要有一个成功即可
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){  //选择一个地方
                if(dfs(board,words,i,j,0)){
                    return true;
                }

            }
        }
        return false;
    }
    
    boolean dfs(char[][] board,char[] word, int i, int j , int k){
        //匹配不成功 回溯返回
        if(i>=board.length||j>=board[0].length||j<0||i<0||board[i][j]!=word[k]){
            return false;  
        }

        //匹配成功 继续向四周发散
        //如果是最后的 返回 
        if(k==word.length-1){
            return true;
        }
        char temp=board[i][j];
        board[i][j]='/';//代表该位置访问过
        //上下左右开始搜索
        // 只要最终由一个return true 就会一直上return true
        boolean res=dfs(board,word,i+1,j,k+1)||dfs(board,word,i-1,j,k+1)||dfs(board,word,i,j+1,k+1)||dfs(board,word,i,j-1,k+1);
        board[i][j]=temp;  //又开始了另一次搜索过程，这个只是代表访问过 
        return res;
    }
}



class Solution {
    int x,y,k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.x=m;
        this.y=n;
        this.k=k;
        this.visited=new boolean[m][n];
        return dfs(0,0,0,0);
    }

 
    public int dfs(int x,int y,int sumX,int sumY){
        if(x>=this.x||y>=this.y||sumX+sumY>this.k||visited[x][y])
            return 0;
        visited[x][y]=true;
        return 1+dfs(x+1,y,(x+1)%10==0?sumX-8:sumX+1,sumY)+dfs(x,y+1,sumX,(y+1)%10==0?sumY-8:sumY+1);
    }
}