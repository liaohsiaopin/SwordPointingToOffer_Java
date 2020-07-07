/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*  终止条件：B空；A空；值不等
    特例：A空 or B空 false
    三个判断：根节点，左子树，右子树
*/

/*  思路：
    1. 找A中一个节点，若值和B相同，则判断他俩。
    2. 如果值不同，先判断A的坐左子树，递归调用
    3. 如果左子树的值不同，则判断右子树
    4. 判断他俩： B为空，ture，A为空 false，A！=B false，再递归判断A B的左右子树
*/
//100
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result=false;
        if(A!=null && B!=null){
            if(A.val==B.val){
                result=recur(A,B);
            }
            if(!result){
                result=isSubStructure(A.left,B);
            }
            if(!result){
                result=isSubStructure(A.right,B);
            }
        }
        return result;
    }

    public boolean recur(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}