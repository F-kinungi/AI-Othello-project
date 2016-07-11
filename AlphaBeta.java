package Othello;

import java.util.ArrayList;



public class AlphaBeta {

	CheckValidPositions validPosOb =  new CheckValidPositions();
    
    int currentPlayer;
    ArrayList<Move>	 ob; 
 
  
    Move moveOb;

    public Move alphaBeta(Evaluation evalOb, int depth , int wrtPlayer, int [][] tempBoardState, double alpha, double beta)
	{
    	
    	moveOb = new Move();
    	if(depth==0)
    	currentPlayer = wrtPlayer;
    		
    	if(depth == 8)
		{
	    	  double tempvalue = evalOb.evaluate(tempBoardState,currentPlayer);
	    //	System.out.println(""+"Node evaluation : "+tempvalue);
	    	  moveOb.value = tempvalue;
	    	  return moveOb;
	    
		}
		else
		{
			
			ob = validPosOb.getPossibleMoves(wrtPlayer,tempBoardState);
			  if(ob==null){
             	 double tempvalue = evalOb.evaluate(tempBoardState,currentPlayer);
             	 moveOb.value = tempvalue;
                 return moveOb;
            }
			  
			boolean firstNodeEval=true;
			Move moveNode = new Move();
			for (Move move : ob) {
				//System.out.println(""+(alpha <beta));
				//System.out.println(""+(wrtPlayer==1 && alpha >beta));
				
				if(alpha <beta)
				{
					GameState.counter++;
		    	moveNode.boardNode = Reversi2v.twoDimensionalArrayClone(tempBoardState);
				validPosOb.checkDisc(tempBoardState, move.atX, move.atY, wrtPlayer);
				validPosOb.turnDisc(tempBoardState, move.atX, move.atY, wrtPlayer);
				
  ///	System.out.println(""+"Game Board");
		    	for(int i=0;i<8;i++)
		    	{
		    		for(int j=0;j<8;j++)
		    		{
		    	//		System.out.print(""+tempBoardState[i][j]+ " ");
		    		}
	//	   	System.out.println();
		    	}
		    	

		    	
		    	moveOb = alphaBeta(evalOb, depth+1, -wrtPlayer, tempBoardState, alpha, beta);
		    	
		    	if(firstNodeEval)
		    	{
		    		moveNode.value=moveOb.value;
		    		moveNode.atX=  move.atX;
		    		moveNode.atY = move.atY;
		    		if(wrtPlayer ==currentPlayer)
					{
						alpha = moveOb.value;
					}
					else
					{
						beta = moveOb.value;
					}
		    		firstNodeEval=false;
		    		
        		//System.out.println(""+"In First Node Evaluation");
		    	}
		    	else
		    	{
		    		if(wrtPlayer==currentPlayer)
		    		{
		    			if(moveNode.value<moveOb.value)
		    			{
		    				moveNode.value=moveOb.value;
		    				moveNode.atX=  move.atX;
				    		moveNode.atY = move.atY;		
				    		alpha = moveOb.value;
				    		//System.out.println(""+"In First Node Evaluation 1");
				  		  
		    			}
		    			else
		    			{
		    	  		//System.out.println(""+"In First Node Evaluation 2");
		    			} 
		    		}
		    		else
		    		{
		    			if(moveNode.value>moveOb.value)
		    			{

		    				moveNode.value=moveOb.value;
		    				moveNode.atX=  move.atX;
				    		moveNode.atY = move.atY;	
				    		beta = moveOb.value;
				      		//System.out.println(""+"In First Node Evaluation 3");
				  		  
		    			}
		    			else
		    			{
		      		//System.out.println(""+"In First Node Evaluation 4");
		    			} 
		    		}
		    		
		    	}
		    	

		    	
		    	
		    	//unturnDisc(move.atX, move.atY, tempBoardState,wrtPlayer,direction_temp);
		    	  tempBoardState = moveNode.boardNode;
		    	
		    	
		   // 	  System.out.println(""+"Game Board UnTurn");
		    	
		    	for(int i=0;i<8;i++)
		    	{
		    		for(int j=0;j<8;j++)
		    		{
		   // 		System.out.print(""+tempBoardState[i][j]+ " ");
		    		}
		  //  		System.out.println();
		    	}
		    	
			}
			}
			
			if(wrtPlayer==currentPlayer)
			{
				beta = alpha;
			}
			else
			{
				alpha = beta;
			}
			
			 return moveNode;
			
		}
	    
	    

		
	}
    
 
}
