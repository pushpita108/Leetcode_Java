class Solution {
  //TWO POINTER APPROACH -> REVERSE STRING -> REVERSE EACH WORD AND HANDLE SPACES BWETWEEN WORDS -> TRIM AT END
    public String reverseWords(String s) {
      if (s == null) return null;
      
      char[] a = s.toCharArray();
      int n = a.length;

      char[] reversed = s.toCharArray();
      
      // step 1. reverse the whole string
      reverse(a, 0, n - 1);
      // step 2. reverse each word
      return reverseWords(a, n, reversed).trim();
      // step 3. clean up spaces
      //return cleanSpaces(a, n);
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
    
    // trim leading, trailing and multiple spaces
    // String cleanSpaces(char[] a, int n) {
    //   int i = 0, j = 0;
        
    //   while (j < n) {
    //     while (j < n && a[j] == ' ') j++;             // skip spaces
    //     while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
    //     while (j < n && a[j] == ' ') j++;             // skip spaces
    //     if (j < n) a[i++] = ' ';                      // keep only one space
    //   }
    
    //   return new String(a).substring(0, i);
    // }
    
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