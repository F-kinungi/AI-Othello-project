# Othello
Project Contributors:
Sravan Kumar Meruva smeruva@gmu.edu sravanneeraj@gmail.com
Vikramaditya Nimmagadda vnimmaga@gmu.edu
Sriram Gopal sgoli@gmu.edu
Pawan Sai Mohan Kolli pkolli@gmu.edu
Karthik Gottupulla kgottupu@gmu.edu

This project is an implementation of “Othello”, a two player board game, using Minimax Algorithm and further extending it with Alpha Beta Pruning Algorithm. This program, when run on any up-to-date computer, is expected to defeat an average player. This is because although the consequences of moves are predictable for both computers and humans, computers are better at envisaging them.


1. Introduction
Human intelligence is shaped by what is most important to us—the things that cause ecstasy, despair, pleasure, pain, and other intense emotions. Artificial intelligence (AI) is the intelligence exhibited by machines or software. It is an academic field of study which studies the goal of creating intelligence. It is also defined as "the study and design of intelligent agents", where an intelligent agent is a system that perceives its environment and takes actions that maximize its chances of success. John McCarthy, who coined the term in 1955, defines it as "the science and engineering of making intelligent machines". In computer games, artificial intelligence is used to generate intelligent behaviors primarily in non-player characters (NPCs), often simulating human-like intelligence. The techniques used typically draw upon existing methods from the field of artificial intelligence (AI). Game playing was an area of research in AI from its inception.

In this project, we are going to implement a game called Othello, a classic 2 player, perfect information game by incorporating Minimax algorithm and extending it with Alpha Beta Pruning to search and implement alternating plies. The prime purpose of this algorithm is to look ahead at a predetermined number of plies, known as the ply depth and then take turn and play accordingly.We would also analyze the effect of increasing the ply depth against the time complexity.

2. About the game Othello
Othello is a strategy board game for two players, played on an 8×8 uncheckered board. There are sixty-four identical game pieces called disks (often spelled "discs"), which are light on one side and dark on the other. Players take turns placing disks on the board with their assigned color facing up. During a play, any disks of the opponent's color that are in a straight line and bounded by the disk just placed and another disk of the current player's color are turned over to the current player's color.
The object of the game is to have the majority of disks turned to display your color when the last playable empty square is filled.

Computer Othello programs search for any possible legal moves using a game tree. In theory, they examine all positions / nodes, where each move by one player is called a "ply". This search continues until a certain maximum search depth or the program determines that a final "leaf" position has been reached.

3. Complexity of Game
The Othello 8x8 game tree size is estimated at 1054 nodes, and the number of legal positions is estimated at less than 1028. Although not mathematically solved yet, a solution could possibly be found using intensive computation with top programs on fast parallel hardware or through distributed computation.

4. Programming Language
We implemented the game in Java Programming Language. This would allow us to create classes so that we can simulate multi player games if needed and also gives us a real feel of coding for pseudo codes.

5. Algorithms
We have chosen Minimax Algorithm as the main search algorithm with an aim to reducing the number of possible positions to
search.

5.1 Minimax Algorithm
Minimax (sometimes MinMax or MM) is a decision rule used in decision theory, game theory, statistics and philosophy for minimizing the possible loss for a worst case(maximum loss) scenario. Originally formulated for two-player zero-sum game theory, covering both the cases where players take alternate moves and those where they make simultaneous moves, it has also been extended to more complex games and to general decision making in the presence of uncertainty. We are planning to extend the minimax algorithm with Alpha Beta pruning to further reduce the search space.

5.2 Alpha Beta Pruning Algorithm
Alpha–beta pruning is a search algorithm that seeks to decrease the number of nodes that are evaluated by the minimax algorithm in its
search tree. It is an adversarial search algorithm used commonly for machine playing of two-player games (Tic-tac-toe, Chess, Go, etc.). It stops completely evaluating a move when at least one possibility has been found that proves the move to be worse than a previously examined move. Such moves need not be evaluated further. When applied to a standard minimax tree, it returns the same move as minimax would, but prunes away branches that cannot possibly influence the final decision.
