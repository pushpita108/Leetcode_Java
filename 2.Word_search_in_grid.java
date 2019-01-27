class Solution {

    public boolean dfs(char[][] board, int x, int y, char[] wordarr, int pos){
        if( pos == wordarr.length) return true; // word search completed 
        if( x<0 || y<0 || x>=board.length || y>=board[0].length) return false;
        if( wordarr[pos] != board[x][y]) return false;
        board[x][y] ^= 256; // mark as visited
        boolean result = dfs(board, x+1, y, wordarr, pos+1) || dfs(board, x-1, y, wordarr, pos+1) || dfs(board, x, y+1, wordarr, pos+1) || dfs(board, x, y-1, wordarr, pos+1);
        board[x][y] ^= 256;
        return result;
    }
    public boolean exist(char[][] board, String word) {
        boolean result;
        char[] wordarr = word.toCharArray();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                result = dfs(board, i, j, wordarr, 0);
                if(result) return true;
            }
        }
        return false;
    }
}