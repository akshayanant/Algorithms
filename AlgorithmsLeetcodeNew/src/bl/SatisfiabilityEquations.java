package bl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Akshay Hegde on 9/23/2019.
 *
 * 990. Satisfiability of Equality Equations
 Medium

 250

 3

 Favorite

 Share
 Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.

 Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.



 Example 1:

 Input: ["a==b","b!=a"]
 Output: false
 Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 Example 2:

 Input: ["b==a","a==b"]
 Output: true
 Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 Example 3:

 Input: ["a==b","b==c","a==c"]
 Output: true
 Example 4:

 Input: ["a==b","b!=c","c==a"]
 Output: false
 Example 5:

 Input: ["c==c","b==d","x!=z"]
 Output: true


 Note:

 1 <= equations.length <= 500
 equations[i].length == 4
 equations[i][0] and equations[i][3] are lowercase letters
 equations[i][1] is either '=' or '!'
 equations[i][2] is '='

 */
public class SatisfiabilityEquations {
    class UnionFind {
        int[] ranks;
        int[] parents;
        int size;
        Map<Integer,Set<Integer>> exclude;

        public UnionFind(int size) {
            ranks = new int[size];
            parents = new int[size];
            this.size = size;
            exclude = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                exclude.put(i,new HashSet<>());
            }
            init();
        }

        private void init() {
            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }
        }

        public int getParent(int child) {
            if (parents[child] != child) {
                return getParent(parents[child]);
            }
            return child;
        }

        private Set<Integer> getExclude(int i){
            return exclude.get(i);
        }

        private void addExclude(int parent, int node){
            exclude.get(parent).add(node);
        }

        public void union(int x, int y) {
            int rootX = getParent(x);
            int rootY = getParent(y);
            if (rootX == rootY) {
                return;
            }
            if (ranks[rootX] > ranks[rootY]) {
                parents[rootY] = rootX;
                exclude.get(rootX).addAll(exclude.get(rootY));
            } else if (ranks[rootX] < ranks[rootY]) {
                parents[rootX] = rootY;
                exclude.get(rootY).addAll(exclude.get(rootX));
            } else {
                parents[rootY] = rootX;
                exclude.get(rootX).addAll(exclude.get(rootY));
                ranks[rootX]++;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                if (unionFind.getExclude(unionFind.getParent(equation.charAt(0) - 97)).contains(equation.charAt(3) - 97)||
                        unionFind.getExclude(unionFind.getParent(equation.charAt(3) - 97)).contains(equation.charAt(0) - 97)) {
                    return false;
                }
                unionFind.union(equation.charAt(0) - 97, equation.charAt(3) - 97);
            } else {
                if (unionFind.getParent(equation.charAt(0) - 97) ==
                        unionFind.getParent(equation.charAt(3) - 97)) {
                    return false;
                }
                unionFind.addExclude(unionFind.getParent(equation.charAt(0) - 97), equation.charAt(3) - 97);
                unionFind.addExclude(unionFind.getParent(equation.charAt(3) - 97), equation.charAt(0) - 97);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SatisfiabilityEquations().equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }
}
