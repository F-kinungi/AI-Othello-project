package Othello;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import Othello.GameState;


 
public class Reversi2v extends Applet {

    final int Width=280;
  
   
    protected int countBlack=0, countWhite=0;
   
    public String welcome = "Reversi Game";
    String title = "Reversi";
    
    boolean b = true;
  
    CheckValidPositions validPosOb = new CheckValidPositions();


   
    

    @Override
    public void init(){
    	//for (int i = 0; i < 4; i++) c.addItem(ef[count++]);
    	setLayout(null);
   setSize(1050, 600); 	
    	    Button startGame = new Button("Start Game");             
    	    startGame.setLocation(800,100);
    	    startGame.setSize(100,25);
    	   
    	    add(startGame);
    	    
    	    Button resetGame = new Button("Reset Game");             
    	    resetGame.setLocation(925,100);
    	    resetGame.setSize(100,25);
    	   
    	    add(resetGame);
    	    
    	    
    	    Button ch_evalplyer1 = new Button("Choose function");
            Button ch_evalplyer2 = new Button("Choose function");
    	    
    	    resetGame.disable();

    	    Label lbl_player1 = new Label("Player1:");
    	    Label lbl_player2 = new Label("Player2:");
    	    lbl_player1.setLocation(440, 100);
    	    lbl_player2.setLocation(610,100);

    	    lbl_player1.setSize(50, 20);
    	    lbl_player2.setSize(50, 20);
        	add(lbl_player1); add(lbl_player2); 

    	
    	
        	Choice ch_player1 = new Choice();
            Choice ch_player2 = new Choice();
            
            
            
            ch_player1.setLocation(500, 100);
            ch_player2.setLocation(665,100);
            
            ch_evalplyer1.setSize(90,25);
            
            ch_evalplyer2.setSize(90,25);
            
            ch_evalplyer1.setLocation(505, 140);
            ch_evalplyer2.setLocation(670, 140);

            ch_player1.add("Human");ch_player1.add("Computer");
            ch_player2.add("Human");ch_player2.add("Computer");
            


            add(ch_player1); add(ch_player2);
            add(ch_evalplyer1); add(ch_evalplyer2);
           
            ch_evalplyer1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                if(ch_player1.getSelectedIndex()==0)
                {
                	JOptionPane.showMessageDialog(null, "It has been selected as human player, No need of evaluation function");
                }
                else
                {
                	new EvalFuncConfig(0);
                }
                
                }
            });
            
            
            ch_evalplyer2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(ch_player2.getSelectedIndex()==0)
                    {
                    	JOptionPane.showMessageDialog(null, "It has been selected as human player, No need of evaluation function");
                    }
                	else
                	{
                		new EvalFuncConfig(1);
                	}
                }
            });
            
            
            resetGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	 ch_player1.enable();
                     ch_player2.enable(); 		
                     startGame.enable();
                     resetGame.disable();
                     GameState.board = new int[8][8];
                     GameState.board[3][3]=GameState.Black; GameState.board[4][3]=GameState.White;
                     GameState.board[3][4]=GameState.White; GameState.board[4][4]=GameState.Black;
                     countDisc();
                     
                     GameState.playerTurn=GameState.Black;
                     repaint();
                }
            });
            startGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                
                	
                	
                if(ch_player1.getSelectedIndex()==0&&ch_player2.getSelectedIndex()==0)
                {
                	GameState.gameMode=1;
                }
                	else if(ch_player1.getSelectedIndex()==0&&ch_player2.getSelectedIndex()==1)
                	{
                		
                		int h=0;
                	for(h=0;h<GameState.cEvalPlayer2.length;h++)
                	{
                		if(GameState.cEvalPlayer2[h]==1)
                			break;
                	}
                	if(h==GameState.cEvalPlayer2.length)
                	{
                		JOptionPane.showMessageDialog(null, "Please choose evaluation function for player2");
                	GameState.gameMode=1;
                	}
                	else
                	{
                		System.out.println(""+"here");
                		GameState.gameMode=2;
                	}
                	
                	}
                		else if(ch_player1.getSelectedIndex()==1&&ch_player2.getSelectedIndex()==0)
                {
                			int h=0;
                        	for(h=0;h<GameState.cEvalPlayer1.length;h++)
                        	{
                        		if(GameState.cEvalPlayer1[h]==1)
                        			break;
                        	}
                        	if(h==GameState.cEvalPlayer1.length)
                        	{
                        		JOptionPane.showMessageDialog(null, "Please choose evaluation function for player1");
                        	GameState.gameMode=1;
                        	}
                        	else
                        	{
                        		GameState.gameMode=3;
                        		playFor(-1, -1);
                        	}
                	
                }
                	else if(ch_player1.getSelectedIndex()==1&&ch_player2.getSelectedIndex()==1)
                {
                	
                

        			int h=0;
                	for(h=0;h<GameState.cEvalPlayer1.length;h++)
                	{
                		if(GameState.cEvalPlayer1[h]==1)
                			break;
                	}
                
                	if(h==GameState.cEvalPlayer1.length)
                	{
                		JOptionPane.showMessageDialog(null, "Please choose evaluation function for player1");
                	GameState.gameMode=1;
                	}
                	else
                	{
                		 h=0;
                     	for(h=0;h<GameState.cEvalPlayer2.length;h++)
                     	{
                     		if(GameState.cEvalPlayer2[h]==1)
                     			break;
                     	}
                     	if(h==GameState.cEvalPlayer2.length)
                     	{
                     		JOptionPane.showMessageDialog(null, "Please choose evaluation function for player2");
                     	GameState.gameMode=1;
                     	}
                     	else
                     	{
                     		GameState.gameMode=4;
                        	playFor(-1, -1);
                     	}
                     	
                	}
        	
                
                
                }
                ch_player1.disable();
                ch_player2.disable();
                startGame.disable();
                resetGame.enable();
                }
            });
          
            
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
            	GameState.board[x][y]=GameState.Empty;
            }
        }
        GameState.board[3][3]=GameState.Black; GameState.board[4][3]=GameState.White;
        GameState.board[3][4]=GameState.White; GameState.board[4][4]=GameState.Black;
        countDisc();
    
          GameState.playerTurn=GameState.Black;
    }


 
    public void drawBoard(Graphics g){
    	
    	if(b)
    	{

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
         
            	test(evt);
            }
        });
    	b= false;
    	}
        setBackground(Color.LIGHT_GRAY);
 
        g.setColor(Color.black);
        g.drawLine(0, 0, 0, Width);// left line vertical
        g.drawLine(Width, 0, Width, Width);//rigth line vertical
        g.drawLine(0, 0, Width, 0);//top line horizontal
        g.drawLine(0, Width, Width, Width); //bottom line horizontal

        for(int x=1; x<8; x++){
            g.drawLine(Width*x/8, 0, Width*x/8, Width);//draw vertical lines exact 8 columns
            g.drawLine(0,Width*x/8, Width, Width*x/8);//draw horizontal lines by 8
        }
    }
    public void drawDisc(int row, int col, Graphics g){

    	
    	
        if(GameState.board[row][col]==GameState.Black){
            g.setColor(Color.black);
        }else if(GameState.board[row][col]==GameState.White){
            g.setColor(Color.white);
        }
        // fills the oval in the cordanatedesired and seeting the widht and height of the oval
        g.fillOval( col*Width/8,row*Width/8,
                Width/8, Width/8);
    }

    public void test(java.awt.event.MouseEvent evt )
    {

        int x = evt.getX();
        int y = evt.getY();
       
        playFor(y, x);
     
    }



    @Override
    public void paint(Graphics g){
 
        drawBoard(g);
        
       
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                if(GameState.board[x][y] !=0){
                    drawDisc(x,y,g);// draw the discs on the desired place
                }
            }
        }
        drawTurn(g);
        drawCountDisc(g);
        drawValidDiscs(g);
    }

    public void drawTurn(Graphics g){

        String black="Black";
        String white="White";
        String pTurn="Player's Turn";

        g.setColor(Color.black);

        if(GameState.playerTurn==GameState.Black){

            g.drawString(black + pTurn, Width/2, Width+35);
            g.setColor(Color.black);
            showStatus("Player 1 Turn");
        }
        else{
            g.drawString(white + pTurn, Width/2, Width+35);
            g.setColor(Color.white);
            showStatus("Player 2 Turn");
        }
        g.fillOval(Width/2-20, Width+20, 20, 20);
        
    }

    public void drawCountDisc(Graphics g){

        g.setColor(Color.white);// sets the color of the oval
        g.fillOval(Width+5, 160, 20, 20); // fills the oval at certain position
        g.setColor(Color.black);// sets the color of the oval
        g.fillOval(Width+5, 100, 20, 20);
        g.drawString("Black", Width+30, 115);
        g.drawString("White", Width+30, 175);
        g.drawString(Integer.toString(countBlack), Width+20, 145);
        g.drawString(Integer.toString(countWhite), Width+20, 205);

  }
    public void drawValidDiscs(Graphics g){
    	
   
    
    for(int x=0; x<8; x++){
             for(int y=0; y<8; y++){
                if(validPosOb.checkDisc(GameState.board,x,y,GameState.playerTurn)==true){ // it will draw the valid moves on the board
                     
   
        
        // fills the oval in the cordanatedesired and seeting the widht and height of the oval
        
        g.setColor(Color.RED);
        g.drawOval(y*Width/8, x*Width/8,
                Width/8, Width/8);
                }
             }
    }
    
        
    }

    public void countDisc(){

        countBlack=0;
        countWhite=0;

        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                if(GameState.board[x][y]==GameState.Black)
                    countBlack++;
                if(GameState.board[x][y]==GameState.White)
                    countWhite++;
            }
        }
         }

    public boolean winner(){

   
        if(countBlack>countWhite){
            JOptionPane.showMessageDialog(null, "Black Wins");
        }else if(countBlack<countWhite){
            JOptionPane.showMessageDialog(null, "White Wins");
        }else{
            JOptionPane.showMessageDialog(null, "Draw Game");
        }
        repaint(); // it will paint again the game when the game ends
        return true;

    }
   

    
    public void playFor(int x, int y){

        int row=(int)(x/(Width/8));
        int col=(int)(y/(Width/8));
     //   System.out.println(""+"Row : "+row+"Col :"+col);
        
   //     System.out.println(""+"GameState.gameMode : "+ GameState.gameMode);
        
   if(row<8&&col<8)
   {
 
        
        if(GameState.gameMode==1){
        	
        	int counter=0;
       		for(int x1=0; x1<8; x1++){
                for(int y1=0; y1<8; y1++){
                   if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                        
      
           counter++;
           
                   }
                }
       		}
       	
       	 if(GameState.playerTurn==GameState.Black){
       		
       		if(counter!=0)
       		{
   
           

                if(validPosOb.checkDisc(GameState.board, row,col,GameState.playerTurn)==true){
                	validPosOb.turnDisc(GameState.board,row,col,GameState.playerTurn);
                	GameState.playerTurn = - GameState.playerTurn;  
                    countDisc();
                    update(getGraphics());

                }
            }
       		
                else
                {

               	    counter=0;
               		for(int x1=0; x1<8; x1++){
                        for(int y1=0; y1<8; y1++){
                           if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                
              
                   counter++;
                   
                           }
                        }
               		
               	}
               		if(counter==0)
               		{
               			countDisc();
                  		 update(getGraphics());
               			winner();
               		System.out.println(""+"and value 2");
               			GameState.gameMode=0;
                        init();
                   }
               		else
               		{
               			
               		JOptionPane.showMessageDialog(null, "Turn passed to white player as their are no legal moves..!!");
               		GameState.playerTurn=-GameState.playerTurn;
                  	 countDisc();
                       update(getGraphics());
                       
               		}
               	
                
                }
        
       		}
       		
       		else if (GameState.playerTurn == GameState.White) {
          
            	
            	 counter=0;
           		for(int x1=0; x1<8; x1++){
                    for(int y1=0; y1<8; y1++){
                       if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                            
          
               counter++;
               
                       }
                    }
           		}
           	
           		
           		if(counter!=0)
           		{
            	
                if(validPosOb.checkDisc(GameState.board, row,col,GameState.playerTurn)==true){
                	validPosOb.turnDisc(GameState.board,row,col,GameState.playerTurn);
                	GameState.playerTurn = - GameState.playerTurn;
                	countDisc();
                    update(getGraphics());
                }
           		}
                else{

                counter=0;
               		for(int x1=0; x1<8; x1++){
                        for(int y1=0; y1<8; y1++){
                           if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                
              
                   counter++;
                   
                           }
                        }
               		
               	}
               		if(counter==0)
               		{
               			countDisc();
               		 update(getGraphics());
               			winner();
               		System.out.println(""+"and value");
               			GameState.gameMode=0;
                        init();
                   }
               		else
               		{
               			
               		JOptionPane.showMessageDialog(null, "Turn passed to white player as their are no legal moves..!!");
               		GameState.playerTurn=-GameState.playerTurn;
                  	 countDisc();
                       update(getGraphics());
                       
               		}
               	
                }
            }
            
       	 System.out.println(""+countBlack+" "+countWhite);
       	 if(countBlack+countWhite==64){
             winner();
             GameState.gameMode=0;
             init();
           
         }
        }
   
        else if(GameState.gameMode==2) 
        {
     

            if(GameState.playerTurn==GameState.Black){
           // 	System.out.println(""+"turn "+validPosOb.checkDisc(GameState.board,row,col,GameState.playerTurn));
              
            	
            	int counter=0;
           		for(int x1=0; x1<8; x1++){
                    for(int y1=0; y1<8; y1++){
                       if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                            
          
               counter++;
               
                       }
                    }
           		}
           	
           		
           		if(counter!=0)
           		{
            	
           		if(validPosOb.checkDisc(GameState.board,row,col,GameState.playerTurn)==true){
                	validPosOb.turnDisc(GameState.board,row,col,GameState.playerTurn);
                	GameState.playerTurn = - GameState.playerTurn;
                	countDisc();
                    update(getGraphics());
   
                }
           		}
                else
               	{
               		counter=0;
               		for(int x1=0; x1<8; x1++){
                        for(int y1=0; y1<8; y1++){
                           if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                
              
                   counter++;
                   
                           }
                        }
               		
               	}
               		if(counter==0)
               		{
               			countDisc();
                  		 update(getGraphics());
               			winner();
               			GameState.gameMode=0;
                        init();
                   }
               		else
               		{
               			
               		JOptionPane.showMessageDialog(null, "Turn passed to computer as their are no legal moves..!!");
               		
                  	 countDisc();
                       update(getGraphics());
                       playFor(-1, -1);
                       
               		}
               	}
            }
            if (GameState.playerTurn == GameState.White) {
            
            	
         //MiniMax obj = new MiniMax();
         //	Move moveOb = obj.miniMax(0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board));
          AlphaBeta obj = new AlphaBeta();
           Move moveOb = obj.alphaBeta(new MasterEvaluation(), 0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
          //  	 System.out.println(""+"Coin At : " +row +" "+col);
           // 	System.out.println(""+"final value"+moveOb.value);
            //JOptionPane.showInputDialog(null, "In White : ");
            	
            	//GameState.board[moveOb.atX][moveOb.atY] = GameState.White;
            	if(validPosOb.checkDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn))
            	{
            		validPosOb.turnDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn);
            		GameState.playerTurn = - GameState.playerTurn;
            		countDisc();
                     update(getGraphics());

            	}
            	else
               	{
               		int counter=0;
               		for(int x1=0; x1<8; x1++){
                        for(int y1=0; y1<8; y1++){
                           if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                
              
                   counter++;
                   
                           }
                        }
               		
               	}
               		if(counter==0)
               		{
               			countDisc();
                  		 update(getGraphics());
               			winner();
               			GameState.gameMode=0;
                        init();
                   }
               		else
               		{
               			
               		JOptionPane.showMessageDialog(null, "Computer passes as no legal moves..!!");
               		GameState.playerTurn=-GameState.playerTurn;
                  	 countDisc();
                       update(getGraphics());
                       
               		}
               	}
                 
            }
        }
        else if(GameState.gameMode==3){

            if(GameState.playerTurn==GameState.Black){
            	//MiniMax obj = new MiniMax();
                //	Move moveOb = obj.miniMax(0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board));
                 AlphaBeta obj = new AlphaBeta();
                  Move moveOb = obj.alphaBeta(new EvaporationEvaluation(), 0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                   //	 System.out.println(""+"Coin At : " +row +" "+col);
                   //	System.out.println(""+"final value"+moveOb.value);
                   //JOptionPane.showInputDialog(null, "In White : ");
                   	
                   	//GameState.board[moveOb.atX][moveOb.atY] = GameState.White;
                   	if(validPosOb.checkDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn))
                   	{
                   		validPosOb.turnDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn);
                       GameState.playerTurn = - GameState.playerTurn;
                   		countDisc();
                        update(getGraphics());

                   	}   
                    	else
                       	{
                       		int counter=0;
                       		for(int x1=0; x1<8; x1++){
                                for(int y1=0; y1<8; y1++){
                                   if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                        
                      
                           counter++;
                           
                                   }
                                }
                       		
                       	}
                       		if(counter==0)
                       		{
                       			countDisc();
                          		 update(getGraphics());
                       			winner();
                       			GameState.gameMode=0;
                                init();
                           }
                       		
                       		else
                       		{
                       		JOptionPane.showMessageDialog(null, "Computer passes as no legal moves..!!");
                       		GameState.playerTurn=-GameState.playerTurn;
                          	 countDisc();
                               update(getGraphics());
                       		}  
                       	}
                   	
                       	}       
                        
            	
            	 
            else if (GameState.playerTurn == GameState.White) {
            
            	int counter=0;
           		for(int x1=0; x1<8; x1++){
                    for(int y1=0; y1<8; y1++){
                       if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                            
          
               counter++;
               
                       }
                    }
           		}
           	
           		
           		if(counter!=0)
           		{

            	if(validPosOb.checkDisc(GameState.board,row,col,GameState.playerTurn)==true){
                	validPosOb.turnDisc(GameState.board,row,col,GameState.playerTurn);
                    GameState.playerTurn=-GameState.playerTurn;
                    countDisc();
                    update(getGraphics());
                }
           		}
            	else
               	{
               		counter=0;
               		for(int x1=0; x1<8; x1++){
                        for(int y1=0; y1<8; y1++){
                           if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                
              
                   counter++;
                   
                           }
                        }
               		
               	}
               		if(counter==0)
               		{
               			countDisc();
                  		 update(getGraphics());
               			winner();
               			GameState.gameMode=0;
                        init();
                   }
               		else
               		{
               			
               		JOptionPane.showMessageDialog(null, "Turn passed to computer as their are no legal moves..!!");
               		GameState.playerTurn=-GameState.playerTurn;
                  	 countDisc();
                       update(getGraphics());
                       
               		}
               	}
           
         
                 
            }
        }
        else if(GameState.gameMode==4){
            while(true)
            {
            	if(GameState.playerTurn==GameState.Black){
            		
                   	
                	//MiniMax obj = new MiniMax();
                    //	Move moveOb = obj.miniMax(0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board));
                  // System.out.println(""+"Black PLayer");
            		
            		AlphaBeta obj = new AlphaBeta();
                      Move moveOb = obj.alphaBeta(new MasterEvaluation(), 0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                    //   	 System.out.println(""+"Coin At : " +row +" "+col);
                      //	System.out.println(""+"final value"+moveOb.value);
                     //  JOptionPane.showInputDialog(null, "In Black : ");
                       	
                       	//GameState.board[moveOb.atX][moveOb.atY] = GameState.White;
                       	if(validPosOb.checkDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn))
                       	{
                       		validPosOb.turnDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn);
                       	}
                       	else
                       	{
                       		int counter=0;
                       		for(int x1=0; x1<8; x1++){
                                for(int y1=0; y1<8; y1++){
                                   if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                        
                      
                           counter++;
                           
                                   }
                                }
                       		
                       	}
                       		if(counter==0)
                       		{
                       			winner();
                       			GameState.gameMode=0;
                                init();
                                break;
                       		}
                       	}
                       		
                       	GameState.playerTurn=-GameState.playerTurn;
                      	 countDisc();
                           update(getGraphics());
                       		
                       if(countBlack+countWhite==64){
                                winner();
                                GameState.gameMode=0;
                                init();
                                break;
                            }
                       		
                       		
                	
                	 }
            	
                else if (GameState.playerTurn == GameState.White) {
                
                	//MiniMax obj = new MiniMax();
                    //	Move moveOb = obj.miniMax(0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board));
                 // System.out.println(""+"White PLayer");
                	GameState.counter=0;
                	AlphaBeta obj = new AlphaBeta();
                      Move moveOb = obj.alphaBeta(new MasterEvaluation(), 0, GameState.playerTurn, twoDimensionalArrayClone(GameState.board), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                    //JOptionPane.showMessageDialog(null, "Total Number of Nodes : "+GameState.counter);
                      //   	 System.out.println(""+"Coin At : " +row +" "+col);
                    //   	System.out.println(""+"final value"+moveOb.value);
                     //  JOptionPane.showInputDialog(null, "In White : ");
                       	
                       	//GameState.board[moveOb.atX][moveOb.atY] = GameState.White;
                       	if(validPosOb.checkDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn))
                       	{
                       		validPosOb.turnDisc(GameState.board,moveOb.atX,moveOb.atY,GameState.playerTurn);
                       	}
                       		else
                       		{
                       		
                       			int counter=0;
                           		for(int x1=0; x1<8; x1++){
                                    for(int y1=0; y1<8; y1++){
                                       if(validPosOb.checkDisc(GameState.board,x1,y1,-GameState.playerTurn)==true){ // it will draw the valid moves on the board
                                            
                          
                               counter++;
                               
                                       }
                                    }
                           		
                           	}
                           		if(counter==0)
                           		{
                           			winner();
                           			GameState.gameMode=0;
                                    init();
                                    break;
                           		}
                       		
                       		}
                       			GameState.playerTurn=-GameState.playerTurn;
                       	 countDisc();
                            update(getGraphics());

                            if(countBlack+countWhite==64){
                                winner();
                                GameState.gameMode=0;
                                init();
                                break;
                            }

                     
                }
                    try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                //  JOptionPane.showMessageDialog(null, "message");
            }
            
        }
   } 
   
   }

    public static int[][] twoDimensionalArrayClone(int[][] a) {
	    int[][] b = new int[a.length][];
	    for (int i = 0; i < a.length; i++) {
	      b[i] = a[i].clone();
	    }
	    return b;
	  }
    

   
}