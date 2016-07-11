package Othello;

public class MasterEvaluation implements Evaluation {

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
		// TODO Auto-generated method stub
		double score=0;
		final int RANDOM_WEIGHT=5; // weight factor
		
		//System.out.println(""+"Intial Score : "+score);
		
		if(currentPlayer==1)
		{
		if(GameState.cEvalPlayer1[0]==1)
		{
			
		MaximumDisksEvaluation ob = new MaximumDisksEvaluation();
		score = score+ob.evaluate(board, currentPlayer);
		//System.out.println(""+"in black"+currentPlayer+" "+score+" "+GameState.cEvalPlayer1[0]+" "+GameState.cEvalPlayer1[1]);
		}
		
		if(GameState.cEvalPlayer1[1]==1)
		{
		CornerEvaluation ob1 = new CornerEvaluation();
		score = score+ob1.evaluate(board, currentPlayer);
		}
		
		if(GameState.cEvalPlayer1[2]==1)
		{
		EvaporationEvaluation ob2 = new EvaporationEvaluation();
		score = score+ob2.evaluate(board, currentPlayer);
		}
		
		if(GameState.cEvalPlayer1[3]==1)
		{
		MobilityEvaluation ob3 = new MobilityEvaluation();
		score = score+ob3.evaluate(board, currentPlayer);
		}
		
		if(GameState.cEvalPlayer1[4]==1)
		{
		PositionalEvaluation ob4 = new PositionalEvaluation();
		score = score+ob4.evaluate(board, currentPlayer);
		}
		
		if(GameState.cEvalPlayer1[5]==1)
		{
		CornerClosenessEvaluation ob5 = new CornerClosenessEvaluation();
		score = score+ob5.evaluate(board, currentPlayer);
		}
		
		if(GameState.cEvalPlayer1[6]==1)
		{
		FrontierEvaluation ob6 = new FrontierEvaluation();
		score = score+ob6.evaluate(board, currentPlayer);
		}
		
		if(GameState.cEvalPlayer1[7]==1)
		{
		principalFunc ob7 = new principalFunc();
		score = score+ob7.evaluate(board, currentPlayer);
		}
		
		if(GameState.cEvalPlayer1[8]==1)
		{
		IOthello ob8 = new IOthello();
		score = score+ob8.evaluate(board, currentPlayer);
		}
		}
		else if(currentPlayer==-1)
		{
			if(GameState.cEvalPlayer2[0]==1)
			{
			MaximumDisksEvaluation ob = new MaximumDisksEvaluation();
			score = score+ob.evaluate(board, currentPlayer);
			}
			
			if(GameState.cEvalPlayer2[1]==1)
			{
			CornerEvaluation ob1 = new CornerEvaluation();
			score = score+ob1.evaluate(board, currentPlayer);
			}
			
			if(GameState.cEvalPlayer2[2]==1)
			{
			EvaporationEvaluation ob2 = new EvaporationEvaluation();
			score = score+ob2.evaluate(board, currentPlayer);
			}
			
			if(GameState.cEvalPlayer2[3]==1)
			{
			MobilityEvaluation ob3 = new MobilityEvaluation();
			score = score+ob3.evaluate(board, currentPlayer);
			}
			
			if(GameState.cEvalPlayer2[4]==1)
			{
			PositionalEvaluation ob4 = new PositionalEvaluation();
			score = score+ob4.evaluate(board, currentPlayer);
			}	
			
			if(GameState.cEvalPlayer2[5]==1)
			{
			CornerClosenessEvaluation ob5 = new CornerClosenessEvaluation();
			score = score+ob5.evaluate(board, currentPlayer);
			}
			
			if(GameState.cEvalPlayer2[6]==1)
			{
			FrontierEvaluation ob6 = new FrontierEvaluation();
			score = score+ob6.evaluate(board, currentPlayer);
			}
			if(GameState.cEvalPlayer2[7]==1)
			{
			principalFunc ob7 = new principalFunc();
			score = score+ob7.evaluate(board, currentPlayer);
			}
			
			if(GameState.cEvalPlayer2[8]==1)
			{
			IOthello ob8 = new IOthello();
			score = score+ob8.evaluate(board, currentPlayer);
			}
		}
		//System.out.println(""+currentPlayer+" "+score);
		score = score + (Math.random() * RANDOM_WEIGHT);
		return score;
	}

}
