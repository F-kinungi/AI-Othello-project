package Othello;


import java.util.ArrayList;



import Othello.GameState;

public class CheckValidPositions {

	
	public ArrayList<Move> getPossibleMoves(int wrtPlayer, int [][] board)
	{
		
		ArrayList <Move> validPosOb = new ArrayList<Move>();
		 for(int x=0; x<8; x++){
             for(int y=0; y<8; y++){
                if(checkDisc(board,x,y,wrtPlayer)==true){ // it will draw the valid moves on the board
                     
   Move ob = new Move();
   
   
   ob.atX = x;
   ob.atY = y;
   
   validPosOb.add(ob);
   
  
                }
             }
    }
		 return validPosOb;
	}
	
	
	
    public boolean checkDisc(int [][] board, int row,int col, int color){

        int x,y;

       
        for(x=0; x<8; x++){
            GameState.direction[x]=false;
        }
        
        
        
        if( board[row][col]!=0){
       
        	return false;
        }
        else{
            if(col>1&&board[row][col-1]==-color){
                for(x=col-2;x>0&&board[row][x]==-color;x--);
                if(board[row][x]==color){
        GameState.direction[GameState.left]=true;
                }
                }
            if (col< 6 && board[row][col+1] == -color) {
                 for (x = col+2; x < 7 && board[row][x] == -color; x++);
                 if (board[row][x] == color) {
                	 GameState.direction[GameState.right] = true;
                }
     
            }
            if (row > 1 && board[row-1][col] == -color) {
                for (y = row-2; y > 0 && board[y][col] == -color; y--);
                if (board[y][col] == color) {
                	GameState.direction[GameState.upper] = true;
                }
                
            }
            if (row < 6 && board[row+1][col] == -color) {
                for (y = row+2; y < 7 && board[y][col] == -color; y++);
                if (board[y][col] == color) {
                	GameState.direction[GameState.lower] = true;
                }
                
            }
            if (col > 1 && row > 1 && board[row-1][col-1] == -color) {
                for (x = row-2, y = col-2; x > 0 && y > 0 && board[x][y] == -color; x--, y--);
                if (board[x][y] == color) {
                	GameState.direction[GameState.upperleft] = true;
                }
                
            }
            if (col < 6 && row > 1 && board[row-1][col+1] == -color) {
                for (x = row-2, y = col+2; x < 7 && y > 0 && board[x][y] == -color; x++, y--);
                if (board[x][y] == color) {
                	GameState.direction[GameState.upperright] = true;
                }
            
            }
            if (col < 6 && row < 6 && board[row+1][col+1] == -color) {
                for (x = row+2, y =  col+2; x < 7 && y < 7 && board[x][y] == -color; x++, y++);
                if (board[x][y] == color) {
                	GameState.direction[GameState.lowerright] = true;
                }
               
            }
            if (col > 1 && row < 6 && board[row+1][col-1] == -color) {
                for (x = row+2, y = col-2; x > 0 && y < 7 && board[x][y] == -color; x--, y++);
                if (board[x][y] == color) {
                	GameState.direction[GameState.lowerleft] = true;
                }
              
            }
            for (x = 0; x < 8; x++){
                if (GameState.direction[x] == true){
                    return true;
                }
           
            }
            return false;
        }
    }
   
    
    public void turnDisc(int [][] board, int row, int col, int color) {

    	board[row][col] = color;

    int x,y;
    
    

    if (GameState.direction[GameState.left] == true){
      for (x = col-1; board[row][x] != color; x--){
    	  board[row][x] = - board[row][x];
      }
    }
    if (GameState.direction[GameState.right] == true){
      for (x = col + 1; board[row][x] != color; x++){
    	  board[row][x] = - board[row][x];
      }
    }
    if (GameState.direction[GameState.upper] == true){
      for (y = row - 1; board[y][col] != color; y--){
    	 
    	  board[y][col] = - board[y][col];
      }
    }
    if (GameState.direction[GameState.lower] == true){
      for (y = row + 1; board[y][col] != color; y++){
    	  
    	 
    	  board[y][col] = - board[y][col];
      }
    }
    if (GameState.direction[GameState.upperleft] == true){
      for (x = row-1, y = col-1; board[x][y] != color; x--, y--){
    	  board[x][y] = - board[x][y];
      }
    }
    if (GameState.direction[GameState.upperright] == true){
      for (x = row-1, y = col+1; board[x][y] != color; x--, y++){
    	  board[x][y] = - board[x][y];
      }
    }
    if (GameState.direction[GameState.lowerright] == true){
      for (x = row+1, y = col+1;  board[x][y] != color; x++, y++){
    	  board[x][y] = -  board[x][y];
      }
    }
    if (GameState.direction[GameState.lowerleft] == true){
      for (x = row+1, y = col-1;  board[x][y] != color; x++, y--){
    	  board[x][y] = -  board[x][y];
      }
    }
  }

	
	
}
