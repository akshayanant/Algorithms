package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 4/18/2020.
 */
public class LCContest185 {
    public String reformat(String s) {
        LinkedList<Character> letters = new LinkedList<>();
        LinkedList<Character> digits = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                digits.add(ch);
            }
            else{
                letters.add(ch);
            }
        }
        if(Math.abs(letters.size()-digits.size())>1){
            return "";
        }
        boolean flag = letters.size()>digits.size();
        StringBuilder sb = new StringBuilder();
        while (!letters.isEmpty()&&!digits.isEmpty()){
            if(flag){
                sb.append(letters.poll());
            }
            else{
                sb.append(digits.poll());
            }
            flag = !flag;
        }
        if(!letters.isEmpty()){
            sb.append(letters.poll());
        }
        if(!digits.isEmpty()){
            sb.append(digits.poll());
        }
        return sb.toString();
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String,Map<String,Integer>> map = new HashMap<>();
        Set<String> tables = new HashSet<>();
        Set<String> foods = new HashSet<>();
        for(List<String> order : orders){
            tables.add(order.get(1));
            Map<String,Integer> food = map.getOrDefault(order.get(1),new HashMap<>());
            foods.add(order.get(2));
            food.put(order.get(2),food.getOrDefault(order.get(2),0)+1);
            map.put(order.get(1),food);
        }
        List<String> tablesList = new ArrayList<>();
        tablesList.addAll(tables);
        Collections.sort(tablesList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });
        List<String> foodList = new ArrayList<>();
        foodList.addAll(foods);
        Collections.sort(foodList);
        List<List<String>> res = new ArrayList<>();
        List<String> row = new ArrayList<>();
        row.add("Table");
        row.addAll(foodList);
        res.add(row);
        for(String table : tablesList){
            Map<String,Integer> foodMap = map.get(table);
            row = new ArrayList<>();
            row.add(table);
            for(String food:foodList){
                String val = String.valueOf(foodMap.getOrDefault(food,0));
                row.add(val);
            }
            res.add(row);
        }
        return res;

    }


    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character,Character> map = new HashMap<>();
        map.put('c','k');
        map.put('r','c');
        map.put('o','r');
        map.put('a','o');
        map.put('k','a');
        Map<Character,Integer> countMap = new HashMap<>();
        int res= 0;
        int n = croakOfFrogs.length();
        for (int i = 0; i < n; i++) {
            char ch = croakOfFrogs.charAt(i);
            if(ch=='c'){
                if(countMap.getOrDefault('k',0)>0){
                    countMap.put(ch,countMap.getOrDefault(ch,0)+1);
                    countMap.put('k',countMap.get('k')-1);
                }
                else{
                    countMap.put('c',countMap.getOrDefault('c',0)+1);
                    res++;
                }
                continue;
            }
            char prev = map.get(ch);
            if(!countMap.containsKey(prev)){
                return -1;
            }
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
            countMap.put(prev,countMap.get(prev)-1);
        }
        for(char ch:countMap.keySet()){
            if(ch!='k'&&countMap.getOrDefault(ch,0)!=0){
                return -1;
            }
        }
        return res;
    }



}
