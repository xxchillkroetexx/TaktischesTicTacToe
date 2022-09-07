# Taktisches TicTacToe
This Game is for 2 players on one PC.

## Aim of the Game
You are trying to get 3 in a row in the "big" field. Just as in normal TicTacToe.
There is a small field tracking the progress implemented.

## Rules
The rules assume you know how to play regular TicTacToe.

### The Board
The Board consists of 3x3 regular TicTacToe panels. Each panel is made up of 3x3 fields. They are refered to as shown:
```
 _________________
|     |     |     |
|  1  |  2  |  3  |
|_____|_____|_____|
|     |     |     |
|  4  |  5  |  6  |
|_____|_____|_____|
|     |     |     |
|  7  |  8  |  9  |
|_____|_____|_____|
```
The numbers are used for the panel and field declaration. 

### First Turn
Player 1 chooses a panel in the big field to start with.
Right after that she chooses the field within that panel where she wants the X to be placed.

### Moving
Player 2 now is forced to play his next turn in the panel with the number that corresponds to the field number Player 1 has picked the turn before, e.g. If Player 1 picked field 1, Player 2 now has to move to panel 1 and play his next turn there.

Now Player 1 has to move to the panel corresponding with the field number picked by Player 2.

