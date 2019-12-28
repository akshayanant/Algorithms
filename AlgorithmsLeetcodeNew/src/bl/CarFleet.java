package bl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Akshay Hegde on 10/9/2019.
 * 853. Car Fleet
 Medium

 301

 160

 Favorite

 Share
 N cars are going to the same destination along a one lane road.  The destination is target miles away.

 Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.

 A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

 The distance between these two cars is ignored - they are assumed to have the same position.

 A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.

 If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


 How many car fleets will arrive at the destination?



 Example 1:

 Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 Output: 3
 Explanation:
 The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 Note that no other cars meet these fleets before the destination, so the answer is 3.

 Note:

 0 <= N <= 10 ^ 4
 0 < target <= 10 ^ 6
 0 < speed[i] <= 10 ^ 6
 0 <= position[i] < target
 All initial positions are different.

 */
public class CarFleet {
    class Car{
        int start;
        int speed;
        double time;

        public Car(int start, int speed,int target) {
            this.start = start;
            this.speed = speed;
            time = (target-start)/1.0/speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==0){
            return 0;
        }
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i],speed[i],target);
        }
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.start-o1.start;
            }
        });
        int count =0;
        for (int i = 0; i < cars.length; i++) {
            int j = i+1;
            while (j<cars.length&&canCatch(cars[i],cars[j])){
                j++;
            }
            count++;
            i=j-1;
        }
        return count;
    }

    private boolean canCatch(Car carA, Car carB) {
        return carA.time >= carB.time || carB.start > carA.start;
    }

    public static void main(String[] args) {
        System.out.println(new CarFleet().carFleet(10,new int[]{6,8},new int[]{3,2}));
    }
}
