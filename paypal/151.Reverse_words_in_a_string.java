class Solution {
  
    public String reverseWords(String s) {
      if (s == null) return null;
      
      char[] a = s.toCharArray();
      int n = a.length;

      char[] reversed = s.toCharArray();
      
      // step 1. reverse the whole string
      reverse(a, 0, n - 1);
      // step 2. reverse each word
      return reverseWords(a, n, reversed).trim();

    }
    
    String reverseWords(char[] a, int n, char[] reversed) {
      int i = 0, j = 0;
      int r = 0;
      while (i < n) {
        while (i < j || i < n && a[i] == ' ') i++; // skip spaces
        while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
        reverse(a, i, j - 1);                      // reverse the word

        for( int k=i; k<=j-1; k++){ // copy the word without spaces into new array 
            reversed[r++] = a[k];
        }
        if(r < n-1) {
            reversed[r++] = ' ' ;
        }
      }
      return new String(reversed).substring(0, r);

    }

    
    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
      while (i < j) {
        char t = a[i];
        a[i++] = a[j];
        a[j--] = t;
      }
    }
    
    public static void main(String args[]){

        Solution s = new Solution();
        String in = "    i    ";
        System.out.println("-----" +  s.reverseWords(in) + "=====" );
    }
  }