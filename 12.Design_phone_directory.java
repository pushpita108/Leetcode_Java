class PhoneDirectory {

    HashMap<Integer, Boolean> directory = new HashMap();
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        for( int i=0; i< maxNumbers; i++){
            directory.put(i, true);
        }
        
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int r = 0;
        int i = 0;
        while( !directory.get(r) ){
            r++; i++;
            if(i == directory.size()){
                return -1;
            }
        }
        directory.put(r, false);
        return r;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return directory.get(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        directory.put(number, true);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */