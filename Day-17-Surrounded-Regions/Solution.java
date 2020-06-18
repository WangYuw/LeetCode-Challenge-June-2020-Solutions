/**
 * Day 17 - Surrounded Regions
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * Example:
 *  X X X X
 *  X O O X
 *  X X O X
 *  X O X X
 * After running your function, the board should be:
 *  X X X X
 *  X X X X
 *  X X X X
 *  X O X X
 * Explanation:
 *  Surrounded regions shouldn’t be on the border, 
 *  which means that any 'O' on the border of the board are not flipped to 'X'. 
 *  Any 'O' that is not on the border and 
 *  it is not connected to an 'O' on the border will be flipped to 'X'. 
 *  Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * */

class Solution {
   boolean[][] visited;
    public void solve(char[][] board) {
        if(board.length == 0) return;
        visited = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++) {   // Run dfs on left and right borders and change '0's to '#'
            dfs(board, i, 0, visited);
            dfs(board, i, board[0].length-1, visited);
        }
        
        for(int j=1;j<board[0].length-1;j++) { // Run dfs on top and bottom borders and change '0's to '#'
            dfs(board, 0, j, visited);
            dfs(board, board.length-1, j, visited);
        }
        
        for(int i=0;i<board.length;i++) 
            for(int j=0;j<board[0].length;j++) 
                if(board[i][j] == 'O')      // Change surrounded '0' to 'X'
                    board[i][j] = 'X';
                else if(board[i][j] == '#')    // Change '#' (not surrounded) back to '0'
                    board[i][j] = 'O';
    }
    
    public void dfs(char[][] board,int i,int j,boolean[][] visited) {
        if(i>=0 && i < board.length && j>=0 && j<board[0].length && !visited[i][j] && board[i][j] == 'O') {
            visited[i][j] = true;
            board[i][j] = '#';
            dfs(board,i+1,j,visited);
            dfs(board,i-1,j,visited);
            dfs(board,i,j+1,visited);
            dfs(board,i,j-1,visited);
        }
    }
}