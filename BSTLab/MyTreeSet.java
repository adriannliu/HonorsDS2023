/**
 * MyTreeSet contains a collection of methods that operate on 
 * MyTreeSets, which are a form of binary search tree. The methods included are:
 * size, contains, add, remove, toString
 * 
 * @author Adrian Liu
 * 
 * @version January 9, 2024
 *
 */ 

public class MyTreeSet<E>
{
    private TreeNode root;
    private int size;
    private TreeDisplay display;

    /**
     * Constructor for objects of the MyTreeSet class
     */
    public MyTreeSet()
    {
        root = null;
        size = 0;
        display = new TreeDisplay();

        //wait 1 millisecond when visiting a node
        display.setDelay(100);
    }

    /**
     * Gets the size of the MyTreeSet
     * 
     * @return the size of the MyTreeSet
     */
    public int size()
    {
        return size;
    }

    /**
     * Checks if the MyTreeSet contains Object obj
     * 
     * @param obj   the object to be searched for in the MyTreeSet
     * 
     * @return      true if tree set contains obj;
     *              otherwise, false
     */
    public boolean contains(Object obj)
    {
        display.displayTree(root); 
        return BSTUtilities.contains(root, (Comparable) obj, display);
    }

    /**
     * Adds obj to the MyTreeSet unless there is a duplicate.
     * 
     * @param obj   the object to be added
     * 
     * @return      true if obj was not already present and has been added;
     *              otherwise, false
    */
    public boolean add(E obj)
    {
        display.displayTree(root); 
        if (!contains(obj)) {
            root = BSTUtilities.insert(root, (Comparable) obj, display);
            size++;
            return true;
        }
        return false;
    }
    
    /**
     * Removes Object obj if MyTreeSet contains it.
     * 
     * @param obj    the object to be checked for and removed
     * 
     * @return       true if obj is present and removed;
     *               otherwise, false.
    */
    public boolean remove(Object obj)
    {
        display.displayTree(root); 
        if (contains(obj)) {
            root = BSTUtilities.delete(root, (Comparable) obj, display);
            size--;
            return true;
        }
        return false;
    }
    
    /**
     * Converts the root to a String 
     * 
     * @return the root as a String
    */
    public String toString()
    {
        return toString(root);
    }

    /**
     * Converts the TreeNode t to a String 
     * 
     * @param t     the TreeNode to be converted
     * 
     * @return      the TreeNode as a String
    */
    private String toString(TreeNode t)
    {
        if (t == null)
            return " ";
        return toString(t.getLeft()) + t.getValue() + toString(t.getRight());
    }
}