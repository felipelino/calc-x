# Calc-X

This project is a Calculator in Portuguese made in 2005. 
I recovered it from my days at University.

# Pre-requisites

* Maven
* Java JDK 1.8 (or higher)

# Build

    mvn clean package

# Run

    java -jar target\calc-x-1.0.jar

---

# Description

Scientific calculator that allows addition of the fundamental operations: 
* Calculation of the integral in a given interval;
* Calculation of the derivative at a point;
* Approximate calculation of the roots of an equation in a given interval;
* Calculation of arithmetic expressions.
* Allows you to save a report on the operations performed.
* It also has help. Available only in Portuguese. 

# Manual

## Special Buttons


	CE - Clears the Calculator variables,  which is maintained in memory, and the  function F (x).
	AC - Clears all variables, including  memory function F (x) and expression.
	M + - It is a cumulative sum of the value that is  on the screen to what is already in memory.  He gets reset.
	RM - Retrieves the value that is in  memory, without deleting it.
	<< - Backspace.
	= - In its use outside of the expression, is an  operation with two operands.
	REL - Opens and closes the Report  of the calculations.
	Expres - Change the way the calculator to  input an expression, which  need not be T otal  parentisada. Example: 4 + sin (40 +5) * (3 / 2)
	Function - Changes the calculator to  the entry of a function F (x),  enabling buttons Root,  Deriv, and Integ.
	Buttons operators  
	In order of precedence :
	sen - Sine
	cos - cosine
	tan - Tangent
	Arcsin - Arc Sine
	Arccos - Arc Cosine
	ArcTan - Arc Tangent
	LN - natural logarithm
	x ^ y - x value of y
	x ^ (1 / 2) - Square root
	/ - Division
	* - Multiplication
	- - Subtraction
	+ - Sum
		Depending on the mode of operation (Function,  Express or Normal) these buttons  perform different functions.
		
		Other :

		Deg - degrees (normal default)
		Rad - Radian
		EXP - in scientific notation format:  nE a (+/-)
		x  - enabled mode only function  to indicate the unknown.
		) , ( - enabled only for parentisar  functions and expressions.

		Constants
		and  - Number of Euler
		IP - IP Value

		Function Buttons
		F (x) - Compute F (x) for x given.
		Root - Find the approximate value of  the first root in the interval  fornecido.Precisão 1E-14 or  10 ^ (-14).
		Deriv - Find the approximate value of  the derivative of the given value.
		Integ - Find the approximate value of the  integral in the given interval.
		ENT - Enter the value that is on the screen.
		Expression Buttons
		ENT - Resolves Expression only.
		= - Solve the expression and effects, the  result of the expression with some  previous operator.

		Note : The minus sign ( - ) is always  considered to operator expressions and  functions, there are no negative numbers.  Example: If you want to type the function  F (x) =-x / (-3) * 5, it should be written  as F (x) = (0, x) / (0-3) * 5.

		Report Buttons
		Save - When pressed the first  time opens a dialog box  to select where  the report should be saved.  In later times (unless you  have closed the window or  click the Clear button) it  saves the file in place already  chosen.
		Clear - Clears the contents of the report.

		Note : The saved format is txt, not h avendi need to put the  file extension in time to save him.   

		Keyboard Shortcuts
		F1 - Help Contents
		F2 - About
		F3 - Expres
		F4 - Function
		F5 - EXP
		F6 - REL
		F7 - Save
		F8 - Clear
		Esc - AC
		Delete - EC
		End - ENT
		Enter - = (equal)
		Backspace - <<
		A - Switch between Deg and Rad
		S - sin
		C - cos
		T - tan
		V - x ^ (1 / 2)
		L - LN
		y - x ^ y
		[ - Arcsin
		] - Arccos
		\ - ArcTan
		Z - + / -
		M - M +
		N - RM
		And - and
		P - PI
		( - (
		) -)
		X - x
		F - F (x)
		R - Root
		D - Deriv
		I - Integer
		+,-,/,*,., 1,2,3,4,5,6,7,8,9,0 and Xerces their normal functions.
