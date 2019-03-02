class Solution {
    public int numUniqueEmails(String[] emails) {
        
        HashSet<String> uniqueEmails = new HashSet<>();
        
        for( String s : emails) {
            
            //Find index of @
            int at = s.indexOf('@');
            String name = s.substring(0, at);
            int plus = name.indexOf('+');
            if( plus >= 0){
                name = name.substring(0, plus);
            }
            name = name.replaceAll("\\.","");
            uniqueEmails.add( name + s.substring(at) );
        }
        return uniqueEmails.size();
    }
}