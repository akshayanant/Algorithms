package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/1/2019.
 *
 */
public class Atlassian {
    public static int maxDifference(List<Integer> nums) {

        int maxDiff = -1;
        for (int i = 0; i < nums.size()-1; i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if(nums.get(j)>=nums.get(i)){
                    int diff = nums.get(j)- nums.get(i);
                    if(diff>maxDiff){
                        maxDiff = diff;
                    }
                }
            }
        }
        return maxDiff;
    }

        int maxDiff(List<Integer> nums)
        {
            if(nums.size()<2){
                return -1;
            }
            int maxDiff = nums.get(1) - nums.get(0);
            int min = nums.get(0);
            for (int i = 1; i < nums.size(); i++){
                if (nums.get(i) - min > maxDiff){
                    maxDiff = nums.get(i) - min;
                }
                if (nums.get(i) < min){
                    min = nums.get(i);
                }
            }
            if(maxDiff<0){
                return -1;
            }
            return maxDiff;
        }

    public static long beautifulSubarrays(List<Integer> a, int m) {
        if(a.size()==0){
            return 0;
        }
        int beautCount = 0;
        for (int i = 0; i < a.size(); i++){
            int oddCount = 0;
            for (int j = i; j < a.size(); j++){
                if (a.get(j) % 2 ==1){
                    oddCount++;
                }
                if (oddCount == m){
                    beautCount++;
                }
            }
        }

        return beautCount;
    }

    int beauty(List<Integer> a, int m){
        int count = 0;
        int previous[] = new int[a.size()];
        int oddCount = 0;

        for (Integer anA : a) {
            previous[oddCount]++;

            if ((anA % 2 == 1)) {
                oddCount++;
            }
            if (oddCount >= m) {
                count += previous[oddCount - m];
            }
        }
        return count;
    }

    public static int minimumGroups(List<Integer> predators) {
        if(predators.size()==0){
            return 0;
        }
        List<Integer> core = new ArrayList<>();
        Map<Integer,List<Integer>> roots = new HashMap<>();
        for (int i = 0; i < predators.size(); i++) {
            if (predators.get(i) == -1) {
                core.add(i);
                if (!roots.containsKey(i)) {
                    roots.put(i, new ArrayList<>());
                }
            }
            else if (roots.containsKey(predators.get(i))) {
                roots.get(predators.get(i)).add(i);
            } else {
                roots.put(predators.get(i), new ArrayList<>());
                roots.get(predators.get(i)).add(i);
            }
        }
        int max = 0;
        for (int i = 0; i < core.size(); i++) {
            int count = maxHeight(roots,core.get(i),0);
            if(count>max){
                max = count;
            }
        }
        return max;
    }

    private static int maxHeight(Map<Integer,List<Integer>> roots,int root,int count){
        List<Integer> child = roots.get(root);
        if(child==null||child.size()==0){
            return count+1;
        }
        int max = 0;
        for (Integer aChild : child) {
            int c = maxHeight(roots, aChild, count + 1);
            if (c > max) {
                max = c;
            }
        }
        return max;
    }

    private static int connectedSum(List<List<Integer>> inputs, int n){
        int[] parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        for (List<Integer> input : inputs) {
            int j = input.get(0);
            while (parent[j] != j) {
                j = parent[j];
            }
            parent[input.get(1)] = j;
        }
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int aParent : parent) {
            if(aParent==0){
                continue;
            }
            if (countMap.containsKey(aParent)) {
                int count = countMap.remove(aParent);
                count++;
                countMap.put(aParent, count);
            } else {
                countMap.put(aParent, 1);
            }
        }
        int res = 0;
        for(Integer par :countMap.keySet()){
            res+=Math.ceil(Math.sqrt(countMap.get(par)));
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        input.add(list);
        list=new ArrayList<>();
        list.add(1);
        list.add(3);
        input.add(list);
        list=new ArrayList<>();
        list.add(2);
        list.add(4);
        input.add(list);
        list=new ArrayList<>();
        list.add(3);
        list.add(5);
        input.add(list);
        list=new ArrayList<>();
        list.add(7);
        list.add(8);
        input.add(list);
        System.out.println(Atlassian.connectedSum(input,10));
    }
}
