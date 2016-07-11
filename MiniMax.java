package Othello;

import java.util.ArrayList;



public class MiniMax {

	CheckValidPositions validPosOb =  new CheckValidPositions();
	int index=0;
    double max = Double.NEGATIVE_INFINITY;
    ArrayList<Move>	 ob; 
    
    Move moveOb;
    int currentPlayer;

    public Move miniMax(Evaluation evalOb, int depth , int wrtPlayer, int [][] tempBoardState)
	{
    	moveOb = new Move();
    	
    	if(depth==0)
        	currentPlayer = wrtPlayer;

    	if(depth == 8)
		{
	    	  double tempvalue = evalOb.evaluate(tempBoardState,currentPlayer);
	    	// System.out.println(""+tempvalue);
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
		    	moveNode.boardNode = Reversi2v.twoDimensionalArrayClone(tempBoardState);
				validPosOb.checkDisc(tempBoardState, move.atX, move.atY, wrtPlayer);
				validPosOb.turnDisc(tempBoardState, move.atX, move.atY, wrtPlayer);
		//	System.out.println(""+"Game Board");
		    	for(int i=0;i<8;i++)
		    	{
		    		for(int j=0;j<8;j++)
		    		{
		    	//		System.out.print(""+tempBoardState[i][j]+ " ");
		    		}
		   //	System.out.println();
		    	}
		    	

		    	
		    	moveOb = miniMax(evalOb, depth+1, -wrtPlayer, tempBoardState);
		    	
		    	if(firstNodeEval)
		    	{
		    		moveNode.value=moveOb.value;
		    		moveNode.atX=  move.atX;
		    		moveNode.atY = move.atY;
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
		    	
		    	
//System.out.println(""+"Game Board UnTurn");
		    	
		    	for(int i=0;i<8;i++)
		    	{
		    		for(int j=0;j<8;j++)
		    		{
		    //			System.out.print(""+tempBoardState[i][j]+ " ");
		    		}
		    //		System.out.println();
		    	}
		    	
		    	
			}
			
			 return moveNode;
			
		}
	    
	    

		
	}
    
 /*   public void unturnDisc(int row, int col , int board[][], int color, boolean []direction)
    
    {

    	board[row][col] = GameState.Empty;

    
    	
        int x,y;
        
      
        if (direction[GameState.left] == true){
          
        	
        	for (x = col-1; x>-1&&board[row][x] ==  color; x--){
        	  board[row][x] = - board[row][x];
        	}
        	 board[row][++x] = color;
        }
        
        
        if (direction[GameState.right] == true){
        	
          for (x = col+1;  x<8&&board[row][x] ==  color; x++){
        	  board[row][x] =  - board[row][x];
          }
          
          
          board[row][--x] = color;
        	
        }
        if (direction[GameState.upper] == true){
          for (y = row-1 ;  y>-1&&board[y][col] ==  color; y--){
        	 
        	  board[y][col] = - board[y][col];
          }
          
      
          board[++y][col] = color;
        	
        }
        if (direction[GameState.lower] == true){
          for (y = row+1; y<8&&board[y][col]==color; y++){
        	  
        	 
        	  board[y][col] = - board[y][col];
          }
          
         
        	
          board[--y][col] = color;
          
        	}
        
        if (direction[GameState.upperleft] == true){
        	
        	
          for (x = row-1, y = col-1; x>-1&&y>-1&&board[x][y] ==  color; x--, y--){
        	  board[x][y] = -board[x][y];
          }
          
        
          
          board[++x][++y] = color;
        	
        	
        	
        	}
        if (direction[GameState.upperright] == true){
          for (x = row-1, y = col+1; x>-1&&y<8&&board[x][y] ==  color; x--, y++){
        	  board[x][y] = -board[x][y];
          }
          
        
          
          board[++x][--y] = color;
        }
        if (direction[GameState.lowerright] == true){
        	
        	for (x = row+1, y = col+1;  x<8&&y<8&&board[x][y] ==  color; x++, y++){
        	  board[x][y] = -board[x][y];
           	
          }
          board[--x][--y] = color;
        
        }
        if (direction[GameState.lowerleft] == true){
          for (x = row+1, y = col-1;  x<8&&y>-1&&board[x][y] ==  color; x++, y--){
        	  board[x][y] = -board[x][y];
          }
          
     
          
          
          board[--x][++y] = color;
        }
    	
       
        
    }*/
    
    
	

}
