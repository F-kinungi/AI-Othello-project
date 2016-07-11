package Othello;

public class CornerEvaluation implements Evaluation {

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
	    
         
         double opponentcorner=0;
         double computercorner=0;
         
     	final int RANDOM_WEIGHT=10; // weight factor
         
         
         
         for (int i = 0; i < 8; i++) {
                 for (int j = 0; j < 8; j++) {
                     
                 	if(((i==0&&j==0)||(i==0&&j==7)||(i==7&&j==0)||(i==7&&j==7))&&board[i][j]==-currentPlayer)
                 		opponentcorner++;
             
                 	else if(((i==0&&j==0)||(i==0&&j==7)||(i==7&&j==0)||(i==7&&j==7))&&board[i][j]==currentPlayer)
                		computercorner++;
                 	
                 	
                 	
                         }
                 }
         
         
         
         return (801.724 *(25*computercorner - 25*opponentcorner));
		
		
	}

}
