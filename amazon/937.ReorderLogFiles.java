class Solution {
    
    public String[] reorderLogFiles(String[] logs) {
                
        Arrays.sort( logs, (a,b) -> {
            String[] s1 = a.split(" ", 2); // split into 2 parts after first occurence 
            String[] s2 = b.split(" ", 2);
            boolean d1 = Character.isDigit(s1[1].charAt(0));
            boolean d2 = Character.isDigit(s2[1].charAt(0));
            if( !d1 && !d2 ){
                return (s1[1].compareTo(s2[1]) == 0) ?
                        s1[0].compareTo(s2[0]) :
                        s1[1].compareTo(s2[1]);
            }
            // a is digit and b is not digit then return -1, indicating a < b 
            return d1 ? (d2 ? 0 : 1) : -1;
        });
        
        return logs;
        
    }
}