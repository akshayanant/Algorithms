package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 11/9/2019.
 */
public class Lytx{
        public static int reduceCapacity(List<Integer> model) {
            int n = model.size();
            int ceil = (n%2==0)?n/2:(n/2)+1;
            Map<Integer,Integer> countMap = new HashMap<>();
            for (Integer aModel : model) {
                countMap.put(aModel, countMap.getOrDefault(aModel, 0) + 1);
            }
            List<Integer> counts = new ArrayList<>();
            counts.addAll(countMap.values());
            counts.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            int deactCount = 0;
            int res = 0;
            for (Integer count : counts) {
                res++;
                deactCount += count;
                if (deactCount >= ceil) {
                    return res;
                }
            }
            return res;
        }

    public static List<Integer> fibonacci(int n) {
        List<Integer> fib = new ArrayList<>();
        fib.add(0);
        if(n==1){
            return fib;
        }
        fib.add(1);
        for (int i = 2; i < n; i++) {
            fib.add(fib.get(i-1)+fib.get(i-2));
        }
        return fib;
    }
}
