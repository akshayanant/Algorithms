package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 11/24/2019.
 */
public class InvalidTransaction {
    class Transaction{
        String name;
        int time;
        int amount;
        String city;
        boolean invalid;
        public Transaction(String name,String time,String amount,String city){
            this.name = name;
            this.time = Integer.parseInt(time);
            this.amount = Integer.parseInt(amount);
            this.city = city;
        }

        @Override
        public String toString() {
            return name+","+time+","+amount+","+city;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        Map<String,List<Transaction>> trans = new HashMap<>();
        for(String t:transactions){
            StringTokenizer st = new StringTokenizer(t,",");
            Transaction tran = new Transaction(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
            List<Transaction> list = trans.getOrDefault(tran.name,new ArrayList<>());
            list.add(tran);
            trans.put(tran.name,list);
        }
        List<String> res = new ArrayList<>();
        for(String s:trans.keySet()){
            List<Transaction> list = trans.get(s);
            Collections.sort(list, new Comparator<Transaction>() {
                @Override
                public int compare(Transaction o1, Transaction o2) {
                    return o1.time-o2.time;
                }
            });
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).amount>1000){
                    list.get(i).invalid = true;
                }
                for(int j = i+1;j<list.size();j++){
                    if(list.get(i).time+60>=list.get(j).time){
                        if(!list.get(i).city.equals(list.get(j).city)){
                            list.get(i).invalid = true;
                            list.get(j).invalid=true;
                        }
                    }
                    else{
                        break;
                    }
                }
                if(list.get(i).invalid){
                   res.add(list.get(i).toString());
                }
            }
        }
        return res;
    }
}
