class MyHashMap {

    /** Initialize your data structure here. */
    class Node{
        int key;
        Integer value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    Node[] list;
    
    public MyHashMap() {
        list = new Node[10000];
    }
    
    public int getHashCode(int key){
        return Integer.hashCode(key) % list.length;    
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = getHashCode(key);
        if( list[h] == null ){ //key does not have a value yet 
            list[h] = new Node(key, value);
            return;
        }
        
        //If there is already a value, start separate chaining
        Node pos = list[h];
        while( pos != null && pos.key!= key ){
            pos = pos.next;
        }
        if( pos!= null ){
            pos.value = value;
        } else {
            pos = new Node(key, value);
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = getHashCode(key);
        if( list[h] == null) return -1;//not found
        
        Node pos = list[h];
        while( pos != null && pos.key != key) {
            pos = pos.next;
        }
        return (pos!=null && pos.key==key) ? pos.value : -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = getHashCode(key);
        if( list[h] == null) return;//not found
        if( list[h].key == key){ // only one value present
            list[h] = null;
            return;
        }
        
        Node pos = list[h]; //skip the node from next list
        Node prev = null;
        while( pos != null && pos.key != key) {
            prev = pos;
            pos = pos.next;
        }
        if ( pos!=null && pos.key==key ) {
            prev.next = pos.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */