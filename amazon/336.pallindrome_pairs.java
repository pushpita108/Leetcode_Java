class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        
        List<List<Integer>> ret = new ArrayList<>(); 
        if (words == null || words.length < 2) return ret;
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map of string, index for fast search 
        for (int i=0; i<words.length; i++) 
            map.put(words[i], i);
        
        for (int i=0; i<words.length; i++) {

            // for every string, cut into parts and see if any oart of it is pallindrome, then search the other parts reverse in list, 
            // then then can form a palindrome word
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()" to handle case when "" is present in list
                
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString(); // reverse of other part
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) { // if present add to results
                        ret.add(Arrays.asList( map.get(str2rvs), i ));
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
                        ret.add(Arrays.asList( i, map.get(str1rvs) ));
                    }
                }
            }
        }
        return ret;
        
    }
    
    public String reverse(String word, int s, int e){
        char[] w = word.toCharArray();
        while( s < e ){
            char temp = w[s];
            w[s] = w[e];
            w[e] = temp;
        }
        return w.toString();
    }
    
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}