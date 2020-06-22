//从右上角开始找 做了一万遍了
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=0;
        int column=matrix[0].length-1;
        while(row<matrix.length && column>=0){
            if(target==matrix[row][column]){
                return true;
            }else if(target > matrix[row][column]){
                row++;
            }else{
                column--;
            }
        }
        return false;
    }
}
//时间复杂度O(N)
