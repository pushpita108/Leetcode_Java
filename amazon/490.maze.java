class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int r = maze.length;
        int c = maze[0].length;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[r][c];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        
        // BFS - queue
        que.add(start);
        visited[start[0]][start[1]] = true;
        while( !que.isEmpty() ){
            int[] loc = que.remove();
            if( loc[0] == destination[0] && loc[1] == destination[1]) return true;
            
            for(int[] d : dirs){
                int newX = loc[0] + d[0];
                int newY = loc[1] + d[1];
                while( newX>=0 && newY>=0 && newX<r && newY<c && maze[newX][newY]==0 ) {
                    newX += d[0];
                    newY += d[1];
                }
                
                if( !visited[newX-d[0]][newY-d[1]] ){
                    que.add(new int[] {newX-d[0], newY-d[1]});
                    visited[newX-d[0]][newY-d[1]] = true;
                }
            }   
        }
        return false;
    }
}