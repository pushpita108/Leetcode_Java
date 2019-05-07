class Solution {
    public int divide(int A, int B) {
        
        if (A == Integer.MIN_VALUE && B == -1) return Integer.MAX_VALUE;
        boolean sign = A<0 == B<0;

        A = A < 0 ? A : -A;
        B = B < 0 ? B : -B;

        int result = div(A,B);
        
        return sign ? result : -result;
    }
// 34 / 4 => 
    private int div(int A, int B) {
        int total = B, prev = 0, result = 0;
System.out.println(A+"/"+B+ "=>" + total + ", " + prev + ", " + result);
        while (A <= total) {
            result = result == 0 ? 1 : result+result;
            prev = total;
            total += total;
            if (total > prev) break; // overflow
        }

        return ( result == 0) ? result : result + div(A - prev, B);
    }
}