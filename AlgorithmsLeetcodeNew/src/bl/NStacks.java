///**
// * Created by Akshay Hegde on 10/15/2019.
// * Implement N > 0 stacks using a single array to store all stack data
// (you may use auxiliary arrays in your stack object, but all of the objects in all of
// the stacks must be in the same array). No stack should be full unless the entire
// array is full.
// ● Eg.
// N = 3;
// capacity = 10;
// Stacks stacks = new Stacks(N, capacity);
// stacks.put(0, 10);
// stacks.put(2, 11);
// stacks.pop(0) = 10;
// stacks.pop(2) = 11;
// ● Answer
//
// */
//public class NStacks {
//    class StackNode{
//        int val;
//        int prev;
//
//        public StackNode(int val, int prev) {
//            this.val = val;
//            this.prev = prev;
//        }
//    }
//
//    class NStack{
//        StackNode[] stackNodes;
//        int[] pointers;
//        int cap;
//        int count;
//        int nextPointer;
//        int rem;
//
//        public NStack(int cap,int n) {
//            this.cap = cap;
//            this.count = n;
//            stackNodes = new StackNode[cap];
//            pointers = new int[n];
//            for (int i = 0; i < n; i++) {
//                pointers[i] = -1;
//            }
//            nextPointer = 0;
//            rem = cap;
//        }
//
//        public boolean push(int num, int index){
//            if(rem==0||index>count-1){
//                return false;
//            }
//            int prev = pointers[index];
//            StackNode node = new StackNode(num,prev);
//            pointers[index] = nextPointer;
//            stackNodes[nextPointer] = node;
//            nextPointer = (nextPointer+1)%cap;
//            rem--;
//            return true;
//        }
//
//        public int pop(int index){
//            if(index>count-1||rem==cap||pointers[index]==-1){
//                return Integer.MIN_VALUE;
//            }
//            StackNode pop = stackNodes[pointers[index]];
//            int prev = pop.prev;
//            pointers[index] = prev;
//            nextPointer = nextPointer-1
//        }
//    }
//
//
//
//
//
//
//
//    class ArrayStack{
//        int[] stack;
//        int size;
//        private int pointer;
//        int rem;
//
//        public ArrayStack(int size) {
//            this.stack = new int[size];
//            this.size = size;
//            pointer = -1;
//            rem = size;
//        }
//
//        public boolean push(int num){
//            if(rem==0){
//                return false;
//            }
//            pointer = (pointer+1)%size;
//            stack[pointer] = num;
//            rem--;
//            return true;
//        }
//
//        public int pop(){
//            if(rem==size){
//                return Integer.MAX_VALUE;
//            }
//            int pop = stack[pointer];
//            pointer=(pointer-1)%size;
//            rem++;
//            return pop;
//        }
//    }
//
//    public ArrayStack getArrayStack(int size){
//        return new ArrayStack(size);
//    }
//
//    public static void main(String[] args) {
//        NStacks nStack = new NStacks();
//        ArrayStack arrayStack = nStack.getArrayStack(5);
//        System.out.println(arrayStack.push(5));
//        System.out.println(arrayStack.push(2));
//        System.out.println(arrayStack.push(3));
//        System.out.println(arrayStack.push(12));
//        System.out.println(arrayStack.push(13));
//        System.out.println(arrayStack.push(14));
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.pop());
//
//        System.out.println(arrayStack.pop());
//
//
//    }
//}
