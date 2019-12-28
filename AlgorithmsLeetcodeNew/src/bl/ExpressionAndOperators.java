package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 11/10/2019.
 */
public class ExpressionAndOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        rec(num,0,0,0,0,res,"",target);
        return res;
    }

    private void rec(String s, int index,int curNum,int prevNum,int val,List<String> res,String exp,int target){
        if(index==s.length()){
            if(val==target&&curNum==0){
                res.add(exp.substring(1));
            }
            return;
        }
        int n = s.charAt(index)-'0';
        curNum = curNum*10+n;
        if(curNum>0){
            rec(s,index+1,curNum,prevNum,val,res,exp,target);
        }
        rec(s,index+1,0,curNum,val+curNum,res,exp+"+"+curNum,target);
        if(exp.length()>0){
            rec(s,index+1,0,-curNum,val-curNum,res,exp+"-"+curNum,target);
            rec(s,index+1,0,prevNum*curNum,val-prevNum+(prevNum*curNum),res,exp+"*"+curNum,target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ExpressionAndOperators().addOperators("123",24));
    }
}