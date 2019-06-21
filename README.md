# Algoritm-Analyze_PlayerManager 
In this project, we are expected to design a Dynamic Programming (DP) and a Greedy approach that selects quality players for a football club in a given price.

## Our Problem and Explanation of the Expected Quality Player Selection
Suppose that you are the manager of a football club. You are expected to sign free contract players for your team with the given budget of $X. The owner of the club will fire you if you spend money more than $X (You are allowed to spend less than $X). You are considering N different positions (such as Goalkeeper, Defender, Forward etc.). For each position in a team, there are K players who are available to play that specific position. However, you must sign at most one player for each position. If you do not sign any players at a particular position, then you plan to stick with the players you already have for that position.

Each player has three main information:
- The player’s position,
- The amount of money that will cost to sign the player,
- The player’s rating.

The goal is to maximize the total ratings of players you signed while spending no more than $X. Our algorithm output the total ratings and total price you spent on signings with the list of the players you signed.

**Note :** You will get the ratings, signing costs and positions of each player from the “/resources/input.xlsx” file




