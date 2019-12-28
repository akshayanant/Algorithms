package bl;

/**
 * Created by Akshay Hegde on 10/20/2019.
 */
public class URLify {
    private void solution(char[] url){
        int fillIndex = url.length-1;
        int trackIndex = url.length-1;
        while (url[trackIndex]=='\u0000'){
            trackIndex--;
        }
        while (trackIndex>-1){
            if(url[trackIndex]==' '){
                url[fillIndex--] = '0';
                url[fillIndex--] = '2';
                url[fillIndex--] = '%';
            }
            else{
                url[fillIndex--] = url[trackIndex];
            }
            trackIndex--;
        }
    }

    public static void main(String[] args) {
        char[] input = new char[]{'M','r',' ','J','o','h','n',' ','s','m','i','t','h','\u0000','\u0000','\u0000','\u0000'};
        new URLify().solution(input);
        System.out.println(input);
    }
}
