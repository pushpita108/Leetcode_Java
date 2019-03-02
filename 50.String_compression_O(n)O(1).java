class Solution {
    public int compress(char[] chars) {
        
        if( chars == null || chars.length == 0 ) return -1;
        
        int j=1;
        int count = 1;
        for( int i=1; i< chars.length; i++){
            if( chars[i-1] == chars[i]){
                count++;
            }else {
                if( count>1){
                    String countStr = Integer.toString(count);
                    for( int k=0; k<countStr.length(); k++ ){
                        chars[j++] =  Integer.toString(count).charAt(k);
                    }
                }
                if( j < chars.length){
                    chars[j] = chars[i];
                }else{
                    j++;
                }
                j++;
                count=1;
            }
        }
        if( count > 1){
            String countStr = Integer.toString(count);
            for( int k=0; k<countStr.length(); k++ ){
                chars[j++] =  Integer.toString(count).charAt(k);
            }
        }
        return j;
    }
}