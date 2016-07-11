package Othello;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EvalFuncConfig {
	
	
	public EvalFuncConfig(int plyr)
	{
		
		JFrame frame = new JFrame("Evaluation Function Configuration");
		// Add a window listner for close button
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.out.println(""+"here");
				frame.setVisible(false);
				
			}
		});
		// This is an empty content area in the frame
		        JPanel panel = new JPanel();
		        panel.setLayout(new FlowLayout());
		 
			        JLabel label = new JLabel("Choose required functions below : ");
			        panel.add(label);
			        JCheckBox evalFunc[] = new JCheckBox[9];
			        if(plyr==0)
			        {
			        for (int i=0;i<GameState.evalFuncs.length;i++)
			        {
			        	evalFunc[i] = new JCheckBox(GameState.evalFuncs[i]);
			           if(GameState.cEvalPlayer1[i]==1)
			        	   evalFunc[i].setSelected(true);
			           panel.add(evalFunc[i]);
			        }
			        }
			        else if(plyr==1)
			        {
			        	  for (int i=0;i<GameState.cEvalPlayer2.length;i++)
					        {
					        	 evalFunc[i] = new JCheckBox(GameState.evalFuncs[i]);
					           if(GameState.cEvalPlayer2[i]==1)
					        	   evalFunc[i].setSelected(true);
					           panel.add(evalFunc[i]);
					        }
			        }
			        
			        JButton button = new JButton();
			        button.setText("Submit Choosen Functions");
			 
			        
			        panel.add(button);
			 
			        frame.add(panel);
			        frame.setSize(250, 350);
			        frame.setLocationRelativeTo(null);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setVisible(true);
			        
			        
			        button.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	 if(plyr==0)
		 			        {
		                		 for (int i=0;i<GameState.evalFuncs.length;i++)
		     			        {
		                			 if(evalFunc[i].isSelected())
		                			 GameState.cEvalPlayer1[i]= 1;
		                			 else
		                		     GameState.cEvalPlayer1[i]= 0;
		                			 	 
		     			        }
		 			        }
		                	 else if(plyr==1)
		                	 {
		                		 for (int i=0;i<GameState.cEvalPlayer2.length;i++)
			     			        {
		                			 if(evalFunc[i].isSelected())
			                			 GameState.cEvalPlayer2[i]= 1;
			                			 else
			                		     GameState.cEvalPlayer2[i]= 0;	 
			     			        } 
		                	 }
		                	
		                	  
		                	 frame.setVisible(false);
		                }
		            });
	
	
	}
	
	
}