//  思路一：两次遍历，第一次保存到hashmap中，val是是否已经存在
//  63.29 31.40

class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> dic=new HashMap<>();
        char[] sc=s.toCharArray();
        for(char c:sc)
            dic.put(c,!dic.containsKey(c);
        for(char c:sc)
            if(dic.get(c))  return c;
        return ' ';
    }
}


class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> dic=new HashMap<>();
        char[] str=s.toCharArray();
        for(char c:str)
            dic.put(c,dic.containsKey(c));  // 如果是，没有的就是false
        for(char c:str)
            if(!dic.get(c))     return c;
        return ' ';
    }
}

/*  思路二：有序哈希表 
    减少第二轮循环次数，有序哈希是按插入顺序排序的，搜索首个1
*/

class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> dic=new LinkedHashMap<>();
        char[] str=s.toCharArray();
        for(char c:str)
            dic.put(c,!dic.containsKey(c));  // 如果是，没有的就是false
        for(Map.Entry<Character,Boolean> d: dic.entrySet()){
            if(d.getValue())   return d.getKey();
        }
        return ' ';
    }
}

