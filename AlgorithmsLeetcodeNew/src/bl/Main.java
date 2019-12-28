package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static int finalMaxLen = 1;


    public static void main(String[] args) {
        //Longest Increasing SubSequence
//        System.out.println("Hello World!");
        Integer[] a = {8,15,3,7};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
        System.out.println(optimalStrat(list,0,list.size()-1));
//        longestIncreasingSequence(list, a.length);
//        System.out.println(finalMaxLen);


        //Longest Common Subsequence
//        String s1 ="aebfcgdhefgh";
//        String s2 ="efgh";
//        System.out.println(longestCommonSubSequenceLen(s1,s2,s1.length(),s2.length()));
//        System.out.println(lcsDP(s1,s2));
//        System.out.println(editDistance(s1,s2));

        //Max Partition
//        int[] a = {101,101,102,102,103,104,0};
//        System.out.println(maxPartition(a,a.length-1,arraySum(a),0));
//        System.out.println(maxPartitionDP(a));s a number could be covered using 1, 2 , 3


        //Count number of way
//        System.out.println(numberOfWays(8));
//        System.out.println(numberOfWaysDP(8));
//        String s = "1212121212";
//        System.out.println(numDecodings(s));

//        Num finalNum = new Num();
//        Integer[] a = {1,2,3,4};
//
//        longestIncreasingSequence(Arrays.asList(a), a.length, finalNum);
//        System.out.println(finalNum.a);

//        System.out.println(anytwo("QcxJOfXJbd"));
    }

    private static int longestIncreasingSequence(List<Integer> a, int len, Num finalMax) {
        int maxLen = 1;
        if (len == 1) {
            return 1;
        }
        for (int i = 1; i < len; i++) {
            int curLen = longestIncreasingSequence(a, i, finalMax);
            if (a.get(len - 1) > a.get(i - 1) && curLen + 1 > maxLen)
                maxLen = curLen + 1;
        }
        longestDecreasingSequece(a, len-1, maxLen, finalMax);
        return maxLen;
    }

    private static int longestDecreasingSequece(List<Integer> a, int startIndex, int increasingLen, Num finalMax) {
        if (startIndex == a.size()-1) {
            return 0;
        }
        int maxLen = 0;
        for (int i = startIndex + 1; i < a.size(); i++) {
            int cuLen = longestDecreasingSequece(a, i, increasingLen, finalMax);
            if (a.get(i) < a.get(startIndex) && cuLen+1 > maxLen) {
                maxLen++;
                if (maxLen + increasingLen > finalMax.a) {
                    finalMax.a = maxLen + increasingLen;
                }
            }
        }
        return maxLen;
    }

//
//    Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.
//
//            **Example: **
//
//    For the given array [1 11 2 10 4 5 2 1]
//
//    Longest subsequence is [1 2 10 4 2 1]
//
//    Return value 6

    private int longestIncreaseDecreaseDP(List<Integer> A){
        int[] increase = new int[A.size()];
        int[] decrease = new int[A.size()];
        int[] res = new int[A.size()];

        for (int i = 0; i < A.size(); i++) {
            increase[i] = 0;
            decrease[i] = 0;
            res[i] = 0;
        }

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(A.get(j)<A.get(i)&&increase[j]+1>increase[i]){
                    increase[i] = increase[i]+1;
                }
            }
        }


        for (int i = A.size()-2; i >-1; i--) {
            for (int j = A.size()-1; j> i; j--) {
                if(A.get(j)<A.get(i)&&decrease[j]+1>decrease[i]){
                    decrease[i] = decrease[i]+1;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            if(increase[i]>0||decrease[i]>0){
                res[i] = increase[i]+decrease[i]+1;
            }
        }
        int max = res[0];
        for (int re : res) {
            if (max < re) {
                max = re;
            }
        }
        return max;
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num) && map.get(target - num) != i) {
                res[0] = i;
                res[1] = map.get(target - num);
                return res;
            }
        }
        return res;
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int sum = nums[i] + nums[j];
                    if (map.containsKey(0 - sum) && map.get(0 - sum) != i) {
                        ArrayList<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(0 - sum);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    //Add two numbers represented in Linked List
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        int val1 = list1.val;
        int val2 = list2.val;
        int car = 0;
        ListNode cur = null, prev = null;
        while (list1 != null || list2 != null) {
            ListNode node = new ListNode(getDigit(val1 + val2 + car));
            car = getCarry(val1 + val2 + car);
            list1 = list1 != null ? (list1.next) : null;
            list2 = list2 != null ? list2.next : null;
            val1 = list1 != null ? list1.val : 0;
            val2 = list2 != null ? list2.val : 0;
            if (prev != null) {
                prev.next = node;
            }
            if (cur == null) {
                cur = node;
            }
            prev = node;
        }
        if (car > 0) {
            prev.next = new ListNode(car);
        }
        return cur;

    }

    private int getDigit(int num) {
        return num % 10;
    }

    private int getCarry(int num) {
        if (num / 10 > 0) {
            return 1;
        }
        return 0;
    }

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}

    //length of longest substring with no character repeated

    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        HashMap<Character, Boolean> map = new HashMap<>();

        for (int i = 0, j = 0; i < s.length() && j < s.length(); ) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), true);
                len++;
                j++;
                if (len < j - i) {
                    len = j - i;
                }
            } else {
                map.remove(s.charAt(i++));
            }

        }
        return len;
    }
    //longest Common Subsequence Recusrion

    private static int longestCommonSubSequenceLen(String s1, String s2, int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return 1 + longestCommonSubSequenceLen(s1, s2, n1 - 1, n2 - 1);
        }
        return max(longestCommonSubSequenceLen(s1, s2, n1 - 1, n2), longestCommonSubSequenceLen(s1, s2, n1, n2 - 1));
    }

    private static int max(int ... num) {
        int max = num[0];
        for (int aNum : num) {
            if (aNum > max) {
                max = aNum;
            }
        }
        return max;
    }

    //logest common subsequence DP

    private static int lcsDP(String A, String B) {
        int[][] matrix = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i < A.length(); i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < B.length(); i++) {
            matrix[0][i] = 0;
        }

        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        return matrix[A.length()][B.length()];
    }

    public int lis(final List<Integer> A) {
        int[] dp = new int[A.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(A.get(j)<A.get(i)&&dp[j]+1>dp[i]){
                    dp[i]++;
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    //Edit operations on String
    private static int editDistance(String A, String B) {
        int[][] matrix = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i < A.length() + 1; i++) {
            for (int j = 0; j < B.length() + 1; j++) {
                if(i==0){
                    matrix[i][j] = j;
                }
                if(j==0){
                    matrix[j][i] = i;
                }
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    matrix[i][j] = max(max(matrix[i][j - 1], matrix[i - 1][j]),matrix[i-1][j-1]);
                }
            }
        }
        return matrix[A.length()][B.length()];
    }


    //Max Partition Recusrion
    private static int maxPartition(int[] a, int n, int sumTotal, int sumCalc) {
        if (n == 0) {
            return Math.abs((sumTotal - sumCalc) - sumCalc);
        }
        return min(maxPartition(a, n - 1, sumTotal, sumCalc + a[n]),
                maxPartition(a, n - 1, sumTotal, sumCalc));
    }


    private static int arraySum(int[] a) {
        int sum = 0;
        for (int anA : a) {
            sum += anA;
        }
        return sum;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

    //max Partition DP

    private static int maxPartitionDP(int[] a) {
        int small = a[0];
        for (int anA1 : a) {
            if (anA1 < small) {
                small = anA1;
            }
        }
        if (small < 0) {
            for (int i = 0; i < a.length; i++) {
                a[i] -= small;
            }
        }
        int sum = 0;
        for (int anA : a) {
            sum += anA;
        }
        int[][] res = new int[a.length][sum + 1];
        int maxSum = sum;
        for (int i = 0; i < a.length; i++) {
            maxSum -= a[i];
            for (int j = 0; j < maxSum + 1; j++) {
                if (i == 0) {
                    res[i][j] = Math.abs((sum - j) - j);
                } else {
                    res[i][j] = min(res[i - 1][j + a[i]], res[i - 1][j]);
                }
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
        return res[a.length - 1][maxSum];

    }


    //count numberof ways recursion

    private static int numberOfWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return (numberOfWays(n - 1) + numberOfWays(n - 2) + numberOfWays(n - 3));
    }


    //count number of ways DP

    private static int numberOfWaysDP(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }


    public static int numDecodings(String A) {
        for (int i = 0; i < A.length() - 1; i++) {
            if (getNumber(A.charAt(i)) == 0 && (i == 0 || getNumber(A.charAt(i - 1)) == 0 || getNumber(A.charAt(i - 1)) > 2)) {
                return 0;
            }
        }
        System.out.println(1 + numDecodingsRec(A, A.length() - 1));
        return 1 + numDecodingsDP(A);
    }

    private static int numDecodingsRec(String s, int i) {
        if (i <= 0) {
            return 0;
        }
        if (canSplit(s.charAt(i - 1), s.charAt(i))) {
            return 1 + numDecodingsRec(s, i - 1) + numDecodingsRec(s, i - 2);
        }
        if (s.charAt(i) == '0') {
            i--;
        }
        return numDecodingsRec(s, i - 1);
    }

    private static int getNumber(char c) {
        int ch = (int) c;
        return ch - 48;
    }

    private static int numDecodingsDP(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i + 1) == '0') {
                dp[i] = dp[i - 1];
            } else if (canSplit(s.charAt(i - 1), s.charAt(i))) {
                dp[i] = 1 + dp[i - 1];
                if (i > 1) {
                    dp[i] = dp[i] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[s.length() - 1];
    }

    private static boolean canSplit(char c1, char c2) {
        if (getNumber(c1) <= 2) {
            if (getNumber(c1) == 0 || getNumber(c2) == 0) {
                return false;
            }
            if (getNumber(c1) == 2 && getNumber(c2) > 6) {
                return false;
            }
            return true;
        }
        return false;
    }



    public int climbStairs(int A) {
        if(A<0){
            return 0;
        }
        if(A==0){
            return 1;
        }
        return(climbStairs(A-1)+climbStairs(A-2));
    }

    private int climbStairsDP(int A){
        int[] dp = new int[A+1];
        if(A<=0){
            return 0;
        }
        dp[0] = 1;
        if(A>0) {
            dp[1] = 1;
            for (int i = 2; i <= A; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[A];
    }


    public int chordCnt(int A) {
        double[][] dp = new double[2*A+1][2*A+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(i==0||j==0){
                    dp[i][j] =0;
                }else if(i>=j||Math.abs(i-j)==1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] =-1;
                }
            }
        }
        double res = chordCountRec(1,2*A,dp);
        res = res%(Math.pow(10,9));
        return (int)res;
    }

    private double chordCountRec(int start, int end, double[][] dp){
        if(start>=end){
            return 1;
        }
        if(Math.abs(start-end)==1){
            return 1;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }


        double count = 0;
        for (int i = start+1; i <=end ; i+=2) {
            count = count+(chordCountRec(start+1,i-1,dp)*chordCountRec(i+1,end,dp));
        }
        dp[start][end] = count;
        return count;
    }
//    Given a string, find if there is any sub-sequence that repeats itself.
//    A sub-sequence of a string is defined as a sequence of characters generated by deleting some characters in the string without changing the order of the remaining characters.
        public static int anytwo(String A) {
            ArrayList<Integer> nonRepeat = new ArrayList<>();
            boolean[] dp = new boolean[A.length()];
            for (int i = 0; i < A.length()-1; i++) {
                for (int j = i+1; j <A.length() ; j++) {
                    if(A.charAt(i)==A.charAt(j)){
                        dp[j] = true;
                        dp[i] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < dp.length; i++) {
                if(!dp[i]){
                    nonRepeat.add(i);
                }
            }

            String repeat = getNewString(A,nonRepeat);
            System.out.println(repeat);
            if(repeat.length()==0)
            {
                return 0;
            }
            if(checkPal(repeat)){
                if(repeat.length()%2==0) {
                    if(repeat.length()==2){
                        return 0;
                    }
                    char c = repeat.charAt(0);
                    for(int i=1;i<repeat.length();i++){
                        if(repeat.charAt(i)!=c){
                            return 0;
                        }
                    }
                    return 1;
                }
                int mid = (repeat.length())/2;
                if(A.charAt(mid)==A.charAt(mid-1) && A.charAt(mid)==A.charAt(mid+1)){
                    return 1;
                }
                return 0;
            }
            return 1;
        }

        private static String getNewString(String A, ArrayList<Integer> dp){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <A.length(); i++) {
                if(!dp.contains(i)){
                    sb.append(A.charAt(i));
                }
            }
            return String.valueOf(sb);
        }

        private static boolean checkPal(String A){
            for (int i = 0; i < A.length()/2; i++) {
                if(A.charAt(i)!=A.charAt(A.length()-i-1)){
                    return false;
                }
            }
            return true;
        }

        private static int optimalStrat(ArrayList<Integer> a, int start, int end){
            if(end-start ==1){
                return max(a.get(start),a.get(end));
            }
            if(start==end){
                return a.get(start);
            }
            return max(a.get(start)+min(optimalStrat(a,start+2,end),optimalStrat(a,start+1,end-1)),
                    a.get(end)+min(optimalStrat(a,start,end-2),optimalStrat(a,start+1,end-1)));


        }
    }


class Num {
    int a;

    void Num() {
        a = 0;
    }
}