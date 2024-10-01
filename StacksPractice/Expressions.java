import java.util.Stack;

/**
 * Write a description of class StringUtil here.
 * 
 * @author Anu Datar
 * @version 10/27/2017
 * @author Adrian Liu
 * @version November 15, 2023
 */

public class Expressions
{
    // parenthesis matching : An expression is said to be balanced if
    // every opener has a corresponding closer, in the right order
    // {, [ or ( are the only types of brackets allowed
    // @param   expression containing operands operators 
    //          and any of the 3 supportedbrackets
    // @return  true is the parenthesis are balanced         
    //          false otherwise
    public static boolean matchParenthesis(String expression)
    {
        String[] chars = expression.split(" ");
        Stack<String> characters = new Stack<String>();
        for(int i = 0; i < chars.length; i++)
        {
            switch(chars[i])
            {
                case"{":
                case"[":
                case"(":
                    characters.push(chars[i]);
                    break;
                case"}":
                    if(characters.isEmpty())
                    {
                        return false;
                    }
                    else if(!characters.peek().equals("{"))
                    {
                        return false;
                    }
                     else
                    {
                        characters.pop();
                        break;
                    }
                case"]":
                    if(characters.isEmpty())
                    {
                        return false;
                    }
                    else if(!characters.peek().equals("["))
                    {
                        return false;
                    }
                     else
                    {
                        characters.pop();
                        break;
                    }
                case")":
                    if(characters.isEmpty())
                    {
                        return false;
                    }
                    else if(!characters.peek().equals("("))
                    {
                        return false;
                    }
                     else
                    {
                        characters.pop();
                        break;
                    }
            }
        }
        if(characters.isEmpty())
            return true;
        return false;
    }
    // returns a string in postfix form 
    // if given an expression in infix form as a parameter
    // does this conversion using a Stack
    // @param expr valid expression in infix form
    // @return equivalent expression in postfix form
   
    public static String infixToPostfix(String expr)
    {
        return "";
    }
    // returns the value of an expression in postfix form
    // does this computation using a Stack
    // @param expr valid expression in postfix form
    // @return value of the expression
    // @precondition postfix expression  
    //               contains numbers and operators + - * / and %
    //               and that operands and operators are separated by spaces
    public static double evalPostfix(String expr)
    {
        Stack<Double> operands = new Stack<Double>();
        String [] chars = expr.split(" +");

        for (int i = 0; i < chars.length; i++)
        {
            switch(chars[i])
            {
                case "+":
                    operands.push(operands.pop()+operands.pop());
                    break;
                case "-":
                    double o1 = operands.pop();
                    double o2 = operands.pop();
                    operands.push(o2-o1);
                    break;
                case "*":
                    operands.push(operands.pop()*operands.pop());
                    break;
                case "/":
                    double o3 = operands.pop();
                    double o4 = operands.pop();
                    operands.push(o4/o3);
                    break;
                case "%":
                    double o5 = operands.pop();
                    double o6 = operands.pop();
                    operands.push(o6%o5);
                    break;
                default:
                    operands.push(Double.parseDouble(chars[i]));
                    break;
            }
        }
        return operands.pop();
    }

    // Tester to check if infix to postfix and evaluate postfix work well
    public static void main(String[] args)
    {
        String exp = "2 + 3 * 4";
        test(exp, 14);

        exp = "8 * 12 / 2";
        test(exp, 48);

        exp = "5 % 2 + 3 * 2 - 4 / 2";
        test(exp, 5);   

        // test balanced expressions
        testBalanced("{ 2 + 3 } * ( 4 + 3 )", true);
        testBalanced("} 4 + 4 { * ( 4 + 3 )", false);
        testBalanced("[ [ [ ] ]", false);
        testBalanced("{ ( } )", false);
        testBalanced("( ( ( ) ) )", true);
    }

    public static void test(String expr, double expect)
    {
        String post = infixToPostfix(expr);        
        double val = evalPostfix(post);

        System.out.println("Infix: " + expr);
        System.out.println("Postfix: " + post);
        System.out.println("Value: " + val);
        if (val == expect)
        {
            System.out.print("** Success! Great Job **");
        }
        else
        {
            System.out.print("** Oops! Something went wrong. ");
            System.out.println("Check your postfix and eval methods **");
        }
    }

    public static void testBalanced(String ex, boolean expected)
    {
        boolean act = matchParenthesis(ex);
        if (act == expected)
            System.out.println("** Success!: matchParenthesis(" + ex + ") returned " + act);
        else
        {
            System.out.print("** Oops! Something went wrong check : matchParen(" + ex + ")");
            System.out.println(" returned " + act + " but should have returned " + expected);
        }
    }
}
