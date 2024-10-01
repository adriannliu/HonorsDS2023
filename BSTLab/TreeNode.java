/**
 * TreeNode creates a TreeNode object that is a node in a Tree. TreeNodes have 
 * a value and pointers to the TreeNode child to their left and right
 * 
 * @author Adrian Liu
 * @version 11/28/2023
 */
public class TreeNode
{
    private Object value;
    private TreeNode left;
    private TreeNode right;
    
    /**
     * Constructor for objects of the TreeNode class with 1 parameter
     * 
     * @param initValue  the value of the tree node
     */
    public TreeNode(Object initValue)
    { 
        this(initValue, null, null);
    }
    /**
     * Constructor for objects of the TreeNode class with 3 parameters
     * 
     * @param initValue  the value of the tree node
     * @param initLeft   the TreeNode to the left
     * @param initRight  the TreeNode to the right
     */
    public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
    { 
        value = initValue; 
        left = initLeft; 
        right = initRight; 
    }
    
    /**
     * Gets the TreeNode's value
     * 
     * @return the TreeNode's value
     */
    public Object getValue() { return value; }
    /**
     * Gets the TreeNode to the left
     * 
     * @return the TreeNode to the left
     */
    public TreeNode getLeft() { return left; }
    /**
     * Gets the TreeNode to the right
     * 
     * @return the TreeNode to the right
     */
    public TreeNode getRight() { return right; }

    /**
     * Changes the value of the current TreeNode to a new value
     * 
     * @param theNewValue the new value
     */
    public void setValue(Object theNewValue) { value = theNewValue; }
    /**
     * Changes the TreeNode to the left of this TreeNode
     * 
     * @param theNewLeft the new left TreeNode
     */
    public void setLeft(TreeNode theNewLeft) { left = theNewLeft; }
    /**
     * Changes the TreeNode to the right of this TreeNode
     * 
     * @param theNewRight the new left TreeNode
     */
    public void setRight(TreeNode theNewRight) { right = theNewRight; }
}
