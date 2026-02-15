package Classic150.LinkList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class DeLinkNode{
        int key;
        int value;
        DeLinkNode pre;
        DeLinkNode next;

        public DeLinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }

        public DeLinkNode(){}
    }

    int capacity;
    int curNum;
    DeLinkNode head;
    DeLinkNode tail;
    Map<Integer, DeLinkNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curNum = 0;
        this.head = new DeLinkNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tail = new DeLinkNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.map = new HashMap<>();

        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        DeLinkNode node = map.get(key);

        if(node != null){
            moveToHead(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DeLinkNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else {
            DeLinkNode node = new DeLinkNode(key, value);
            addToHead(node);
            map.put(key, node);

            curNum++;
            if(curNum > capacity){
                removeLast();
                curNum--;
            }
        }
    }

    private void remove(DeLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void removeLast(){
        DeLinkNode node = tail.pre;

        if(node != head) {
            remove(node);
            map.remove(node.key);
        }
    }

    private void addToHead(DeLinkNode node){
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DeLinkNode node){
        remove(node);
        addToHead(node);
    }



    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3,3);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4,4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));

        lruCache.put(2, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
    }
}
