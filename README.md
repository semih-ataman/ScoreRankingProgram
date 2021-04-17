# ScoreRankingProgram

Problem

• This object oriented program creates the standing tables from the given all matches
result separately of the Ice Hockey and Handball sports. Of course, we can add another types of
sports to the system easily.(For example Football or Basketball.)

------------------------------------------------------------------------------------------------------
Information about the sports

• In Ice Hockey, in which three points are awarded to the team winning a match, with no
points awarded to the losing team. If the game is drawn, each team receives one point.
• In Handball, in which two points are awarded to the team winning a match, with no
points awarded to the losing team. If the game is drawn, each team receives one point.
• If two or more teams are on the same number of points. The number of goals scored
against a team is subtracted from the number of goals it has scored itself. The bigger
the goal dierence, the better.

Customly you can define the rules of the new sport classes.

------------------------------------------------------------------------------------------------------
Sample Input and Outputs

• Sample input file named as fixtures.txt:
[First letter of sport]tab[name of first club]tab[name of second club]tab[match
result]newline

• Sample output files:

[ranking.]tab[name of club]tab[number of played matches]tab[number of matches
won ]tab[match with an even score or tie]tab[number of matches loss ]tab[number
of sets For:the number of sets Against ]tab[total points]newline

• The explanation of the standing table columns for each sport types are as follows:

- First column defines the ranking
- Second column defines the club name
- Third column defines the number of played matches
- Fourth column defines the number of matches won
- Fifth column defines the number of times a team has finished a match with an
even score or tie
- Sixth column defines the number of matches loss
- Seventh column defines the number of sets For : the number of sets Against
- Eighth column defines the total number of points earned

------------------------------------------------------------------------------------------------------
How to run your program

The input file is going to be given as program argument. In order to test your program, you
should follow the following steps:

• Compile your code (javac *.java)
• Run your program (java Main fixtures.txt)
• Control your output data and format.

------------------------------------------------------------------------------------------------------
