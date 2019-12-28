package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/26/2019.
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 Example 1:

 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2

 For a given n, a gray code sequence may not be uniquely defined.
 For example, [0,2,3,1] is also a valid gray code sequence.

 00 - 0
 10 - 2
 11 - 3
 01 - 1
 Example 2:

 Input: 0
 Output: [0]
 Explanation: We define the gray code sequence to begin with 0.
 A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 Therefore, for n = 0 the gray code sequence is [0].


 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n==0){
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        if(n==1) {
            return res;
        }
        res.clear();
        List<String> original = new ArrayList<>();
        original.add("0");
        original.add("1");
        for (int i = 2; i <=n ; i++) {
            List<String> rev = reverseList(original);
            append(original,'0');
            append(rev,'1');
            original.addAll(rev);
        }
        for (String anOriginal : original) {
            res.add(toInt(anOriginal));
        }

        return res;
    }

    private List<String> reverseList(List<String> original){
        List<String> rev = new ArrayList<>(original.size());
        for (String anOriginal : original) {
            rev.add(0, anOriginal);
        }
        return rev;
    }

    private void append(List<String> input, char ch){
        for (int i = 0; i < input.size(); i++) {
            String st = input.remove(i);
            String append = ch+st;
            input.add(i,append);
        }
    }

    private int toInt(String binary){
        int intVal =0;
        int count = 1;
        for (int i = binary.length()-1; i >-1 ; i--) {
            intVal = count*(binary.charAt(i)-48)+intVal;
            count*=2;
        }
        return intVal;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2));
    }
}
