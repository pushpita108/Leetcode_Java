class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0; 
        HashMap<Character, Integer> map= new HashMap<Character, Integer>();
        int i=0 , j=0;
        for ( ; i < s.length() ; i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                j = Math.max(j , map.get(s.charAt(i)) + 1); // sliding the start of window to position after found repeated string
            }
            maxlen = Math.max ( maxlen , i-j+1 );
            map.put(s.charAt(i),i);
            //System.out.println(maxlen + "\t"+ i + "\t"+ j);
        }
        //System.out.println("Maximum substring length is : " + maxlen );
        return maxlen;
    }
}