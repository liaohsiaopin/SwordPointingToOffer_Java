/*  可重复的数组 后面一段放到前面 找出数组最小的
    顺序查找：没有利用排序特性
    二分查找：每次查找中间元素，如果比末尾da
*/
//100 100
//先二分查找，直到end=start，若无法继续二分则顺序查找
class Solution {
    public int minArray(int[] numbers) {
        int start=0;
        int end=numbers.length-1;
        while(start!=end){
            int mid=(start+end)/2;
            if(numbers[mid]>numbers[end])
                start=mid+1;
            else if(numbers[mid]<numbers[end])
                end=mid;
            else return fidMin(numbers,start,end);
        }
        return numbers[start];
    }

    public int fidMin(int[] numbers,int start,int end){
        int res=numbers[start];
        for(int i=start;i<end;i++){
            if(numbers[i]<res)
                res=numbers[i];
        }
        return res;
    }
}