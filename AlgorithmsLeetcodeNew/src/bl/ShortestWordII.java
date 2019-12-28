package bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Akshay Hegde on 10/24/2019.
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.

 Example:
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Input: word1 = “coding”, word2 = “practice”
 Output: 3
 Input: word1 = "makes", word2 = "coding"
 Output: 1
 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 */
public class ShortestWordII {
    public int distance(List<String> words, String word1,String word2){
        Map<String,List<Integer>> wordMap = new HashMap<>();
        for(int i=0;i<words.size();i++){
            if(!wordMap.containsKey(words.get(i))){
                wordMap.put(words.get(i),new ArrayList<>());
            }
            wordMap.get(words.get(i)).add(i);
        }
        List<Integer> index1=wordMap.get(word1);
        List<Integer> index2=wordMap.get(word2);
        int i=0;
        int j=0;
        int min  = Integer.MAX_VALUE;
        while (i<index1.size()&&j<index2.size()){
            int m = index1.get(i);
            int n = index2.get(j);
            if(m==n){
                return min;
            }
            int diff =Math.abs(m-n);
            min = Math.min(min,diff);
            if(m<n){
                i++;
            }
            else{
                j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("lsdkf");
        words.add("sldke");
        words.add("nknero");
        words.add("lsdkf");
        words.add("sldke");
        words.add("sldke");
        System.out.println(new ShortestWordII().distance(words,"nknero","lsdkf"));
    }
}
