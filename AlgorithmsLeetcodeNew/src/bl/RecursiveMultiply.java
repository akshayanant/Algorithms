package bl;

/**
 * Created by Akshay Hegde on 10/7/2019.
 */
public class RecursiveMultiply {
    private int multiply(int a,int b){
        if(a==1){
            return b;
        }
        if(b==1){
            return a;
        }
        if(b<a){
            return rec(a,b);
        }
        return rec(b,a);
    }

    private int rec(int a,int b){
        if(b==1){
            return a;
        }
        if(b%2==0){
            int num = a<<1;
            return rec(num,b/2);
        }
        return a+rec(a,b-1);
    }

    public static void main(String[] args) {
        int a=23340;
        int b=60327;
        System.out.println(new RecursiveMultiply().multiply(a,b));
        System.out.println(a*b);
    }
}
