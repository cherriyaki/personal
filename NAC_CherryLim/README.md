# Technical Submission for R3

by Cherry Lim

#### How to build run the code

In terminal, please navigate to the project directory ("NAC_CherryLim"). Run the command 
`gradle build` to compile the code, then `gradle run` to execute it. The output of my checkState method will print to terminal. The grid is by default blank, so on the first run, `U` (for undecided outcome) will be printed.

If opening the project in an IDE, please run the 'gradle build' task, followed by 'gradle run'.

##### Please note
- Source code is in src > main > java > NoughtsAndCrosses
- To fill in the grid, please do so in `Main` class. 
- My solution allows any grid, with length of at least 3, to be verified.
- My solution assumes the grid to have only one winner or none.
 - My constructor takes in a 2D char array, i.e. `char[][]`.
- Please ignore the ".idea" folder if the project isn't opened in IntelliJ.
