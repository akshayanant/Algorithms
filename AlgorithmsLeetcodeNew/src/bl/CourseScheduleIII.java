package bl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Akshay Hegde on 9/3/2019.
 *
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.

 Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.

 Example:

 Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 Output: 3
 Explanation:
 There're totally 4 courses, but you can take 3 courses at most:
 First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
 Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.


 Note:

 The integer 1 <= d, t, n <= 10,000.
 You can't take two courses simultaneously.

 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]){
                    return -1;
                }
                if(o1[1]>o2[1]){
                    return 1;
                }
                return 0;
            }
        });
        int total =0;
        for (int i = 0; i < courses.length; i++) {
            total+=courses[i][1];
        }
        return dp(courses,total);
//        int daysPassed =0;
//        int count =0;
//        for (int[] course : courses) {
//            if (daysPassed + course[0] <= course[1]) {
//                count++;
//                daysPassed += course[0];
//            }
//        }
//        return count;
        //return recursion(courses,0,0);
    }

//    private int recursion(int[][] courses,int index, int daysPassed){
//        if(index==courses.length-1){
//            if(courses[index][1]>=daysPassed+courses[index][0]){
//                return 1;
//            }
//            return 0;
//        }
//        if(courses[index][1]<daysPassed+courses[index][0]){
//            return recursion(courses,index+1,daysPassed);
//        }
//        return Math.max(recursion(courses,index+1,daysPassed),
//                1+recursion(courses,index+1,daysPassed+courses[index][0]));
//    }
    private int dp(int[][] courses,int total){
        int[][] dp = new int[courses.length][total+1];
        for (int i = 0; i <= total; i++) {
            dp[courses.length-1][i] = courses[courses.length-1][1]>=i+courses[courses.length-1][0]?
                    1:0;
        }

        for (int i = courses.length-2; i > -1; i--) {
            for (int j = 0; j <=total; j++) {
                if(courses[i][1]<j+courses[i][0]){
                    dp[i][j] = dp[i+1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],1+dp[i+1][j+courses[i][0]]);
                }
            }
        }
        return dp[0][0];
    }

    private int iter(int[][] courses){
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]){
                    return -1;
                }
                if(o1[1]>o2[1]){
                    return 1;
                }
                return 0;
            }
        });
        int count=0;
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                count++;
                queue.add(course[0]);
            } else if (!queue.isEmpty()&&queue.peek()>course[0]) {
                time-=queue.remove();
                queue.add(course[0]);
                time+=course[0];
            }
        }
        return count;
    }


    }
