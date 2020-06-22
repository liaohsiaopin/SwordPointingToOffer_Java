/*  明确需求，是否可以替换原始数据
    (C可以替换 可以采用二遍扫描 
    Java中无法替换 采用一遍扫描)
    原本思路: 先扫描一遍 统计空格个数 计算修改后的长度 从后往前扫描 or 从前往后扫
    遇到问题：但由于java的string是无法修改的，不能像C++那样处理，要使用StringBuilder or StringBuffer

*/

/*  垃圾解法：从头扫到尾，每次后移两位
    T(n)=O(n`2) 每个空格移动n个字符
    低效 没意义
*/


/*  一遍扫描
    思路：申请最大可能的新空间，从头到尾扫描依次复制
*/

// 方案：使用char数组  效果：时间100% 空间100%
class Solution {
    public String replaceSpace(String s) {
        int length=s.length();// String的length()有括号 
        char[] array=new char[length*3];
        int size=0;
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c==' '){
                array[size++]='%';
                array[size++]='2';
                array[size++]='0';
            } else{
                array[size++]=c;
            }
        }
        String newStr=new String(array,0,size);//add,strat,end
        return newStr;
    }
}
// 
// 方案：StringBuilder  效果：时间100% 空间100%
class Solution {
    public String replaceSpace(String s) {
        StringBuilder res=new StringBuilder();
        for(Character c:s.toCharArray()){  //这样遍历很优雅
            if(c==' ') res.append("20%");
            else res.append(c);
        }
        return res.toString();

    }
}

/*
    相关知识
    * String类是不可变类，即一旦一个String对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。
    * StringBuffer对象则代表一个字符序列可变的字符串，当一个StringBuffer被创建以后，通过StringBuffer提供的append()insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。
    * StringBuilder类也代表可变字符串对象。实际上，StringBuilder和StringBuffer基本相似，两个类的构造器和方法也基本相同。不同的是：StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。
    * return s.replaceAll(" ","%20"); 即可解决
*/



