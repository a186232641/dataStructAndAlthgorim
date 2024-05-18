package Althgorim.First.ArrayAlthgorim;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class reverse {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s ="hello".toCharArray();
        solution.reverseString(s);
    }
}
class Solution {
    public void reverseString(char[] s) {
        int j = s.length-1;
        f(s,0,j);
    }
    void f(char[] s,int i,int j ){
        if(i==j){
            s[j-i] = s[i];
            return;
        }
        char c = s[i];
        f(s,i+1,j);
        s[j-i] =c;
    }
}