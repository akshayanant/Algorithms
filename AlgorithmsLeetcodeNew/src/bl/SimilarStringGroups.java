package bl;

/**
 * Created by Akshay Hegde on 9/22/2019.
 * 839. Similar String Groups
 Hard

 189

 64

 Favorite

 Share
 Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.

 For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

 Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

 We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

 Example 1:

 Input: ["tars","rats","arts","star"]
 Output: 2
 Note:

 A.length <= 2000
 A[i].length <= 1000
 A.length * A[i].length <= 20000
 All words in A consist of lowercase letters only.
 All words in A have the same length and are anagrams of each other.
 The judging time limit has been increased for this question.

 */
public class SimilarStringGroups {
    class UnionFind {
        int[] ranks;
        int[] parents;
        int size;

        public UnionFind(int size) {
            ranks = new int[size];
            parents = new int[size];
            this.size = size;
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

        public void union(int x, int y) {
            int rootX = getParent(x);
            int rootY = getParent(y);
            if (rootX == rootY) {
                return;
            }
            if (ranks[rootX] > ranks[rootY]) {
                parents[rootY] = rootX;
            } else if (ranks[rootX] < ranks[rootY]) {
                parents[rootX] = rootY;
            } else {
                parents[rootY] = rootX;
                ranks[rootX]++;
            }
        }
    }

    public int numSimilarGroups(String[] A) {
        UnionFind unionFind = new UnionFind(A.length);
        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                if(canSwap(A[i],A[j])){
                    unionFind.union(i,j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < unionFind.size; i++) {
            if(unionFind.getParent(i)==i){
                res++;
            }
        }
        return res;
    }

    private boolean canSwap(String s,String t){
        int count =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)){
                count++;
                if(count>2){
                    return false;
                }
            }
        }
        return true;
    }
}
