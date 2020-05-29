package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 10/8/2019.
 */
public class Roblox {
    public static String breakPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='a'){
                if(nonA(s,i+1)) {
                    return s.substring(0, i) + 'a' + s.substring(i + 1);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static boolean nonA(String s,int i){
        for (int j = i; j < s.length(); j++) {
            if(s.charAt(j)!='a'){
                return true;
            }
        }
        return false;
    }

    public static int segment(int x, List<Integer> arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < x&&i<arr.size(); i++) {
            queue.add(arr.get(i));
        }
        int max = queue.peek();
        int index =0;
        while (x<arr.size()){
            int min = queue.peek();
            if(min>max){
                max = min;
            }
            queue.remove(arr.get(index++));
            queue.add(arr.get(x));
            x++;
        }
        if(queue.peek()>max){
            max = queue.peek();
        }
        return max;
    }

    public static int consecutive(long num) {
        while ((num & 1) == 0){
            num >>= 1;
        }
        int count = 1;
        int slide = 3;
        while (slide * slide <= num) {
            int consCount = 0;
            while (num % slide == 0) {
                num /= slide;
                consCount++;
            }
            count *= consCount + 1;
            slide += 2;
        }
        if (num > 1){
            count <<= 1;
        }
        return count-1;
    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        Collections.sort(stocksProfit);
        int left = 0;
        int right = stocksProfit.size()-1;
        int count = 0;
        while(left<right){
            long sum = stocksProfit.get(left)+stocksProfit.get(right);
            if(sum==target) {
                count++;
                int oldLeft = left;
                int oldRight = right;
                left++;
                right--;
                while (left < right && Objects.equals(stocksProfit.get(left), stocksProfit.get(oldLeft))) {
                    left++;
                }
                while (right > left && Objects.equals(stocksProfit.get(right), stocksProfit.get(oldRight))) {
                    right--;
                }
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return count;
    }

    public static void socialGraphs(List<Integer> counts) {
        // Write your code here
        int n =counts.size();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<Integer> list = map.getOrDefault(counts.get(i),new ArrayList<>());
            list.add(i);
            map.put(counts.get(i),list);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            int count = counts.get(list.get(0));
            for (int i = 0; i < list.size();) {
                List<Integer> group = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    group.add(list.get(i+j));
                }
                i+=count;
                res.add(group);
            }
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("");
        }
    }



    public static void main(String[] args) {
        System.out.println(Roblox.consecutive(200));
    }
}
