
/**
 * HeapUtils contains a collection of static methods for manipulating heaps.
 * The methods included are: heapify,swap, buildHeap, sinkDown, remove, insert,
 * bubbleUp, heapSort
 *
 * @author Adrian Liu
 * @version 1/9/2024
 */
public class HeapUtils
{
    private Comparable[] heap;
    private int heapSize;

    /**
     * Constructor for objects of HeapUtils class
     * 
     * @param arr   an array of Comparable objects
     * @param size  the number of nodes in the heap
     */
    public HeapUtils(Comparable[] arr, int size)
    {
        heap = arr;
        heapSize = size;
    }

    /**
     * Converts a binary tree into a heap by continually swapping the value
     * at index with its smallest child, if such a child exists. The algorithm
     * has complexity O(log n) because it just calls sinkDown.
     * 
     * @param heap      the array containing the heap
     * @param index     the index of the value to be sunk down
     * @param heapSize  the size of the heap
     */
    public static void heapify(Comparable[] heap, int index, int heapSize)
    {
        if(index * 2 > heapSize)
            return;
        sinkDown(heap,heapSize,index);
    }

    /**
     * Swaps two integer values in an array of Comparables.
     * Has complexity of O(1) because it just accesses values in an array
     * 
     * @param arr       the array for which values will be swapped
     * @param index1    the index of the first value to be swapped
     * @param index2    the index of the second value to be swapped
     */
    private static Comparable swap(Comparable[] arr, int index1, int index2)
    {
        Comparable temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return temp;
    }

    /**
     * Takes in a full binary tree with randomly arranged nodes and 
     * arranges them into a heap with heapSize nodes by sinking down each
     * non-leaf node. Has complexity O(nlogn) because it calls sinkDown
     * n times.
     * 
     * @param heap     Complete binary tree containing heapSize nodes
     *                 with randomly arranged values
     * @param heapSize number of nodes in the binary tree
     */
    public static void buildHeap(Comparable[] heap, int heapSize)
    {
        int lastNode = heapSize / 2;
        for (int i = lastNode; i > 0; i--)
        {
            sinkDown(heap,heapSize,i);
        }
    }

    /**
     * Sinks down the node at the given index by swapping with the node's
     * smaller child until it cannot sink further or reaches the bottom of
     * the heap. Has complexity O(logn) because it calls on each node
     * with logn levels
     * 
     * @param heap  the array containing size number of nodes
     * @param size  the number of nodes in the heap
     * @param index the index of the node to sink down
     */
    private static void sinkDown(Comparable[] heap, int size, int index)
    {
        int left = index * 2;
        int right = index * 2 + 1;
        if(left > size) // no child
            return;
        
        int smallChild = left;
        if(right <= size && heap[right].compareTo(heap[left]) < 0)
            smallChild = right;
        if (heap[index].compareTo(heap[smallChild]) > 0 )
            swap(heap,smallChild,index);
        sinkDown(heap,size,smallChild);
    }

    /**
     * Removes and returns the root value of the heap. The remaining tree 
     * is then readjusted to become a heap again. Has complexity O(logn)
     * because it just calls sinkDown.
     * 
     * @param heap      the array containing the heap
     * @param heapSize  the number of nodes in the heap
     * 
     * @return the removed value
     */
    public static Comparable remove(Comparable[] heap, int heapSize)
    {
        Comparable root = swap(heap, 1, heapSize);
        heapSize--;
        sinkDown(heap, heapSize, 1);
        return root;
    }

    /**
     * Inserts an item into the heap, maintaining the heap's conditions.
     * Has complexity O(logn) because it calls bubbleUp.
     * 
     * @param heap      the array containing the heap
     * @param item      the item to be inserted
     * @param heapSize  the number of nodes in the heap
     * 
     * @return the new heap with a newly inserted item.
     */
    public static Comparable[] insert(
    Comparable[] heap, Comparable item, int heapSize)
    {
        heapSize++;
        heap[heapSize] = item;
        bubbleUp(heap,heapSize,heapSize);
        return heap;
    }

    /**
     * Bubbles up the node at index. If the node at index is less than its
     * parent, the two swap. Runs recursively until the node has
     * found its place. Has complexity O(logn) because it runs for each
     * non-leaf node.
     * 
     * @param heap  the array containing the heap
     * @param size  the number of nodes in the heap
     * @param index the index of the node to be bubbled up
     */
    private static void bubbleUp(Comparable[] heap, int size, int index)
    {
        int parent = index / 2;
        if(parent == 0)
            return;
        int comp = heap[index].compareTo(heap[parent]);

        if (comp > 0)
            return;
        swap(heap,parent,index);
        bubbleUp(heap,size,parent);
    }

    /**
     * Sorts a heap in ascending order in an array. Complexity O(nlogn)
     * 
     * @param heap  the array containing the heap
     * @param size  the number of nodes in the heap
     * 
     * @return      the heap in a sorted array
     */
    public static Comparable[] heapSort(Comparable[] heap, int size)
    {
        buildHeap(heap, size);
        while (size > 1)
        {
            remove(heap, size);
            size--;
        }
        return heap;
    }
}