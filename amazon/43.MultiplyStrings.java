class Solution {
    public String multiply(String num1, String num2) {
        
        
        int len1 = num1.length(), len2 = num2.length();
        int[] num = new int[ len1 + len2 ];
        
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int temp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                
                int p1 = i+j;
                int p2 = i+j+1;
                
                num[p1] += ( temp+num[p2] )/10;
                num[p2] = ( num[p2]+temp )%10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i: num) if(sb.length()>0||i>0)  sb.append(i);
        
        return (sb.length()==0)?"0":sb.toString();
    }
}