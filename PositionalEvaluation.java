package Othello;

public class PositionalEvaluation implements Evaluation {

    public double evaluate(int board[][], int currentPlayer){
          
       
        double score=0;
        
        int positionalmatrix [][]=
       {{ 100, -10, 11, 6, 6, 11, -10,  100,},
        {-10, -20,  1, 2, 2,  1, -20, -10,},
        { 10,   1,  5, 4, 4,  5,   1,  10,},
        {  6,   2,  4, 2, 2,  4,   2,   6,},
        {  6,   2,  4, 2, 2,  4,   2,   6,},
        { 10,   1,  5, 4, 4,  5,   1,  10,},
        {-10, -20,  1, 2, 2,  1, -20, -10,},
        { 100, -10, 11, 6, 6, 11, -10,  100}}; 
        
        
        for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    
                    	
         if(board[i][j]==-currentPlayer)
         score = score - positionalmatrix[i][j];
         else if(board[i][j]==currentPlayer)
         score = score + positionalmatrix[i][j];

                        }
                }
        
        
        
        return (10 * score);
        
}              
	
}
