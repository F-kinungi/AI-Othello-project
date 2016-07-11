package Othello;

public class FrontierEvaluation implements Evaluation {

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
		// TODO Auto-generated method stub
		  double opponent = 0;
          double computer = 0;
          int x,y;
          
          int X1[] = {-1, -1, 0, 1, 1, 1, 0, -1};
          int Y1[] = {0, 1, 1, 1, 0, -1, -1, -1};
          for(int i=0; i<8; i++)
        	  for(int j=0; j<8; j++) {
          
          if(board[i][j] != GameState.Empty) {
        	  for(int k=0; k<8; k++) {
        	  x = i + X1[k]; y = j + Y1[k];
        	  if(x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == GameState.Empty) {
        	  if(board[i][j] == currentPlayer) computer++;
        	  else if(board[i][j] == -currentPlayer)  opponent++;
        	  break;
        	  } 
        	  }
          
          }}
		return (74.396 *(opponent - computer));
	}

}
