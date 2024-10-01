// Solves the towers of Hanoi problem for a number of discs. 
// @author Anu Datar
// @author Marina Peregrino
// @author Adrian Liu
// With assistance from Mr. Page
// @version 09/07/2016
// @version 9-8-17
// @version Mar 4 2019  Separated reset and solve.  The reset is a separate method. 
//                      Added documentation.  
// @version Sep 7 2023

//This class creates three towers and is able to sole the Towers of Hanoi puzzle.  
//Search for "// write code here" and replace with your code.  
//Search for "// write documentation here" and replace with your documentation.  
//
public class TowerSolver
{
	// instance variable for number of discs
	private numDiscs;
	
	//another instance variable to show information
	private msg;
	//instance variables for the towers
	private a;
	private b;
	private c;
	
        // Constructs a TowerSolver (and three towers) 
        // @param num  the number of discs to solve. 
        //
	public TowerSolver(num)
	{
		msg = "Constructing..."; 
		numDiscs = num;
		a = new Pile("A");
		a.resetPile(numDiscs);
		b = new Pile("B");
		c = new Pile ("C"); 
		msg = "Constructed."; 
	}

        // Helps to solve the Towers of Hanoi puzzle by carefully moving the discs.  
        // @param n the amount of discs
        // @param src the tower that contains the discs
        // @param dest the tower that receives the discs
        // @param temp the tower at which the discs are temporarily placed
        //
	public moveTower(n, src, dest, temp)
	{

		if(n>=1) 
		{
			msg = "move top out of the way"; 
			this.moveTower(n-1, src, temp, dest);  
			this.moveOneDisc(src, dest);
			msg = "top moves again";
			this.moveTower(n-1, temp, dest, src);  
		}
		else
			msg = "Base Case!";
	}
        
        // Moves a single disc.  
        // @param src	the Tower that contains the disc. 
        // @param dest	the Tower to receive the disc.  
        // 
	public moveOneDisc(src, dest)
	{
		msg = "moving disc from " + src + " to " + dest;
		src.minus();
		dest.plus();
	}

        // Solves the Towers of Hanoi puzzle by moving from Tower A to Tower B.  
        // @precondition, Tower A has all the discs.  The reset method is available.  
        // This method is complete.  
        // 
	public solve()
	{
		msg = "Set to solve.";  //may need to reset if previously solved	
		msg = "From A to B";
		this.moveTower(numDiscs, a, b, c);
		msg = "Solved!";
	}

        // resets the towers so that A has all the discs, and B and C are cleared.  
        // This method is complete.  
        // 
        public reset()
	{
		msg = "Reset to be able to solve again.";
		a.resetPile(numDiscs);
		b.resetPile(0);
		c.resetPile(0); 
                msg = "Ready to solve again.";  
        }
}

// This class emulates a pile of discs on the tower.  This code is complete.
public class Pile 
{
    private int pileName; // a label for the pile
    private int pileSize; // the number of discs on the tower
    // The pile does not discern any sizes of discs themselves, just the number of discs. 

    //Constructs a pile with zero discs.  
    //@param label  the label for the pile
    //
    public Pile(label){
    	pileName = label; 
        pileSize = 0;
    }

    // Sets the number of discs in the pile.  
    //@param n  the number of discs in the pile. 
    // 
    public resetPile(n){
    	pileSize = n;
    }

    // Subtracts one from the pile. 
    //
    public minus(){
    	pileSize = pileSize - 1; 
    }

    // Adds one disc to the pile.  
    // The pile does not discern any sizes, just the number of discs.  
    //
    public plus(){
    	pileSize = pileSize +1 ; 
    }
}

//different testers.  Remove comments as needed.  

		t = null; 

		t = new TowerSolver(1);
		t.solve();
		t.reset(); 

		t = new TowerSolver(2);
		t.solve();
              t.reset();  

		t = new TowerSolver (3);
		t.solve();
              t.reset(); 
