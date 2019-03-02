
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}


///////// O(n) space below O(1) space above


class Solution {
    public boolean backspaceCompare(String S, String T) {

        //STACK 
        
        ArrayDeque<Character> s = new ArrayDeque<>();
        ArrayDeque<Character> t = new ArrayDeque<>();
        
        for( char c : S.toCharArray() ){
            if( !s.isEmpty() && c =='#') s.pop();
            else if( c != '#' ) s.push(c);
        }
        
        for( char c : T.toCharArray() ){
            if( !t.isEmpty() && c =='#') t.pop();
            else if( c != '#' ) t.push(c);
        }
        
        if( s.size() != t.size() ) return false;
        
        for( int i=0; i<s.size(); i++){
            if( s.pop() != t.pop() ) return false;
        }
        
        return true;
        
    }
}