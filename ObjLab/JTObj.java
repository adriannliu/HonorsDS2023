// @author Adrian Liu
// @version August 31, 2023

 
// Calculator is a class that can add, subtract, mulitply numbers, square a number,
// check if a number is odd, return the maximum of two numbers, and return the absolute value of a number.
public class Calculator 
{
	// Adds up two given numbers.
	// @param x the first number
	// @param y the second number
	// @return the sum of the two numbers
	public add(x, y)
	{
		return x+y;
	}
	
	// Subtracts two given numbers.
	// @param x the first number
	// @param y the second number
	// @return the difference between the two numbers
	public subtract(x, y)
	{
		return x-y;
	}

	// Multiplies two given numbers.
	// @param x the first number
	// @param y the second number
	// @return the product of the two numbers
	public multiply(x, y)
	{
		return x*y;
	}
	
	// Squares given number.
	// @param x the number to square
	// @return the square of the given number
	public square(x)
	{
		return x*x;
	}
	
	// Checks if given number is odd.
	// @param x the number to check
	// @return true if the number is odd,
	// 	        else, false
	public isOdd(x)
	{
		return x%2 != 0;
	}

	// Returns the greater of the two given numbers;
	// @param x the first number
	// @param y the second number
	// @return the greater of the two numbers
	public max(x, y)
	{
		if(x==y)
		{
			return x;
		}
		if (x>y)
		{
			return x;
		}
		return y;
	}
	
	// Returns absolute value of the given number
	// @param x the number to get the absolute value of
	// @return the absolute value of the give number
	public abs(x){
		if(x < 0)
		{
			return x*(-1);
		}
		return x;
	}
}

// Box is a class that contains getter and setter methods for its assigned value
public class Box
{

	// The value that is assigned to the Box object;
	private value;
	

	// Constructs Box object with the assigned value.
	// @param val the value that the Box object is going to be assigned.
	public Box(val)
	{
		this.setValue(val);
	}

	// Returns the box's value.
	// @return the value of the box
	public getValue()
	{
		return value;
	} 
	
	// Sets the box's value
	// @param newValue the number that the value is going to be set to
	public setValue(newValue)
	{
		value = newValue;
	}
}

// Counter is a class that keeps track of a count. It can add 1 to the count (tick),
// get the count, and reset the count by setting it to 0.
public class Counter
{
	// The counter that keeps track of the number as changes are made.
	private count;
	
	// Constructs the Counter object with a default value of 0.
	public Counter()
	{
		count = 0;
	}

	// Adds 1 to the count.
	public tick()
	{
		count = count+1;
	}
	
	// Returns the count.
	// @return the count
	public getCount()
	{
		return count;
	}
	
	// Sets the count to 0.
	public reset()
	{
		count = 0;
	}
}

// Flipper is a class that changes boolean current's value between true and false.
public class Flipper
{
	// The boolean value that stores the current value.
	private current;
	
	// Constructs objects of the Flipper class and sets the starting boolean value to false.
	public Flipper()
	{
		current = false;
	}
	
	// Sets the current boolean value to the alternate boolean value.
	// @return the current value of the stored boolean.
	public next()
	{
		current = !current;
		return current;
	}
}

// Fibber is a class that finds the next number in the Fibonacci sequence.
public class Fibber
{
	// The most recent and second most recent values of the sequence that have been calculated.
	private firstNum;	
	private secondNum;

	// Constructs a Fibber object and sets the firstNum and secondNum to 0 and 1, respectively.
	public Fibber()
	{
		firstNum = 0;
		secondNum = 1;
	}
	
	// Returns the next number in the Fibonacci sequence.
	// @return the next number in the Fibonacci sequence.
	public next()
	{	
		temp = firstNum;
		firstNum = secondNum;
		secondNum = temp+secondNum;
		return temp;
	}
		
}

// Container is a class which contains a number that is assigned to the created object of the class.
public class Container
{
	// The value assigned to the Container object
	private stuff;

	// Constructs objects of the Container class and sets stuff to the given value.
	// @param the value that stuff is assigned to
	public Container(s)
	{
		stuff = s;
	}
	
	// Sets the the stuff in the container
	// @param newS the new value of stuff
	public setStuff(newS)
	{
		stuff = newS;
	}
	// Returns the value of stuff.
	// @return the value of stuff
	public getStuff()
	{
		return stuff;
	}
}

// Swapper is a class that swaps the values of two containers
public class Swapper
{
	//Swaps the values of the two given containers
	// @param c1 the first container
	// @param c2 the second container
	public swap(c1, c2)
	{
		c1Value = c1.getStuff();
		c1.setStuff(c2.getStuff());
		c2.setStuff(c1Value);
	}

}

// Enumerator is a class that returns the next number in within the given bounds. It also assesses if the next number is within the bounds and can be returned.
public class Enumerator
{
	// The bounds of the current number
	private low;
	private high;
	// The current number
	private currentNum;

	// Constructs an object of the Enumerator class and sets the low and high bounds of the counter.
	// @param l the low bound
	// @param h the high bount
	public Enumerator(l, h)
	{
		low = l;
		high = h;
		currentNum = l-1;
	}

	// Returns if the next number is within the set bounds.
	// @return if the next number is within the set bounds
	public hasNext()
	{
		if(currentNum+1 <= high)
		{
			return true;
		}
		return false;
	}
	
	// Returns the next number in the sequence if it is within the bounds.
	// @return the next number in the sequence if it is within the bounds
	//		   else, return that there is no next number within the bounds
	public next()
	{
		if (currentNum+1 <= high)
		{
			currentNum = currentNum +1;
			return currentNum;
		}
		return "There's no next.";
	}

}
