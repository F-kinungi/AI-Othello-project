package Othello;

public class principalFunc implements Evaluation{

	@Override
	public double evaluate(int[][] board, int currentPlayer) {
		// TODO Auto-generated method stub
	
	double score;	
	final int RANDOM_WEIGHT=5; // weight factor
	
	MaximumDisksEvaluation ob = new MaximumDisksEvaluation();
	CornerEvaluation ob1 = new CornerEvaluation();
	CornerClosenessEvaluation ob2 = new CornerClosenessEvaluation();
	FrontierEvaluation ob3 = new FrontierEvaluation();
	StabilityEvaluation ob4 = new StabilityEvaluation();
	PositionalEvaluation ob5 = new PositionalEvaluation();
	MobilityEvaluation ob6 = new MobilityEvaluation();
	
	score = ob.evaluate(board, currentPlayer) + ob1.evaluate(board, currentPlayer) +  ob2.evaluate(board, currentPlayer) +  ob6.evaluate(board, currentPlayer) +  ob3.evaluate(board, currentPlayer) + ob5.evaluate(board, currentPlayer) ;  
	
	return score;
	
	}

}
