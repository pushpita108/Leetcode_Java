class MyHashMap {
    
    class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
    }
    
    //Have an array of list nodes, separate chaining to handle collision 
    ListNode[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new ListNode[10000];
    }
    
    public int hash(int key){ // HASH 
        return Integer.hashCode(key) % arr.length;
    }
    
    public ListNode find(ListNode n, int key){ // FIND 
        ListNode prev = null;
        while( n!= null && n.key != key ){
            prev = n;
            n = n.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // System.out.println("put" + key + " : " + value);
        int h = hash(key);
        if( arr[h]==null ) {
            arr[h] = new ListNode(key, value);
            return;
        }
        if( arr[h].key == key ){
            arr[h].val = value; 
            return;
        }
        
        ListNode pos = find( arr[h], key );
        if( pos.next != null ) {
            pos.next = new ListNode(key, value); //add
        } else {
            pos.next.val = value; // update 
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // System.out.println("get" + key);
        int h = hash(key);
        if( arr[h]==null ) return -1;
        if( arr[h].key == key ) return arr[h].val;
        
        ListNode n = find(arr[h], key);
        return n.next == null ? -1 : n.next.val;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // System.out.println("rem" + key );
        int h = hash(key);
        if( arr[h]==null ) return;
        if( arr[h].key == key ){ 
            if( arr[h].next == null ) {
                arr[h] = null ;
                return;
            }
            arr[h].next = arr[h].next.next;
            return;
        }
        
        ListNode n = find(arr[h], key);
        if( n.next == null ) return;
        
        n.next = n.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */