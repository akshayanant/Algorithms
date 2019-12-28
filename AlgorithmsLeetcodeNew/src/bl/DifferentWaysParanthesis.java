//import java.util.List;
//
///**
// * Created by Akshay Hegde on 9/4/2019.
// *
// * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
//
// Example 1:
//
// Input: "2-1-1"
// Output: [0, 2]
// Explanation:
// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Example 2:
//
// Input: "2*3-4*5"
// Output: [-34, -14, -10, -10, 10]
// Explanation:
// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
//
// */
//public class DifferentWaysParanthesis {
//    public List<Integer> diffWaysToCompute(String input) {
//
//    }
//
//    private int recursion(int[] numbers,char[] ops, int numIndex,int opIndex, List<Integer> res){
//        if(numIndex==numbers.length-1){
//            return numbers[numIndex];
//        }
//
//    }
//
//    private int compute(int a,int b, char op){
//        if(op=='+'){
//            return a+b;
//        }
//        if(op=='-'){
//            return a-b;
//        }
//        return a*b;
//    }
//}
