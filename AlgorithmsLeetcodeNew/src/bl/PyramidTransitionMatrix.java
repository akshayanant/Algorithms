package bl;

import java.util.List;

/**
 * Created by Akshay Hegde on 10/17/2019.
 * 756. Pyramid Transition Matrix
 Medium

 212

 288

 Favorite

 Share
 We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.

 We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.

 We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

 Return true if we can build the pyramid all the way to the top, otherwise false.

 Example 1:

 Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 Output: true
 Explanation:
 We can stack the pyramid like this:
 A
 / \
 G   E
 / \ / \
 B   C   D

 We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of C and D, then A on top of G and E.


 Example 2:

 Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 Output: false
 Explanation:
 We can't stack the pyramid to the top.
 Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.


 Note:

 bottom will be a string with length in range [2, 8].
 allowed will have length in range [0, 200].
 Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.

 */
public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] T = new int[1 << 7][1 << 7];
        for (String triple: allowed) {
            int u = 1 << (triple.charAt(0) - 'A');
            int v = 1 << (triple.charAt(1) - 'A');
            int w = 1 << (triple.charAt(2) - 'A');
            for (int b1 = 0; b1 < (1 << 7); ++b1) if ((u & b1) > 0)
                for (int b2 = 0; b2 < (1 << 7); ++b2) if ((v & b2) > 0)
                    T[b1][b2] |= w;
        }

        int[] state = new int[bottom.length()];
        int t = 0;
        for (char c: bottom.toCharArray())
            state[t++] = 1 << (c - 'A');
        while (t-- > 1)
            for (int i = 0; i < t; ++i)
                state[i] = T[state[i]][state[i+1]];
        return state[0] > 0;
    }

}
