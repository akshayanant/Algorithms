package bl; /**
 * Created by Akshay Hegde on 6/24/2019.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 The cache is initialized with a positive capacity.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:
//
// LRUCache cache = new LRUCache( 2 /* capacity */

import java.util.*;
//);
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
///

public class LRUCache {
    private int cap;
    private Map<Integer,Integer> buffer;


    public LRUCache(int capacity) {
        cap = capacity;
        buffer = new LinkedHashMap<Integer,Integer>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return buffer.size()>cap;
            }
        };
    }

    public int get(int key) {
        if(!buffer.containsKey(key)){
            return -1;
        }
        int val = buffer.get(key);
        buffer.remove(key);
        buffer.put(key,val);
        return val;
    }

    public void put(int key, int value) {
        if(buffer.containsKey(key)){
            buffer.remove(key);
            buffer.put(key,value);
        }
        else{
            buffer.put(key,value);
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
