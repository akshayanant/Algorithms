package bl;

/**
 * Created by Akshay Hegde on 9/23/2019.
 * 997. Find the Town Judge
 Easy

 241

 37

 Favorite

 Share
 In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

 If the town judge exists, then:

 The town judge trusts nobody.
 Everybody (except for the town judge) trusts the town judge.
 There is exactly one person that satisfies properties 1 and 2.
 You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

 If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.



 Example 1:

 Input: N = 2, trust = [[1,2]]
 Output: 2
 Example 2:

 Input: N = 3, trust = [[1,3],[2,3]]
 Output: 3
 Example 3:

 Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 Output: -1
 Example 4:

 Input: N = 3, trust = [[1,2],[2,3]]
 Output: -1
 Example 5:

 Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 Output: 3


 Note:

 1 <= N <= 1000
 trust.length <= 10000
 trust[i] are all different
 trust[i][0] != trust[i][1]
 1 <= trust[i][0], trust[i][1] <= N

 */
public class TownJudge {
    public int findJudge(int N, int[][] trust) {
        if(N==1){
            return 1;
        }
       int[] out = new int[N+1];
       int[] in = new int[N+1];
       for (int[] aTrust : trust) {
           in[aTrust[1]]++;
           out[aTrust[0]]++;
       }
       int judge =-1;
        for (int i = 0; i < N + 1; i++) {
            if(in[i]==N-1&&out[i]==0){
                if(judge!=-1){
                    return -1;
                }
                judge = i;
            }
        }
        return judge;
    }
}
