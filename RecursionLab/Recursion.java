// @author Max Xing
// @author Vivek Nayyar
// @author Adrian Liu
// @version 9/8/23

// The FancyCalc class uses recursive methods to perform calculations, including:
// calculating the given power of a given base number, squaring a number,
// finding the greatest common denominator of 2 numbers,
// checking if a number is prime, finding the factorial of a number,
// finding the nth number in the fibonacci sequence, and
// finding the square root of a number using Newton's method.
public class FancyCalc
{

	// Recursively calculates the value of the given base to the given power.
	// @param base the base of the exponent to be calculated
	// @param exponent the exponent the base is raised to
	// @return the base to the power of the exponent
	public pow(base, exponent)
	{
		if(exponent == 0)
		{
			//base case
			return 1; 
		}
		else
		{
			//recursive case
			return base * this.pow(base, exponent-1); 
		}
	}
	
	// Squares the given number
	// @param x the number to be squared
	// @return the square of the given number
	public square(x)
	{
		return x*x;
	}

	// Calculates the given base to the power of the given exponent. Faster than pow() on average.
	// @param base the base to be raised to the given exponent
	// @param exponent the exponent the base is raised to
	// @return the base to the power of the exponent
	public fastPow(base, exponent)
	{
		if (exponent==0)
		{
			return 1; //base case
		}
		if(exponent%2 ==0)
		{
			return this.square(this.fastPow(base, exponent/2)); // recursive case
		}
		else	
			return base*this.fastPow(base, exponent-1);

	}
	
	// Calculates the greatest common denominator of 2 given numbers
	// @param x the first number
	// @param y the second number
	// @return the greatest common denominator of the 2 given numbers
	public gcd(x, y)
	{
		if(x==0)
		{	
			return y; // base case
		}
		
		if(y == 0)
		{
			return x; // base case
		}
		return this.gcd(y, x%y); // recursive case
	}
	
	// Determines if the given number is prime
	// @param num the number that is checked to see whether it is prime or not
	// @return true if the given number is prime;
	//	   false if the give number is not prime
	public isPrime(x)
	{
		if(x >1)
		{
			return this.helpPrime(x, 2);
		}
		return false;
	}
	
	// Determines if the given number is prime
	// @param n the given number that is being checked if there is a divisor of
	// @param divisor the divisor that is being tested
	// @return true if the given number is prime;
	// 	   false if it is not prime 
	public helpPrime(n, divisor)
	{
		if(divisor==n) 
		{
			return true; // base case
		}
		if(n%divisor == 0)
		{
			return false; // base case
		}
		return this.helpPrime(n, divisor+1); // recursive case
	}

	// Returns the factorial of the given number
	// @param nxthe given number
	// @return the factorial of the given number
	public fact(x)
	{
		return this.factHelp(x, 1);
	}

	// Calculates the factorial of the given number
	// @param n the given number the factorial will be calculated of
	// @param result the current result that will be passed in and modified
	// @return the final calculate factorial value of the given number
	private factHelp(n, result)
	{
		if(n == 0)
		{
			return result; // base case
		}
		else
		{
			return this.factHelp(n-1, n*result); // recursive case
		}
	}
	
	// Returns the nth number in the Fibonacci sequence
	// @param n the nth number of the Fibonacci sequence that we want to find
	// @return the nth number of the Fibonacci sequence
	public fib(n)
	{
		if(n<=1)		
		{
			return n; // base case
		}
		return this.fib(n-1) + this.fib(n-2); // recursive case
	}

	// Returns the square root of the given number
	// @param x the given number that is used to find the square root of
	public sqrt(x)
	{
		return this.newtonMethod(x, x);
	}
	
	// Returns the average of two given numbers
	// @param x the first number
	// @param y the second number
	// @return the average of the two given numbers
	private average(x, y)
	{	
		return (x+y)/2;
	}
	
	// Checks whether the first parameter is less than or equal to the second
	// @param x the first number
	// @param y the second number
	// @return true is the first number is less than or equal to the second and the code should stop;	
	//	   false if the first number is greater than the second number
	private shouldStop(x, y)
	{
		if(x<=y)
		{
			return true;
		}	
		
		return false;
	}
	
	// Returns the square root of the given number 
	// @param guess the dividend used to calculate the next guess
	// @param number the number used to find the square root of
	// @return the square root of the given number using the Newton Method
	private newtonMethod(guess, number)
	{
		numOverGuess = number/guess;
		nextGuess = this.average(numOverGuess, guess);
		if(this.shouldStop(guess, nextGuess))
		{
			return guess;
		}
		return this.newtonMethod(nextGuess, number);
	}
		
}

