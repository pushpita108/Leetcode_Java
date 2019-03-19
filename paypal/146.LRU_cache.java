
import java.util.*;

class ListNode {
    int key, value;
    ListNode next, prev;

    public ListNode(int key, int val) {
        this.key = key;
        value = val;
        next = null;
        prev = null;
    }
}

class CustomLinkedList {
    ListNode head, tail;

    public CustomLinkedList() {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public ListNode removeFromTail() {
        ListNode item = tail.prev;
        if(item == head) {
            return null;
        }
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return item;
    }

    public void removeAndAddToHead(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

class LRUCache {
    final int Capacity;
    Map<Integer, ListNode> map;
    CustomLinkedList list;

    public LRUCache(int capacity) {
        Capacity = capacity;
        map = new HashMap<Integer, ListNode>();
        list = new CustomLinkedList();  
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            list.removeAndAddToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            list.removeAndAddToHead(node);
        } else {
            if(map.keySet().size() == Capacity) {
                ListNode node = list.removeFromTail();
                map.remove(node.key);
            }
            ListNode item = new ListNode(key, value);
            list.addToHead(item);
            map.put(key, item);
        }
    }
}
