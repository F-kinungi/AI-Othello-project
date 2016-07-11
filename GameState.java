package Othello;


import java.util.ArrayList;


public class GameState {
	
	 static int Empty=0,Black=1,White=-1;
	 static int playerTurn;
	 static int[][] board = new int[8][8];
	 static boolean direction[]={false,false,false,false,false,false,false,false}; // directions set to false to indicate the possible moves
	 static int upper=0,lower=1,right=2,left=3,upperleft=4,upperright=5,
	            lowerright=6,lowerleft=7; // directions to check the possible moves
     static int[] cEvalPlayer1 = new int[9];
     static int[] cEvalPlayer2 = new int[9];
     static String[] evalFuncs = {"Maximum Disks Startegy","Corner Evaluation Startegy","Evaporation Startegy", "Mobility Startegy", "Positional Startegy" , "Corner Closeness Startegy", "Frontier Startegy", "Principal Startegy", "IOthello Startegy"};
     static long counter=0;
     static int gameMode;
}
