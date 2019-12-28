package bl;

/**
 * Created by Akshay Hegde on 10/20/2019.
 * There are three types of edits that can be performed on strings: insert a character,
 remove a character, or replace a character. Given two strings, write a function to check if they are
 one edit (or zero edits) away.
 EXAMPLE
 pale, ple -> true
 pales, pale -> true
 pale, bale -> true
 pale, bae -> false

 */
public class OneAway {
    private boolean solution(String s,String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(Math.abs(sLen-tLen)>1){
            return false;
        }
        if(sLen==tLen){
            return oneReplaceAway(s,t,1);
        }
        if(sLen>tLen){
            return oneInsertAway(s,t);
        }
        return oneInsertAway(t,s);
    }

    private boolean rec(String s,String t, int sIndex,int tIndex,int rem){
        if(rem<0){
            return false;
        }
        if(sIndex<0&&tIndex<0){
            return true;
        }
        if(sIndex<0||tIndex<0){
            return rem > 0;
        }

        if(s.charAt(sIndex)==t.charAt(tIndex)){
            return rec(s,t,sIndex-1,tIndex-1,rem);
        }
        return rec(s,t,sIndex-1,tIndex,rem-1)||
                rec(s,t,sIndex-1,tIndex-1,rem-1)||
                rec(s,t,sIndex, tIndex-1,rem-1);
    }

    private boolean oneReplaceAway(String s,String t,int rem){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)){
                rem--;
                if(rem<0){
                    return false;
                }
            }
        }
        return true;
    }


    private boolean oneInsertAway(String s, String t){
    // s is longer String
        for (int i = 0; i < t.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)){
                //inserted a character into t, compare remaining String with zero replacement
                return oneReplaceAway(s.substring(i+1),t.substring(i),0);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "bale";
        String t = "bae";
        System.out.println(new OneAway().solution(s,t));
    }

}
