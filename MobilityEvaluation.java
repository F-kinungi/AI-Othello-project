package Othello;

public class MobilityEvaluation implements Evaluation {

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
		// TODO Auto-generated method stub
		 double opponent = 0;
         
		 double computer = 0;
         CheckValidPositions validPosOb = new CheckValidPositions();
		
		  for(int x1=0; x1<8; x1++){
              for(int y1=0; y1<8; y1++){
                 if(validPosOb.checkDisc(GameState.board,x1,y1,currentPlayer)==true){ 
                      
    
                	 computer++;
         
                 }
              }
		  
	}
		  
		  for(int x1=0; x1<8; x1++){
              for(int y1=0; y1<8; y1++){
                 if(validPosOb.checkDisc(GameState.board,x1,y1,-currentPlayer)==true){ 
                      
    
                	 opponent++;
         
                 }
              }
              
	}
		  return (78.922 * (computer - opponent));
}
}
