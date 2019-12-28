package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 10/13/2019.
 * 18. 4Sum
 Medium

 1287

 258

 Favorite

 Share
 Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

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
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        rec(nums,0,target,res,new ArrayList<>(),4);
        return res;
    }

    private List<List<Integer>> usingMap(int[] nums, int target){
        Map<Integer,List<List<Integer>>> pairs = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i]+nums[j];
                int rem = target-sum;
                List<List<Integer>> allPairs = pairs.get(rem);
                if(allPairs!=null){
                    for(List<Integer> pair:allPairs){
                        if(different(i,j,pair)){
                            List<Integer> comb = new ArrayList<>();
                            comb.add(nums[i]);
                            comb.add(nums[j]);
                            comb.add(nums[pair.get(0)]);
                            comb.add(nums[pair.get(1)]);
                            res.add(comb);
                        }
                    }
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                List<List<Integer>> prev = pairs.getOrDefault(sum,new ArrayList<>());
                prev.add(pair);
                pairs.put(sum,prev);
            }
        }
        return res;
    }

    private boolean different(int i, int j, List<Integer> pair){
        int a = pair.get(0);
        int b = pair.get(1);
        return !(a == i || a == j || b == i || b == j);
    }

    private void rec(int[] nums, int index, int target, List<List<Integer>> res,List<Integer> list,
                     int rem) {
        if (rem == 0) {
            if (target==0){
                res.add(list);
            }
            return;
        }
        if(index==nums.length){
            return;
        }
        if(target<0&&nums[index]>0){
            return;
        }
        List<Integer> copy = new ArrayList<>();
        copy.addAll(list);
        copy.add(nums[index]);
        rec(nums,index+1,target-nums[index],res,copy,rem-1);
        int j = index+1;
        while (j<nums.length&&nums[j]==nums[index]){
            j++;
        }
        rec(nums,j,target,res,list,rem);
    }

    private List<List<Integer>> usingPointer(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        int prevI = nums[0]+1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==prevI){
                continue;
            }
            prevI = nums[i];
            int prevJ = nums[i+1]+1;
            for (int j = i+1; j < nums.length; j++) {
                if(prevJ==nums[j]){
                    continue;
                }
                prevJ = nums[j];
                int l=j+1;
                int r = nums.length-1;
                while (l<r){
                    if(nums[i]+nums[j]+nums[l]+nums[r]==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        int prevL = nums[l];
                        while (l<r&&prevL==nums[l]){
                            l++;
                        }
                        int prevR = nums[r];
                        while (r>l&&nums[r]==prevR){
                            r--;
                        }
                    }
                    else if(nums[i]+nums[j]+nums[l]+nums[r]>target){
                        int prevR = nums[r];
                        while (r>l&&nums[r]==prevR){
                            r--;
                        }
                    }
                    else{
                        int prevL = nums[l];
                        while (r>l&&nums[l]==prevL){
                            l++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-3,-2,-1,0,0,1,2,3};
        int target = 0;
        System.out.println(new FourSum().usingPointer(input,target));
    }
}
