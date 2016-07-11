package Othello;

public class CornerClosenessEvaluation implements Evaluation {

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
		
		double opponent = 0;
		double computer = 0;
		
		if(board[0][0] == 0) {
			if(board[0][1] == currentPlayer) computer++;
			else if(board[0][1] == -currentPlayer) opponent++;
			if(board[1][1] == currentPlayer) computer++;
			else if(board[1][1] == -currentPlayer) opponent++;
			if(board[1][0] == currentPlayer) computer++;
			else if(board[1][0] == -currentPlayer) opponent++;
			}
			if(board[0][7] == 0) {
			if(board[0][6] == currentPlayer) computer++;
			else if(board[0][6] == -currentPlayer) opponent++;
			if(board[1][6] == currentPlayer) computer++;
			else if(board[1][6] == -currentPlayer) opponent++;
			if(board[1][7] == currentPlayer) computer++;
			else if(board[1][7] == -currentPlayer) opponent++;
			}
			if(board[7][0] ==  0) {
			if(board[7][1] == currentPlayer) computer++;
			else if(board[7][1] == -currentPlayer) opponent++;
			if(board[6][1] == currentPlayer) computer++;
			else if(board[6][1] == -currentPlayer) opponent++;
			if(board[6][0] == currentPlayer) computer++;
			else if(board[6][0] == -currentPlayer) opponent++;
			}
			if(board[7][7] == 0) {
			if(board[6][7] == currentPlayer) computer++;
			else if(board[6][7] == -currentPlayer) opponent++;
			if(board[6][6] == currentPlayer) computer++;
			else if(board[6][6] == -currentPlayer) opponent++;
			if(board[7][6] == currentPlayer) computer++;
			else if(board[7][6] == -currentPlayer) opponent++;
			}
			return (382.026 *(-12.5 * (computer - opponent)));

	}

}
