package bl;

/**
 * Created by Akshay Hegde on 11/15/2019.
 */
public class WayFair {
    public String solution(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int j = i+1;
            while(j< S.length()&&S.charAt(j)==ch){
                j++;
            }
            if(j-i==1) {
                sb.append(ch);
            }else {
                sb.append(ch).append(ch);
            }
            i = j-1;
        }
        return sb.toString();
    }

    public String solution(int A, int B, int C) {
        int[] arr = new int[]{A,B,C};
        StringBuilder sb = new StringBuilder();
        int prevLarge = getLarge(arr);
        while(prevLarge!=-1){
            printChars(sb,prevLarge,arr);
            int temp = arr[prevLarge];
            arr[prevLarge] = -1;
            int large = getLarge(arr);
            arr[prevLarge] = temp;
            prevLarge = large;
        }
        return sb.toString();
    }
    // helper method to append the results
    private void printChars(StringBuilder sb,int index,int[] arr){
        char ch = ' ';
        if(index==0){
            ch = 'a';
        }
        else if(index==1){
            ch='b';
        }
        else{
            ch='c';
        }
        int rep = Math.min(arr[index],2);
        while(rep>0) {
            sb.append(ch);
            rep--;
            arr[index]--;
        }
    }

    //helper method to get the large number

    private int getLarge(int[] arr){
        int index = -1;
        int large = 0;
        for (int i = 0; i < arr.length; i++) {
            if(large<arr[i]){
                large = arr[i];
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        //System.out.println(new WayFair().solution("eedaaad"));
        System.out.println(new WayFair().solution(5,5,5));
    }
}
