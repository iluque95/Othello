# Othello

Othello, also known as Reversi, is a game for two players and turn based. Each player has his own pieces which are represented with a color on the board. The rules are simple, but strategy is the most important and the what it will help you to win.

## Rules

### Starting

Normally the board is 8x8.

- Four pieces in the middle of the board forming a square and mixed between them.

Example:

*W: White
*B: Black


```cpp
1)                      2)
 x x x x x x x x         x x x x x x x x 
 x x x x x x x x         x x x x x x x x 
 x x x x x x x x         x x x x x x x x 
 x x x W B x x x         x x x B W x x x
 x x x B W x x x         x x x W B x x x
 x x x x x x x x         x x x x x x x x 
 x x x x x x x x         x x x x x x x x 
 x x x x x x x x         x x x x x x x x
```
  
  
 These are the two possibilities as starting game.
 
 
 ### Movements
 
 - You just have to surround opponent pieces between an existent piece of your colour and another new one.
 - After that, the pieces sorrounded are going to change from the opponent colour to your colour passing to your ownership.
 
 
 For example, suppose that you are white pieces and is your turn. You have some possibilities to perform a movement.
 Movements are marked with **O** symbol reprenting an option to choice.
 
 ```cpp
 1) Showing options      2) Picking an option    3) Result
  x x x x x x x x         x x x x x x x x         x x x x x x x x 
  x x x x x x x x         x x x x x x x x         x x x x x x x x 
  x x x x O x x x         x x x x x x x x         x x x x x x x x 
  x x x W B O x x         x x x W B x x x         x x x W B x x x
  x x O B W x x x         x x O B W x x x         x x W W W x x x
  x x x O x x x x         x x x x x x x x         x x x x x x x x 
  x x x x x x x x         x x x x x x x x         x x x x x x x x 
  x x x x x x x x         x x x x x x x x         x x x x x x x x 
```
 
 
 ### Winner
 
 Who got more pieces on his ownership after board is fully. It is probably to end in a tie.


## Requirements

Use java sdk toolkit, [java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).


## Usage

Execute Othello.java as main entrypoint.

## Documentation

Is attached in release section in Catalan language. You can translate it and take it a look.

Whole project is explained in depth detail on the doc, from taken decission to why we use some strategies.

## Working team

[@decube83](https://github.com/decube83/)

[@LivedMm](https://github.com/LivedMm/)

## Work

I worked around 90% on the logic of the game.

[@decube83](https://github.com/decube83/) worked around 90% on the MinMax algorithm heuristic.
[@LivedMm](https://github.com/LivedMm/) worked around 90% on the GUI of the project.

## License
[MIT](https://choosealicense.com/licenses/mit/)
