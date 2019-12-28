package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 3/23/2019.
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class SumOfThree {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        if(nums.length<3){
            return sol;
        }
        ArrayList<Integer> num = new ArrayList<>(nums.length);
        for (int num1 : nums) {
            num.add(num1);
        }
        Collections.sort(num);
        int prevNum =num.get(1);
        for (int i = 0; i <num.size()-2 ; i++) {
            if(i!=0&&num.get(i)==prevNum){
                continue;
            }
            prevNum = num.get(i);
            int l= i+1;
            int r= num.size()-1;
            while(l<r) {
                    if (num.get(l) + num.get(r) + num.get(i) == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num.get(l));
                        list.add(num.get(i));
                        list.add(num.get(r));
                        sol.add(list);
                        int prevL=num.get(l);
                        int prevR = num.get(r);
                        l++;
                        r--;
                        while(l<num.size()&&num.get(l)==prevL){
                            l++;
                        }
                        while(r>l&&num.get(r)==prevR){
                            r--;
                        }
                    }
                    else{
                        if(num.get(l) + num.get(r) + num.get(i) < 0){
                            l++;
                        }
                        else{
                            r--;
                        }
                    }
                }
        }

        return sol;
    }
}
