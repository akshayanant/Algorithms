package bl;

/**
 * Created by Akshay Hegde on 9/7/2019.
 *
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

 The bus goes along both directions i.e. clockwise and counterclockwise.

 Return the shortest distance between the given start and destination stops.

 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(distance.length<2){
            return 0;
        }
        int clock = 0;
        for (int i = start; i != destination;) {
            clock+=distance[i];
            i=(i+1)%distance.length;
        }
        int antiClock = 0;
        for (int i = destination; i !=start; ) {
            antiClock+=distance[i];
            i=(i+1)%distance.length;
        }
        return Math.min(clock,antiClock);
    }
}
