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

    public static void main(String[] args) {
        System.out.println(Roblox.consecutive(200));
    }
}
