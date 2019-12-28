package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Akshay Hegde on 3/24/2019.
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:

 The solution set must not contain duplicate quadruplets.

 Example:

 Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class SumOfFour {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        if (nums.length < 4) {
            return sol;
        }
        ArrayList<Integer> num = new ArrayList<>(nums.length);
        for (int num1 : nums) {
            num.add(num1);
        }
        Collections.sort(num);
        int prevNum = num.get(0);
        for (int i = 0; i < num.size() - 3; i++) {
            if (i != 0 && num.get(i) == prevNum) {
                continue;
            }
            prevNum = num.get(i);
            int l = i + 1;
            int r = num.size() - 1;
            int m = l + 1;
            while (l < r) {
                boolean large = false;
                boolean match = false;
                while (l < m && m < r) {
                    if (num.get(l) + num.get(r) + num.get(m) + num.get(i) == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num.get(i));
                        list.add(num.get(l));
                        list.add(num.get(m));
                        list.add(num.get(r));
                        sol.add(list);
                        match = true;
                    } else if (num.get(l) + num.get(r) + num.get(m) + num.get(i) > target) {
                        large = true;
                        break;
                    }
                    int prevM = num.get(m);
                    m++;
                    while (m < r && num.get(m) == prevM) {
                        m++;
                    }
                }
                if(match){
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
                    m=l+1;
                }
                else if(large){
                    r--;
                }
                else{
                    l++;
                    m=l+1;
                }
                if(r<=m){
                    break;
                }
            }
        }

        return sol;
    }
}
