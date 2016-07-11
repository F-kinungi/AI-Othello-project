package Othello;

public class EvaporationEvaluation implements Evaluation{

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
	 
		double opponent = 0;
		double computer = 0;
           
        final int RANDOM_WEIGHT=10; // weight factor
           
           
           for (int i = 0; i < 8; i++) {
                   for (int j = 0; j < 8; j++) {
                       
                   	
                      if(board[i][j]==-currentPlayer)
                   		opponent++;
                      else if(board[i][j]==currentPlayer)
                   	   computer++;
                   	
                   	
                           }
                   }
           
           
           
          if(opponent+computer < 30)
           return ((opponent - computer))+ (Math.random() );
          else
           return ((computer - opponent))+ (Math.random() );
              
           
   }              
	}


