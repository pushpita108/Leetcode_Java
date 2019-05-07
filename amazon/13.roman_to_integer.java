class Solution {
    public int romanToInt(String s) {
        
        
          int result = 0 ;
		  char[] digits = s.toCharArray();
        
		  if(digits.length <= 0) return result;
        
          /* Initialize value map for Roman chars  */
          int[] valueMap = new int[26];
          valueMap['I' - 'A'] = 1;
          valueMap['V' - 'A'] = 5;
          valueMap['X' - 'A'] = 10;
          valueMap['L' - 'A'] = 50;
          valueMap['C' - 'A'] = 100;
          valueMap['D' - 'A'] = 500;
          valueMap['M' - 'A'] = 1000;
        
          int lastIndex = digits[0] - 'A';
          result = valueMap[lastIndex];
        
          for(int i = 1 ; i < digits.length ; i++){ // start from 1
              
              int currentIndex = digits[i] - 'A'; 
              // If previous number was smaller in value then remove the previous and decrease the current value by previous value
              // 2 * -> as example CM = 900, for C result was 100, to make CM as 900 we subtracrt the value of C added and another valeu of C as per roman guidelines 
              if(valueMap[lastIndex] < valueMap[currentIndex]){ 
                  result = result - 2*valueMap[lastIndex] + valueMap[currentIndex] ;
              }else{
                  result+= valueMap[currentIndex]; // just add the current value
              }
              lastIndex = currentIndex; // update last index
          }
		  return result;
    }
}