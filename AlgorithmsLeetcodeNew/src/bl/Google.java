package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 10/26/2019.
 */
public class Google {
    static Integer[] solution(Integer[] N, int K) {
        int start = 0;
        int end=K-1;
        for(int i=1;i<=N.length-K;i++){
            if(largestSubArray(N,start,i,K)){
                start = i;
                end = i+K-1;
            }
        }
        Integer[] res = new Integer[K];
        for(int i = start,j=0;i<=end;i++,j++){
            res[j] = N[i];
        }
        return res;
    }

    private static boolean largestSubArray(Integer[] arr, int i1,int i2,int k){
        int i1Temp =i1;
        int i2Temp = i2;
        while(i1Temp<i1+k&&i2Temp<i2+k){
            if(arr[i1Temp]<arr[i2Temp]){
                return true;
            }
            if(arr[i1Temp]>arr[i2Temp]){
                return false;
            }
            i1Temp++;
            i2Temp++;
        }
        return false;
    }

    public static String solution(String T) {
        char[] sol = T.toCharArray();
        for(int i=0;i<T.length();i++) {
            if (i == 2 || T.charAt(i) != '?') {
                continue;
            }
            sol[i] = getDigit(getChar(sol, i - 1), getChar(sol,i+1),i);
        }
        return String.valueOf(sol);
    }

    private static char getChar(char[] ch,int i){
        if(i<0||i>=ch.length){
            return ' ';
        }
        return ch[i];
    }

    private static char getDigit(char prev,char next,int index){
        if(index==0){
            if(next=='?'||next<'4') {
                return '2';
            }
            return '1';
        }
        if(index==1){
            if(prev=='2'){
                return '3';
            }
            return '9';
        }
        if(index==3){
            return '5';
        }
        return '9';
    }


    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,10,10,4,3,2,-10,5,1,4,3,2,5};
        System.out.println(Arrays.toString(Google.solution(input, 10)));
        //System.out.println(Google.solution("00:?9"));
    }
}
