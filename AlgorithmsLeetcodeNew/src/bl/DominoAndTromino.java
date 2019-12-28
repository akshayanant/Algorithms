///**
// * Created by Akshay Hegde on 10/8/2019.
// * 790. Domino and Tromino Tiling
// Medium
//
// 278
//
// 144
//
// Favorite
//
// Share
// We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.
//
// XX  <- domino
//
// XX  <- "L" tromino
// X
// Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
//
// (In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)
//
// Example:
// Input: 3
// Output: 5
// Explanation:
// The five different ways are listed below, different letters indicates different tiles:
// XYZ XXZ XYY XXY XYY
// XYZ YYZ XZZ XYY XXY
// Note:
//
// N  will be in range [1, 1000].
//
//
// Accepted
// 10,054
// Submissions
// 27,125
// Seen this question in a real interview before?
//
// Yes
//
// No
// Contributor
// awice
//
// Problems
//
// Pick One
//
// Prev
// 790/1220
//
// Next
//
//
//
//
//
//
// 1
// class Solution {
// 2
// public int numTilings(int N) {
// 3
//
// 4
// }
// 5
// }
// Console
// Contribute
//
// Run Code
//
//
//
// */
//public class DominoAndTromino {
//    public int numTilings(int N) {
//        boolean[][] visit = new boolean[2][N];
//        return rec(N,N,N,visit);
//    }
//
//    private int rec(int N,int top, int bot,boolean[][] visit){
//        if(top<0||bot<0||visit[top][bot]){
//            return 0;
//        }
//        if (top==0&&bot==0){
//            return 1;
//        }
//        visit[top][bot] = true;
//        if(top==bot){
//            return rec(N,top-1,bot-1,visit)+rec(N,top-2,bot-2,visit)+
//                    rec(N,top-1,bot-2,visit)+rec(N,top-2,bot-1,visit);
//        }
//        if(top-bot==1){
//            return rec(N,top-2,bot-2,visit)+ rec(N,top-2,bot-1,visit)+rec(N,top-2,bot,visit)+rec(N,top,bot-2,visit);
//        }
//        if(bot-top==1){
//            return rec(N,top-2,bot-2,visit)+ rec(N,top-1,bot-2,visit)+rec(N,top-2,bot,visit)+rec(N,top,bot-2,visit);
//        }
//        return rec(N,top-2,bot-2,visit)+rec(N,top-2,bot,visit)+rec(N,top,bot-2,visit);
//    }
//}
