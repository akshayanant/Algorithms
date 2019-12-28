///**
// * Created by Akshay Hegde on 6/25/2019.
// *
// * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
//
// Example 1:
//
// Input: [[1,1],[2,2],[3,3]]
// Output: 3
// Explanation:
// ^
// |
// |        o
// |     o
// |  o
// +------------->
// 0  1  2  3  4
// Example 2:
//
// Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
// Output: 4
// Explanation:
// ^
// |
// |  o
// |     o        o
// |        o
// |  o        o
// +------------------->
// 0  1  2  3  4  5  6
//
//
// */
//public class MaxPointsOnALine {
//    public int maxPoints(int[][] points) {
//        if (points.length<3){
//            return points.length;
//        }
//        int maxCount =2;
//        for (int i = 0; i < points.length - 1; i++) {
//            for (int j = i+1; j < points.length; j++) {
//                boolean hor = false;
//                boolean ver = false;
//                int slope = 1;
//                int count =2;
//                if(points[i][0]==points[j][0]&&points[i][1]==points[j][1]){
//                    count++;
//                }
//                if(points[i][0]==points[j][0]){
//                    ver = true;
//                }
//                else if(points[i][1]==points[j][1]){
//                    hor = true;
//                }
//                else {
//                    slope = (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
//                }
//                for (int k = j+1; k < points.length; k++) {
//                    if(points[j][0]==points[k][0]&&points[j][1]==points[k][1]){
//                        count++;
//                        continue;
//                    }
//                    if(hor){
//                        if(points[k][1]==points[j][1]){
//                            count++;
//                        }
//                    }
//                    else if(ver){
//                        if(points[k][0]==points[j][0]){
//                            count++;
//                        }
//                    }
//                    else {
//                        if ((points[k][1] - points[j][1]) / (points[k][0] - points[j][0]) % slope == 0) {
//                            count++;
//                        }
//                    }
//                }
//                if(count>maxCount){
//                    maxCount = count;
//                }
//            }
//        }
//        return maxCount;
//    }
//
//    private int maxPointsRec(int[][] points, int start,int slope,boolean begin){
//        if(start>=points.length){
//            return 0;
//        }
//        if(begin){
//            return
//        }
//        if(((points[start][1]-points[start-1][1])/(points[start][0]-points[start-1][0]))%slope==0){
//            return Math.max(1+maxPointsRec(points,start+1,slope,false),
//                    maxPointsRec(points,start+2,-1,true));
//        }
//    }
//}
