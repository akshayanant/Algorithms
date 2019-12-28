package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/9/2019.
 */
class MedianFinder {
    List<Integer> stream;
    /** initialize your data structure here. */
    public MedianFinder() {
        stream = new ArrayList<>();
    }

    public void addNum(int num) {
        insert(stream,num);
    }

    public double findMedian() {
        if(stream.size()%2==0){
            double a = stream.get(stream.size()/2);
            double b = stream.get(stream.size()/2-1);
            return (a+b)/2;
        }
        return stream.get(stream.size()/2);
    }

    private void insert(List<Integer> stream,int num){
        int index = 0;
        if(stream.size()>0){
            int l=0;
            int r=stream.size()-1;
            while (l<=r){
                int mid = (l+r)/2;
                if(stream.get(mid)<num){
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }
            }
            index = l;
        }
        stream.add(index,num);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
