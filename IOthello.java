package Othello;

public class IOthello implements Evaluation{

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
		// TODO Auto-generated method stub
		double opponent = 0;
		double computer = 0;
           
        final int RANDOM_WEIGHT=5; // weight factor
 double score=0;
        
        int positionalmatrix [][]=
       {{-100, -50, 25, 25, 25, 25, -50,  -100,},
        {-50, -75,  50, 50, 50,  50, -75, -50,},
        { 25,   50,  75, 75, 75,  75,   50,  25,},
        { 25,   50,  75, 100, 100,  75,   50,   25,},
        { 25,   50,  75, 100, 100,  75,   50,   25,},
        { 25,   50,  75, 75, 75,  75,   50,  25,},
        {-50, -75,  50, 50, 50,  50, -75, -50,},
        {-100, -50, 25, 25, 25, 25, -50,  -100}}; 
        
           
           for (int i = 0; i < 8; i++) {
                   for (int j = 0; j < 8; j++) {
                       
                   	
                      if(board[i][j]==-currentPlayer)
                      {
                    	  opponent++;
                    	  score = score - positionalmatrix[i][j];
                      }
                    	  else if(board[i][j]==currentPlayer)
                      {
                    	 computer++;
                    	 score = score + positionalmatrix[i][j];
                      }
                   	
                           }
                   }
           if(opponent+computer < 29)
           {
        	   CornerEvaluation ob = new CornerEvaluation();
         	  CornerClosenessEvaluation ob1 = new CornerClosenessEvaluation();
         	 PositionalEvaluation ob2 = new PositionalEvaluation();
         	 FrontierEvaluation ob3 = new FrontierEvaluation();
         	MobilityEvaluation ob6 = new MobilityEvaluation();
        	   return ( ob.evaluate(board, currentPlayer) + 10* (opponent-computer)  +  ob3.evaluate(board, currentPlayer) + ob1.evaluate(board, currentPlayer) + ob2.evaluate(board, currentPlayer) + ob6.evaluate(board, currentPlayer) );
           }
           else
           {
              if(opponent+computer==64)
              {
            	  return ((computer - opponent) );
              }
              else
              {
            	  MaximumDisksEvaluation ob = new MaximumDisksEvaluation();
            		CornerEvaluation ob1 = new CornerEvaluation();
            		CornerClosenessEvaluation ob2 = new CornerClosenessEvaluation();
            		FrontierEvaluation ob3 = new FrontierEvaluation();
            		StabilityEvaluation ob4 = new StabilityEvaluation();
            		PositionalEvaluation ob5 = new PositionalEvaluation();
            		MobilityEvaluation ob6 = new MobilityEvaluation();
            		
            		score = ob.evaluate(board, currentPlayer) + ob1.evaluate(board, currentPlayer) +  ob2.evaluate(board, currentPlayer) + ob6.evaluate(board, currentPlayer) +  ob3.evaluate(board, currentPlayer) + ob5.evaluate(board, currentPlayer);  
            		
            		return score;
            		
              }
           }
	}

}
