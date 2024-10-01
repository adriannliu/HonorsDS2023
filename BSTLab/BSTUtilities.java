/**
 * BSTUtilities contains a collection of static methods that operate on 
 * binary search trees. The methods included are:
 * contains, insert, deleteNode, and delete.
 * 
 * @author Max Xing
 * @author Vivek Nayyar
 * @author Adrian Liu
 * 
 * @version January 6, 2024
 *
 */ 
public class BSTUtilities extends TreeUtil
{
    /**
     * Checks if the BST rooted at t contains Comparable x
     * 
     * @param t         the root of a binary search tree
     * @param x         the comparable which is checked to see if it is in the binary 
     *                  search tree
     * @param display   the display that will show the traversal
     * 
     * @precondition   t is the root of a binary search tree
     * 
     * @return          true if t contains x;
     *                  otherwise, false.
     */
    public static boolean contains(TreeNode t, Comparable x, TreeDisplay display)
    {
        if(t == null)
            return false;
        int comp = x.compareTo(t.getValue());
        if(comp == 0)
            return true;
        else if(comp < 0)
            return contains(t.getLeft(), x, display);
        else 
            return contains(t.getRight(), x, display);
    }

    /**
     * Inserts x into the BST rooted at t and returns the result
     * 
     * @param t            the root of the binary search tree
     * @param x            the comparable to be inserted
     * @param display      the display that will show the traversal
     * 
     * @precondition       t is the root of a binary search tree
     * 
     * @return       if t is empty, returns a new tree containing x;
     *               otherwise, returns root t with x having been inserted
     *               according to the properties of a BST;
     *               x is ignored if it is a duplicate of an element
     *               already in the BST rooted at t; only one new
     *               TreeNode is created in the course of the traversal
     */
    public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
    {
        if(t == null)
            return new TreeNode((Object) x);
        int comp = x.compareTo(t.getValue());
        if(comp > 0)
            t.setRight(insert(t.getRight(), x, display));
        else
            t.setLeft(insert(t.getLeft(), x, display));
        return t;
    }

    /**
     * deletes the node t in a binary search tree with root t
     * 
     * @param t        The root of the binary search tree.
     *                 Also the node being deleted
     * @param display  The display that will show the traversal
     * @precondition   t is the root of a binary search tree
     * 
     * @return         returns a pointer to a binary search tree,
     *                 in which the value at node t has been deleted
     *                (and no new TreeNodes have been created)
     */
    private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
    {
        if (t == null)
            return null;
        display.visit(t);
        if (t.getRight() == null) 
            return t.getLeft();
        if (t.getLeft() == null)
            return t.getRight();
            
        TreeNode left = t.getLeft();
        Comparable pred = (Comparable)TreeUtil.rightmost(left);
        t.setValue(pred);
        t.setLeft(delete(t.getLeft(), pred, display));
        
        return t;
    }

    /**
     * Deletes the comparable x from a binary search tree rooted at t
     * 
     * @param t             the root of a binary search tree
     * @param x             the comparable being deleted from the binary search tree
     * @param display       the display that will show the traversal
     * 
     * @precondition        t is the root of a binary search tree
     * 
     * @return        returns a pointer to a binary search tree
     *                in which the value x has been deleted (if present)
     *                (and no new TreeNodes have been created)
     */
    public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display)
    {
        int comp = x.compareTo(t.getValue());
        display.visit(t);
        if (comp < 0)
            t.setLeft(delete(t.getLeft(), x, display));
        else if (comp > 0)
            t.setRight(delete(t.getRight(), x, display));
        else
            return deleteNode(t, display);
        return t;
    }
}
