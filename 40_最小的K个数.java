/*  找出最下的k个数
    Top K。常见的两种解法，一种使用堆(优先队列)，另一种是类似快排的分治法
*/

/*  方法一：堆
    堆的性质是每次可以找到最大的或者最小的元素。可以使用一个大小为k的最大堆，将数组的元素依次入堆
    当堆的大小超过k的时候，便将对于的元素从堆里面弹出。每次弹出的是堆中最大的元素，因此剩下的肯定是最小k个数
    使用库函数的优先队列结构，比如java的PriorityQueue。不需要实现堆的内部接口。

    出堆和入堆的时间O(logK) 因此总的O(NlogK)

*/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0)    return new int[0];
        //默认是最小堆，使用comparator参数使其变成最大堆。
        Queue<Integer> heap=new PriorityQueue<>(k,(i1,i2)->Integer.compare(i2,i1));
        
        for(int e:arr){
            //当前数字小于堆顶元素才会入：
            if(heap.isEmpty()||heap.size()<k||e<heap.peek()){
                heap.offer(e);
            }
            if(heap.size()>k){
                heap.poll();//删除堆顶最大元素
            }
        }
        int[] res=new int[heap.size()];
        int j=0;
        for(int e:heap) res[j++]=e;
        return res;
    }
}