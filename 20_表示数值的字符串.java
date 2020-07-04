//有很多的匹配规则 e数字表示10的数字次方
/*几个非法情况：
    1.  .之前不能出现.和e
    2.  e之前不能有e，且e的前后必须是数字
    3.  + - 出现在第一位或者e后面
*/
// 100 100
class Solution {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0){
            return false;
        }

        //标记是否遇到相应情况
        boolean numSeen=false;
        boolean dotSeen=false;
        boolean eSeen=false;

        char[] str=s.trim().toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i]>='0'&&str[i]<='9'){
                numSeen=true;
            }else if(str[i]=='.'){  //.之前不能出现.或者e
                if(dotSeen||eSeen){
                    return false;
                }
                dotSeen=true;
            }else if(str[i]=='e'||str[i]=='E'){ //e之前不能出现e，必须出现数字
                if(eSeen||!numSeen){
                    return false;
                }
                eSeen=true;
                numSeen=false; //重置numSeen，因为e后面也还要有数字
            }else if(str[i]=='-'||str[i]=='+'){//+ - 出现在第一个位置，或者e/E后面第一个位置
                if(i!=0 && str[i-1]!='e'&&str[i-1]!='E'){
                    return false;
                }
            }else{ //其他非法情况
                return false;
            }
        }
        return numSeen;

    }
}