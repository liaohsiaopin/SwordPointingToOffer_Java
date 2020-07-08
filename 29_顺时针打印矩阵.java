/*  打印顺序：左->右 上->下 右->左 下->上

    流程：
    1.  空置处理
    2.  四个边界
    3.  循环打印，每个方向做三件事：
        1.  根据边界打印，将元素添加到res尾部
        2.  边界向内收缩1
        3.  判断是否打印完毕
*/
// 97.22 100
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)    return new int[0];
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1,x=0;
        int[] res=new int[(r+1)*(b+1)];
        while(true){
            for(int i=l;i<=r;i++)   res[x++]=matrix[t][i];
            if(++t>b)   break;
            for(int i=t;i<=b;i++)   res[x++]=matrix[i][r];
            if(l>--r)   break;
            for(int i=r;i>=l;i--)   res[x++]=matrix[b][i];
            if(t>--b)   break;
            for(int i=b;i>=t;i--)   res[x++]=matrix[i][l];
            if(++l>r)   break;
        }
        return res;
    }
}