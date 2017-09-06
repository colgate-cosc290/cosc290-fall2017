# Lab 1: Sets

- Course: COSC 290 Discrete Structures Fall 2017
- Instructor: Michael Hay
- Assignment: Lab 1
- Due dates: 
    + Answers to problems: turn in at the start of class on Monday 9/11.
    + Code: upload code to moodle by Tuesday 9/12 11:55pm


## Instructions

In this lab, you are asked to answer some "pencil and paper" questions related to sets, and then implement a Set interface.

The "pencil and paper" questions are intended to help you think through some of the challenges you will encounter writing the code. 

:tada: *Optional challenge problems* :tada: 

- Write a second implementation of the Set interface that uses an array-backed hash table and linear probing.  (Be careful with removal!  You will need to create an object that can serve as a tombstone.)
- In your second implementation, implement `powerSet` using iteration instead of recursion (see "pencil and paper" questions below).

## Setting up the coding environment

1. Download the code from [here](https://github.com/colgate-cosc290/cosc290-fall2017/raw/master/labs/lab1/Sets.tgz).  I suggest making a directory on your Desktop called `cosc290` and making a subdirectory inside `cosc290` called `lab1`.  Put the downloaded files in there.
2. Edit the code.  You can use any editor you want.  These computers have editors specifically designed for code such as JEdit, JGrasp, Geany.  They also have a general-purpose text editor called Atom. 
3. To run your code, you can either use a tool like JEdit which has menu commands to Build and Run the code.  Or you can use the command line!  I highly encourage this approach.
  
   To use the command line, open up Terminal.  This will give you a prompt.  There are three useful commands (among many [others](http://mally.stanford.edu/~sr/computing/basic-unix.html):
   
   This command:
   
        $ pwd 
   will tell you in which directory you are currently located.  This command:
   
        $ ls 
   will list the contents of the current directory.  This command: 
   
        $ cd /Users/mhay/Desktop/cosc290/lab1/
   will change the current directory to the directory specified by the path, which in this case is `/Users/mhay/Desktop/cosc290/lab1/`.
   
   Once you have navigated to the directory that contains your code, you can compile your code by typing:
   
       $ javac SetMain.java
       
   And execute your code by typing:
   
       $ java SetMain
4. You will write your code in `SetMain.java` and `SetImpl.java`.  To get started on the coding, see the descriptions of the methods in the `Set.java` interface and see additional instructions in `SetMain.java`.
5. Important: see the note about saving your files at the end of this lab description!


## "Pencil and paper" questions

Write up answers to the following questions.  You can turn them in on pencil and paper.  **If you would rather type up your answers, I'm looking for a few students to try out some online tools that make writing math easier.  If you are interested in trying these out, please let me know!**

### Warm up questions

1. Sets can be defined via *enumeration* or *abstraction*.  Let's define $S$ by enumeration: $S := \{ 1, 2, 3 \}$ and let's define $T$ be abstraction: $T := \{ (x + 1) \bmod 4: x \in S \}$.  What is $T$?  I.e., enumerate the elements of $T$.
2. Let $A := \{ a, b, c \}$. What is $\mathcal{P}(A)$, the power set of $A$?
3. Let $bitstrs := \{ 0, 1 \}^3$.  Enumerate the elements of $bitstr$.

### Generating a powerset through iteration

4.  Let $A$ and $bitstr$ be defined as above.  Show how the elements of $\mathcal{P}(A)$ can be represented by binary sequences of length three.   In other words, present a one-to-one mapping between the elements of $bitstr$ and $\mathcal{P}$.
5. Generalize your answer to the previous question for any set $S$ of size $n$.  Your answer should be *bijective* function $f$ between $\{ 0, 1\}^n$ and $\mathcal{P}(S)$.  You can use the notation $\langle x_1, x_2, \dots, x_n \rangle$ to refer to an element in $\{ 0, 1 \}^n$ where $x_i$ is either 0 or 1.
6. Given the above, what is $|\mathcal{P}(S)|$ if $|S| = n$?

### Generating a powerset through recursion

7. Suppose $S := \emptyset$.  What is $\mathcal{P}(S)$?  (Be careful!)
8. Consider $A$ as defined above.  What is $\mathcal{P}(S - \{ a \})$? (See if you can observe a relationship between \mathcal{P}(S)$ and \mathcal{P}(S - \{ a \})$.  The next question asks you to formalize this pattern.)
9. Given a set $S$ of arbitrary size and let $x$ be some element in $S$.  Let $PS = \mathcal{P}(S - \{ x \})$.  Define $\mathcal{P}(S)$ in terms of $PS$.  You may want to use set operations (union, intersection, difference) and *set abstraction* (see first question).

## Saving and accessing your files

You can gain access to this room during open lab hours.  However, you are **strongly encouraged to save a copy of your work on Google Drive, Dropbox, etc. so you can easily access it from elsewhere.**

It is possible to remotely access your files.  On an Apple computer, you click on the Desktop, then go to the menu bar.  Click `Go -> Connect to server...` and type in one of the following:

    smb://username@sarafina.cs.colgate.edu/cosc/username
    smb://username@sarafina.cs.colgate.edu/cosc290/username
    smb://username@sarafina.cs.colgate.edu/cosc301/username
    smb://username@sarafina.cs.colgate.edu/cosc140/username

where obviously you need to replace `username` with your CS account username which is lastname and first initial (e.g., `haym`).  **Only one of these will work for you**.  You might be able to surmise which one will work based on what other COSC classes you are currently taking. 
