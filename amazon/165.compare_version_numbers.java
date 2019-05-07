class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int i=0, j=0;
        while( i<v1.length && j<v2.length ){
            int a = Integer.parseInt( v1[i] );
            int b = Integer.parseInt( v2[j] );
            
            if( a < b ){
                return -1;
            }else if( a > b ){
                return 1;
            }
            i++;
            j++;
        }
        
        if( v1.length > i){
            return 1;
        }else if( v2.length > j ){
            return -1;
        }
        
        return 0;
    }
}