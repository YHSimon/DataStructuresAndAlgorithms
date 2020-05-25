package day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
//        LRUCache lruCache=new LRUCache(1);
//        lruCache.put(2, 1);
//        System.out.println(lruCache.get(2));


//        LRUCache lruCache=new LRUCache(2);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        System.out.println(lruCache.get(1));      // 返回  1
//        lruCache.put(3, 3);    // 该操作会使得密钥 2 作废
//        System.out.println(lruCache.get(2));       // 返回 -1 (未找到)
//        lruCache.put(4, 4);    // 该操作会使得密钥 1 作废
//        System.out.println(lruCache.get(1));       // 返回 -1 (未找到)
//        System.out.println(lruCache.get(3));        // 返回  3
//        System.out.println(lruCache.get(4));        // 返回  4

        LRUCache lruCache=new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(2));
    }

    int capacity;
    static List<Integer> record=new ArrayList<>();
    static Map<Integer,Integer> cache=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            int i=record.indexOf(key);
            i++;
            for(;i<record.size();i++){
                record.set(i-1, record.get(i));
            }
            record.set(record.size()-1, key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.size()<capacity){
            if(cache.containsKey(key)){
                int i = record.indexOf(key);
                i++;
                for(;i<record.size();i++){
                    record.set(i-1, record.get(i));
                }
                record.set(record.size()-1, key);
            }else{
                record.add(key);
            }
            cache.put(key, value);
        }else{//cache已满
            if(cache.containsKey(key)){
                int i = record.indexOf(key);i++;

                for(;i<record.size();i++){
                    record.set(i-1, record.get(i));
                }
                record.set(capacity-1, key);
                cache.put(key, value);
            }else{
                //移除最久未使用的
                cache.remove(record.get(0));
                //更新队列
                for(int i=1;i<record.size();i++){
                    record.set(i-1, record.get(i));
                }
               record.set(capacity-1, key);
                cache.put(key, value);
            }
        }

    }

}
