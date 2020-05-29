package bl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Akshay Hegde on 3/28/2020.
 */
public class LCContest182 {

    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int res = -1;
        for(int a:map.keySet()){
            if(a==map.get(a)){
                res = Math.max(res,a);
            }
        }
        return res;
    }

    public int numTeams(int[] rating) {
        int count = 0;
        int n = rating.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(rating[i]<rating[j]&& rating[j]<rating[k]){
                        count++;
                    }
                    else if(rating[i]>rating[j]&&rating[j]>rating[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

     class UndergroundSystem {
        class Boarding {
            String station;
            int time;
            int id;

            public Boarding(String name, int time, int id) {
                this.station = name;
                this.time = time;
                this.id = id;
            }
        }
        class Count{
            int i;
            int tot;

            public Count(int i, int tot) {
                this.i = i;
                this.tot = tot;
            }

            public double getAvgTime(){
                return tot/1.0/i;
            }
        }

        Map<Integer, Boarding> map;
        Map<String,Count> avgTimes;
        public UndergroundSystem() {
             map= new HashMap<>();
             avgTimes= new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            map.put(id,new Boarding(stationName,t,id));
        }

        public void checkOut(int id, String stationName, int t) {
            Boarding boarding = map.remove(id);
            String avgTime = boarding.station + " "+stationName;
            if(avgTimes.containsKey(avgTime)){
                Count count = avgTimes.get(avgTime);
                count.tot+=(t-boarding.time);
                count.i++;
                avgTimes.put(avgTime,count);
            }
            else{
                avgTimes.put(avgTime,new Count(1,(t-boarding.time)));
            }

        }

        public double getAverageTime(String startStation, String endStation) {
            String avgTime = startStation+" " + endStation;
            return avgTimes.get(avgTime).getAvgTime();
        }
    }


}
