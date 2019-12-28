import java.util.Iterator;

/**
 * Created by Akshay Hegde on 9/9/2019.
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

 Example:

 Assume that the iterator is initialized to the beginning of the list: [1,2,3].

 Call next() gets you 1, the first element in the list.
 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 You call next() the final time and it returns 3, the last element.
 Calling hasNext() after that should return false.
 Follow up: How would you extend your design to be generic and work with all types, not just integer?

 */
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer buf;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        buf = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(buf==null){
            buf = iterator.next();
        }
        return buf;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(buf==null){
            return iterator.next();
        }
        int ret =  buf;
        buf = null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return (buf!=null||iterator.hasNext());
    }
}
