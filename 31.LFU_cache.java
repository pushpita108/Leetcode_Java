import java.util.*;

class LFUCache {
    HashMap<Integer, Integer> vals; //key and value
    HashMap<Integer, Integer> counts; //Key and count of number of times key is used
    HashMap<Integer, LinkedHashSet<Integer>> lists; //Count and Set of Keys
    int capacity;
    int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());    
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if(count == min && lists.get(count).size() == 0)
            min++;
        if(!lists.containsKey(count + 1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity <= 0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if(vals.size() >= capacity) {
            int rmv = lists.get(min).iterator().next();
            lists.get(min).remove(rmv);
            vals.remove(rmv);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}