package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/10/2019.
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int candidate : candidates) {
            list.add(candidate);
        }
        Collections.sort(list);
        //removeRepeat(list);
        for (int i = 0; i < list.size(); i++) {
            candidates[i] = list.get(i);
        }
        return recusrion(candidates,0,target,new ArrayList<>());
    }

    private List<List<Integer>> recusrion(int[] candidates, int start, int target,List<Integer> curList){
        if(start>candidates.length-1){
            return new ArrayList<>();
        }
        if(target-candidates[start]==0){
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> inner = new ArrayList<>();
            inner.addAll(curList);
            inner.add(candidates[start]);
            list.add(inner);
            return list;
        }
        if(target-candidates[start]>0){
            List<Integer> newList = new ArrayList<>();
            newList.addAll(curList);
            newList.add(candidates[start]);
            List<List<Integer>> incl = recusrion(candidates, start, target-candidates[start],newList);

            List<List<Integer>> excl = recusrion(candidates, start+1, target-candidates[start],newList);
            incl =  resolveLists(incl,excl);
            excl = recusrion(candidates, start+1, target, curList);
            return resolveLists(incl,excl);
        }
        return new ArrayList<>();
    }


    //Each number in candidates may only be used once in the combination.

    private List<List<Integer>> recusrionNoRepeat(int[] candidates, int start, int target,List<Integer> curList){
        if(start>candidates.length-1){
            return new ArrayList<>();
        }
        if(target-candidates[start]==0){
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> inner = new ArrayList<>();
            inner.addAll(curList);
            inner.add(candidates[start]);
            list.add(inner);
            return list;
        }
        if(target-candidates[start]>0){
            List<Integer> newList = new ArrayList<>();
            newList.addAll(curList);
            newList.add(candidates[start]);
            List<List<Integer>> incl = recusrionNoRepeat(candidates, start+1,target-candidates[start],newList);
            int curItem = candidates[start++];
            while(start<candidates.length&&candidates[start]==curItem){
                start++;
            }
            List<List<Integer>> excl = recusrionNoRepeat (candidates, start,target ,curList);
            return resolveLists(incl,excl);
        }
        return new ArrayList<>();
    }

    private List<List<Integer>> resolveLists(List<List<Integer>> a, List<List<Integer>> b){
        List<List<Integer>> res = new ArrayList<>();
        if(a!=null) {
            for (List<Integer> anA : a) {
                if (anA != null) {
                    res.add(anA);
                }
            }
        }
        if(b!=null) {
            for (List<Integer> aB : b) {
                if (aB != null) {
                    res.add(aB);
                }
            }
        }
        return res;
    }

//    private void removeRepeat(ArrayList<Integer> input){
//        for (int i = 0; i < input.size(); i++) {
//            int cur = input.get(i++);
//            while(i<input.size()&&input.get(i)==cur){
//                input.remove(i);
//            }
//            i--;
//        }
//    }

    public static void main(String[] args) {
       int[] input = new int[]{1,2,3,4};
        System.out.println(new CombinationSum().combinationSum(input,20));
    }
}
