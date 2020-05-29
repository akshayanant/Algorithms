package bl;

import sun.misc.Perf;

import java.util.*;

/**
 * Created by Akshay Hegde on 3/14/2020.
 */
public class LeetCodeContest180 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m= matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            int minCol = 0;
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]<matrix[i][minCol]) {
                    minCol = j;
                }
            }
            visit[i][minCol] = true;

        }
        for (int j = 0; j < n; j++) {
            int maxRow = 0;
            for (int i = 1; i < m; i++) {
                if(matrix[i][j]>matrix[maxRow][j]) {
                    maxRow = i;
                }

            }
            if(visit[maxRow][j]){
                res.add(matrix[maxRow][j]);
            }
        }
        return res;
    }
    class CustomStack {

        class DoubleList{
            DoubleList next;
            DoubleList prev;
            int val;

            public DoubleList(int val) {
                this.val = val;
            }
        }

        int maxSize;
        int size;
        DoubleList head;
        DoubleList tail;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if(size<maxSize){
                DoubleList node = new DoubleList(x);
                if(size==0){
                    head = node;
                    tail = node;
                    size++;
                    return;
                }
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
                size++;
            }
        }

        public int pop() {
            if(size==0){
                return -1;
            }
            int res = tail.val;
            tail = tail.prev;
            size--;
            if(size>0) {
                tail.next = null;
            }
            return res;
        }

        public void increment(int k, int val) {
            DoubleList temp = head;
            int count=0;
            while(temp!=null&&count<k){
                temp.val+=val;
                temp = temp.next;
                count++;
            }
        }
    }

    int MOD = 1000000007;

    class Engineer{
        long speed;
         long eff;

        public Engineer(long speed, long eff) {
            this.speed = speed;
            this.eff = eff;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer[] engineers = new Engineer[n];
        for (int i = 0; i <n ; i++) {
            engineers[i] =new Engineer(speed[i],efficiency[i]);
        }
        Arrays.sort(engineers, new Comparator<Engineer>() {
            @Override
            public int compare(Engineer o1, Engineer o2) {
                return Long.compare(o2.eff,o1.eff);
            }
        });
        PriorityQueue<Long> minSpeed = new PriorityQueue<>();
        long speedSum =0;
        long res = 0;
        for(Engineer e:engineers){
            minSpeed.add(e.speed);
            speedSum+=e.speed;
            while(minSpeed.size()>k){
                long poll = minSpeed.poll();
                speedSum-=poll;
            }
            res = Math.max(res, (speedSum*e.eff));
        }
        return (int) (res%MOD);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root,inOrder);
        return rec(inOrder,0,inOrder.size()-1);
    }

    private void inOrder(TreeNode root,List<Integer> inOrder){
        if(root==null){
            return;
        }
        inOrder(root.left,inOrder);
        inOrder.add(root.val);
        inOrder(root.right,inOrder);
    }

    private TreeNode rec(List<Integer> inOrder, int l, int h){
        if(l>h){
            return null;
        }
        int mid = (l+h)/2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = rec(inOrder,l,mid-1);
        root.right = rec(inOrder,mid+1,h);
        return root;
    }
}
