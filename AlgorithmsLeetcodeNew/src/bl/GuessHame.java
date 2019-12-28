///**
// * Created by Akshay Hegde on 10/6/2019.
// * We are playing the Guess Game. The game is as follows:
//
// I pick a number from 1 to n. You have to guess which number I picked.
//
// Every time you guess wrong, I'll tell you whether the number is higher or lower.
//
// You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
//
// -1 : My number is lower
// 1 : My number is higher
// 0 : Congrats! You got it!
// Example :
//
// Input: n = 10, pick = 6
// Output: 6
//
// */
//public class GuessHame {
//    public int guessNumber(int n) {
//        return rec(n,1,n);
//    }
//
//    private int rec(int num){
//        int l=1;
//        int h=num;
//        while (l<h) {
//            int mid1 = l+(l + h) / 3;
//            int mid2 = h-(l+h)/3;
//            int res1 = guess(mid1);
//            if (res1 == 0) {
//                return mid1;
//            }
//            int res2 = guess(mid2);
//            if(res2==0){
//                return mid2;
//            }
//            if(res1==-1){
//                h = mid1-1;
//            }
//            else if(res2==1){
//                l=mid2+1;
//            }
//            else if(res2==-1){
//                h=mid2-1;
//            }
//            else if(res1==1){
//                l=mid1+1;
//            }
//        }
//        return -1;
//    }
//
//    //dummy
//    private int guess(int num){
//        return 1;
//    }
//}
