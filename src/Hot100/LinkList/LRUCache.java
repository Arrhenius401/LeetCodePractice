package Hot100.LinkList;

import java.util.HashMap;

public class LRUCache {

    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode() {}
        public DLinkNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private HashMap<Integer, DLinkNode> map;
    private DLinkNode dummyHead, dummyTail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        dummyHead = new DLinkNode();
        dummyTail = new DLinkNode();
        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if(node == null){
            return -1;
        }

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);

        if(node == null){
            DLinkNode newNode = new DLinkNode(key, value);
            map.put(key, newNode);
            size++;
            if(size > capacity){
                DLinkNode tail = dummyTail.prev;
                removeNode(tail);
                map.remove(tail.key);
                size--;
            }
            addToHead(newNode);
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void removeNode(DLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(DLinkNode node){
        dummyHead.next.prev = node;
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
    }
    public void moveToHead(DLinkNode node){
        removeNode(node);
        addToHead(node);
    }
}
