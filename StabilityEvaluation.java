package Othello;

public class StabilityEvaluation implements Evaluation {

	double opponent = 0;
	double computer = 0;
	
	@Override
	public double evaluate(int[][] board, int currentPlayer) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                    if (GameState.board[i][j] != GameState.Empty) {
                            if ( (stableDirection(i, j, 1, 0) || stableDirection( i, j, -1, 0) ) &&
                                     (stableDirection(i, j, 0, 1) || stableDirection(i, j, 0, -1) ) &&
                                     (stableDirection(i, j, 1, 1) || stableDirection(i, j, -1, -1) ) &&
                                     (stableDirection(i, j, 1, -1) || stableDirection(i, j, -1, 1) ) ) {
                           
                                    if (GameState.board[i][j] == currentPlayer) {
                                            computer++;
                                    }
                                    else if(GameState.board[i][j] == -currentPlayer) {
                                            opponent++;
                                    }
                            }
                    }
            }
    }
		return (computer-opponent);
	}
	boolean stableDirection(int i, int j, int v, int h) {
        
        int color = GameState.board[i][j];
        boolean stable = true;
        while (i+v < 8 && j+h < 8 &&
                   i+v >= 0 && j+h >= 0 &&
                   stable) {
               
                if (GameState.board[i+v][j+h] != color) {
                        stable = false;
                }
                i = i + v;
                j = j + h;
        }
        return stable;
}


}
