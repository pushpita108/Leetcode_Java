class RandomizedCollection {
    
    //ARRAYLIST for get random 
    // and 
    // HashMap<Value, HashSet<Indices>> for storage and retrieval 
    
    ArrayList<Integer> list = new ArrayList();
    HashMap<Integer, LinkedHashSet<Integer>> map = new HashMap();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        // simple insert into both 
        boolean result=false;
        list.add(val);
        if( !map.containsKey(val) ){
            map.put( val, new LinkedHashSet<Integer>() );
            result = true;
        }
        map.get(val).add( list.size()-1 ) ;
        return result;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        //get index of val from map 
        //get index of last element of list from map 
        //replace the elements in arraylist and the indexes in map 
        //remove the last element from arraylist
        
        if( !map.containsKey(val) ) return false;
        
        int index, indexOfLast;
        
        int lastElement = list.get(list.size()-1);
        if( lastElement == val){
            list.remove( list.size() - 1);
            return true;
        }
        
        LinkedHashSet<Integer> resultSet = map.get(val);
        index = resultSet.iterator().next();
        resultSet.remove(index); // delete val from map 
        if( resultSet.size() == 0 ){
            map.remove(val);
        }
        
  
        LinkedHashSet<Integer> replaceSet = map.get(lastElement);
        indexOfLast = replaceSet.iterator().next();
        
        list.set( index, lastElement ); //replace our index with value at last element in arraylist
        
        replaceSet.remove(indexOfLast); // update the set of indexs for last element 
        replaceSet.add(index);
        
        
        list.remove( list.size()-1 ); // remove last element from list
        return true;
                
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if( list.size() == 0) return -1;
        return list.get((int)(Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */