import java.util.Stack;

/**
 * Write a description of class StringUtil here.
 * 
 * @author Anu Datar
 * @version 10/27/2017
 * @author Adrian Liu
 * @version November 15, 2023
 */
public class StringUtil
{
    //reverse a string using a Stack and substring not charAt
    public static String reverseString(String str)
    {
        String returnString = "";
        String[] arr = str.split("");
        Stack chars = new Stack();
        for(int i = 0;i < arr.length; i++)
        {
            chars.push(arr[i]);
        }
        while(!chars.isEmpty())
        {
           returnString += chars.pop();
        }
        return returnString;
    }

    // must use reverse written above
    public static boolean isPalindrome(String s)
    {
        return s.equals(reverseString(s));
    }

    // The tester for checking that reverse and isPalindrome work well.
    public static void main(String[] args)
    {
        String test =  "racecar";
        String test2 = "notapalindrome";

        if ( !("".equalsIgnoreCase(reverseString(""))) )
            System.out.println("** Oops Something went wrong. Check your reverse method **");

        if ( !("a".equalsIgnoreCase(reverseString("a"))) )
            System.out.println("** Oops Something went wrong. Check your reverse method **");

        if (!test.equalsIgnoreCase(reverseString(test)))
            System.out.println("** Oops Something went wrong. Check your reverse method **");
        else
            System.out.println("Success " + test + " matched " + reverseString(test));
            
        if (test2.equalsIgnoreCase(reverseString(test2)))
            System.out.println("** Oops Something went wrong. Check your reverse method **");

    }
}
