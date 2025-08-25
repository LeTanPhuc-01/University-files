public class NQueen {
    public static int n = 5;
    int [] q = new int[n];
    
    public boolean isValid(int row2, int col2){
        //init to compare with placed queens
        int row1, col1;
        for(row1 = 0; row1 < row2; row1++){
            col1 = q[row1];
            if(col1 == col2 || Math.abs(row1 - row2) == Math.abs(col1 - col2)){
                return false;
            }
        }
        return true;

    }
    boolean placeQueen(int[][] board, int row){
        if(row == n) return true;
        //iterate over every col
        for(int col = 0; col < n; col++){
            //checks isValid
            if(isValid(row, col)){
                //update the board and placed queen array
                q[row] = col;
                board[row][col] = 1;
                //continue to check the rest of the board 
                if(placeQueen(board, row + 1)){
                    return true;
                }
                else{
                    //backtracks
                    board[row][col] = 0;
                }
            }    
        }
        return false;

    }

    void printNQueenBoard(int[][] board){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        int[][] board = new int[n][n];
        NQueen nQueen = new NQueen();
        if(!nQueen.placeQueen(board, 0)){
            System.out.println("None of the queens are placeable");
        }

        nQueen.printNQueenBoard(board);
        
    }
}
