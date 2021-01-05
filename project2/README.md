#Financial Simulation

This program runs a simulation over 40 years based on the financial decisions
of a person. It can simulate a financially literate person and a not
financially literate person.

This program should be compiled with the commmand:

'gcc FinancialSimulation.c -o FinancialSimulation'

and run with the commmands:

'./FinancialSimulation FLinput.txt output.txt'

or

'./FinancialSimulation NFLinput.txt output.txt'

You can create a new input file with custom numbers that is formated the same
way as the two sample input files. You would also need to replace the
'FLinput.txt' or 'NFLinput.txt' with the new input file as the command line
argument.

The format of the input files goes (in order):

initialDebt yearlySalary addlPay loanInterest housePrice rentPrice inputFL

Each number should be inputed with exactly 1 space in between them. The last
number (inputFL) represents if the person is FL or NFL (1 for FL, 0 for NFL).
Any other number inputted for this variable will quit the program.
