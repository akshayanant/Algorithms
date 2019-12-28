package bl;

/**
 * Created by Akshay Hegde on 10/12/2019.
 * 808. Soup Servings
 Medium

 111

 389

 Favorite

 Share
 There are two types of soup: type A and type B. Initially we have N ml of each type of soup. There are four kinds of operations:

 Serve 100 ml of soup A and 0 ml of soup B
 Serve 75 ml of soup A and 25 ml of soup B
 Serve 50 ml of soup A and 50 ml of soup B
 Serve 25 ml of soup A and 75 ml of soup B
 When we serve some soup, we give it to someone and we no longer have it.  Each turn, we will choose from the four operations with equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as we can.  We stop once we no longer have some quantity of both types of soup.

 Note that we do not have the operation where all 100 ml's of soup B are used first.

 Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.

 */
public class SoupServing {
    public double soupServings(int N) {
        return rec(N,N);
    }

    private double rec(int A,int B){
        if(A<=0&&B>0){
            return 1;
        }
        if(A<=0&&B<=0){
            return 0.5;
        }
        if(B<=0&&A>0){
            return 0;
        }
        return 0.25*(rec(A-100,B)+rec(A-75,B-25)+rec(A-50,B-50)+rec(A-25,B-75));
    }

    private double dp(int N){
        double[][] dp = new double[101][101];
        for (int i = 0; i <N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                dp[i%101][j%101] = 0.25 * (getDP(dp, i - 100, j) + getDP(dp, i - 75, j - 25) + getDP(dp, i - 50, j - 50) + getDP(dp, i - 25, j - 75));
            }
        }
        return dp[N%101][N%101];
    }

    private double getDP(double[][] dp,int i,int j){
        if(i<=0&&j>0){
            return 1;
        }
        if(i<=0&&j<=0){
            return 0.5;
        }
        if(j<=0&&i>0){
            return 0;
        }
        return dp[i%101][j%101];
    }

    public static void main(String[] args) {
        System.out.println(new SoupServing().dp(200));
    }
}
