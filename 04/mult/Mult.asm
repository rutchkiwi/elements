// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
//
// This program only needs to handle arguments that satisfy
// R0 >= 0, R1 >= 0, and R0*R1 < 32768.


// M always refers to the memory word 
// who's address is in A.

// @ loads the value given into A.
// M means the memory at A

@R2
M=0

(LOOP)

// Jump to end if R0 is 0
@R0     
D=M     
@END    
D;JLE   

// Loop body
@R1
D=M
@R2
M=M+D  // Add R1 to R2

@R0
M=M-1  // Decrement R0

@LOOP  
A;JMP  // Jump to loop start

(END)