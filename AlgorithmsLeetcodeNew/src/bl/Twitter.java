package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/11/2019.
 */
public class Twitter {
    public static int minPrice(List<List<Integer>> cost) {
        List<List<Integer>> indices = new ArrayList<>();
        for (List<Integer> aCost : cost) {
            List<Integer> block = new ArrayList<>(3);
            block.add(0);
            if(aCost.get(1)>aCost.get(0)){
                block.add(1);
            }
            else{
                block.add(0,1);
            }
            if(aCost.get(2)<aCost.get(block.get(0))){
                block.add(0,2);
            }
            else if(aCost.get(2)<aCost.get(block.get(1))){
                block.add(1,2);
            }
            else{
                block.add(2);
            }
            indices.add(block);
        }
        int[] res = new int[cost.size()];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
           boolean canColor =  backTrack(res, indices, 0,i);
           if(canColor){
               int count = 0;
               for (int j = 0; j < res.length; j++) {
                   count+=cost.get(j).get(res[j]);
               }
               if(count<min){
                   min= count;
               }
           }
           res = new int[cost.size()];
        }
        return min;
    }

    private static boolean backTrack(int[] array,List<List<Integer>>indices,int index,int start){
        if(index==array.length){
            return true;
        }
        for (int i = start; i < indices.get(index).size(); i++) {
            if(canPaint(array,index,indices.get(index).get(i))){
                array[index] = indices.get(index).get(i);
                boolean canFill = backTrack(array,indices,index+1,0);
                if(canFill){
                    return true;
                }
            }
        }
        array[index] = -1;
        return false;
    }

    private static boolean canPaint(int[] array,int index, int colorIndex) {
        return index == 0 || array[index - 1] != colorIndex;
    }

    public static int minPriceNew(List<List<Integer>> cost) {
        return minPriceRec(cost,-1,0);
    }

    private static int minPriceRec(List<List<Integer>> cost,int exclude,int index){
        if(index>cost.size()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cost.get(0).size(); i++) {
            if(i==exclude){
                continue;
            }
            int sum = cost.get(index).get(i)+minPriceRec(cost,i,index+1);
            if(sum<min){
                min = sum;
            }
        }
        return min;
    }

    private static int paintDP(List<List<Integer>> cost){
        int[][] dp = new int[cost.size()][3];
        dp[cost.size()-1][0] = Math.min(cost.get(cost.size()-1).get(2),cost.get(cost.size()-1).get(1));
        dp[cost.size()-1][1] = Math.min(cost.get(cost.size()-1).get(2),cost.get(cost.size()-1).get(0));
        dp[cost.size()-1][2] = Math.min(cost.get(cost.size()-1).get(0),cost.get(cost.size()-1).get(1));
        for (int i = cost.size()-2; i > -1; i--) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(cost.get(i).get((j+1)%3)+dp[i+1][(j+1)%3],
                                    cost.get(i).get(((j+2)%3))+dp[i+1][(j+2)%3]);
            }
        }
        return Math.min(Math.min(dp[0][0],dp[0][1]),dp[0][2]);
    }







        public static int maxHeight(List<Integer> tablePositions, List<Integer> tableHeights) {
        if(tablePositions.size()<2){
            return 0;
        }
        int maxHeight =0;
        int offset = tablePositions.get(0);
        int[] allheights = new int[tablePositions.get(tablePositions.size()-1)-offset+1];
        for (int i = 0; i < tablePositions.size(); i++) {
            allheights[tablePositions.get(i)-offset] = tableHeights.get(i);
        }
        for (int i = 0; i < allheights.length-1; i++) {
            if(allheights[i+1]!=0){
                continue;
            }
            int start = i+1;
            int j = start;
            while (allheights[j]==0){
                allheights[j] = allheights[j-1]+1;
                j++;
            }
            i=j-1;
            if(allheights[j]+1>=allheights[j-1]){
                continue;
            }
            j = j-1;
            allheights[j] = allheights[j+1]+1;
            j--;
            while (j>=start&&allheights[j]>allheights[j+1]+1){
                allheights[j] = allheights[j+1]+1;
                j--;
            }
        }
        int listIndex = 0;
        for (int i = 0; i <allheights.length-1 ; i++) {
            if(i!=tablePositions.get(listIndex)-offset) {
                if (allheights[i] > maxHeight) {
                    maxHeight = allheights[i];
                }
            }
            else {
                listIndex++;
            }
        }
        return maxHeight;
    }

    public static int maxHeightNew(List<Integer> tablePositions, List<Integer> tableHeights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tableHeights.size()-1; i++) {
            if(tablePositions.get(i)+1==tablePositions.get(i+1)){
                continue;
            }
            max = Math.max(max,maxHeightRange(tablePositions.get(i),tablePositions.get(i+1),
                    tableHeights.get(i),tableHeights.get(i+1)));
        }
        return max;
    }

    private static  int maxHeightRange(int start,int end, int startH,int endH){
        int[] lr = new int[end-start-1];
        int[] rl = new int[end-start-1];
        int prev = startH;
        for (int i = 0; i < lr.length; i++) {
            lr[i] = prev+1;
            prev = lr[i];
        }
        prev = endH;
        for (int i = lr.length-1; i >-1; i--) {
            rl[i] = prev+1;
            prev = rl[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lr.length; i++) {
            max =Math.max(max,Math.min(lr[i],rl[i]));
        }
        return max;
    }

        public static int devide(List<Integer> tablePositions, List<Integer> tableHeights) {
        List<Integer> newPos = new ArrayList<>();
        List<Integer> newHeight = new ArrayList<>();
        int max =0;
        for (int i = 0; i < tablePositions.size()-1; i++) {
            if(tablePositions.get(i)+1==tablePositions.get(i+1)){
                continue;
            }
            newPos.add(tablePositions.get(i));
            newPos.add(tablePositions.get(i+1));
            newHeight.add(tableHeights.get(i));
            newHeight.add(tableHeights.get(i+1));
            int count = maxHeight(newPos,newHeight);
            if(count>max){
                max = count;
            }
            newPos.clear();
            newHeight.clear();
        }
        return max;
    }

    public static void finalPrice(List<Integer> prices) {
        long sum=0;
        if(prices.size()==1){
            System.out.println(prices.get(0));
            System.out.println(prices.get(0));
            return;
        }
        StringBuilder res = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.size()-1; i > -1; i--) {
            while (!stack.isEmpty()&&stack.peek()>prices.get(i)){
                stack.pop();
            }
            if(!stack.isEmpty()){
                sum+=(prices.get(i)-stack.peek());
            }
            else{
                sum+=prices.get(i);
                res.insert(0,i+" ");
            }
            stack.push(prices.get(i));
        }

        System.out.println(sum);
        System.out.println(res);
    }

    private static void find(List<Integer> list,int num){
        int index = 0;
        if(list.size()>0){
            int l=0;
            int r = list.size()-1;
            while (l<=r){
                int mid = (l+r)/2;
                if(num<list.get(mid)){
                    r = mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            index =l;
        }
        list.add(index,num);
    }

    public static String canReach(int x1, int y1, int x2, int y2) {
        return (reachable(x1,y1,x2,y2)?"Yes":"No");
    }

    public static boolean reachable(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y1 == y2 || !(x1 > x2 || y1 > y2) && (reachable(x1 + y1, y1, x2, y2) || reachable(x1, x1 + y1, x2, y2));
    }

    public static boolean botReachable(int x1, int y1, int x2, int y2) {
        if(x2<x1||y2<y1){
            return false;
        }
        if(x2==x1&&y2==y1){
            return true;
        }
        int m = x2-x1+2;
        int n= y2-y1+2;
        boolean[][] dp = new boolean[m][n];
        dp[m-1][n-1] = true;
        for (int i = m-1; i > 0; i--) {
            for (int j = n-1; j > 0; j--) {
                if(i==m-1&&j==n-1){
                    continue;
                }
                dp[i][j] = getDP(i+j,j,m,n,dp)||getDP(i,i+j,m,n,dp);
            }
        }
        return dp[1][1];
    }

    private static boolean getDP(int i,int j,int m,int n,boolean[][] dp) {
        return !(i < 0 || j < 0 || i > m - 1 || j > n - 1) && dp[i][j];
    }



        public static void main(String[] args) {
//        List<List<Integer>> input = new ArrayList<>();
//        List<Integer> in = new ArrayList<>();
//        in.add(1);
//        in.add(10);
//        in.add(20);
//        input.add(in);
//        in = new ArrayList<>();
//        in.add(2);
//        in.add(100);
//        in.add(100);
//        input.add(in);
//        in = new ArrayList<>();
//        in.add(2);
//        in.add(1);
//        in.add(2);
//        List<Integer> pos = new ArrayList<>();
//        pos.add(1);
//        pos.add(2);
//        pos.add(4);
//        pos.add(7);
//        List<Integer> heights = new ArrayList<>();
//        heights.add(4);
//        heights.add(5);
//        heights.add(7);
//        heights.add(11);
//        System.out.println(Twitter.devide(pos,heights));
            List<Integer> in = new ArrayList<>();
            System.out.println(Twitter.botReachable(1,4,5,9));

    }
}
