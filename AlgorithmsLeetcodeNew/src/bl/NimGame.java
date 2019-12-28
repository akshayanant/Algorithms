package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/9/2019.
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

 Example:

 Input: 4
 Output: false
 Explanation: If there are 4 stones in the heap, then you will never win the game;
 No matter 1, 2, or 3 stones you remove, the last stone will always be
 removed by your friend.
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return (n%4!=0);
    }

    private boolean dp(int n){
        if(n==0){
            return false;
        }
        if(n<=3){
            return true;
        }
        List<Boolean> dp = new ArrayList<>(3);
        dp.add(true);
        dp.add(true);
        dp.add(true);
        int i = 4;
        for (; i < n+1; i++) {
            boolean res = !dp.get((i+1)%3)||!dp.get((i+2)%3)||!dp.get((i+3)%3);
            dp.remove(0);
            dp.add(res);
        }
        return dp.get(dp.size()-1);
    }
}
