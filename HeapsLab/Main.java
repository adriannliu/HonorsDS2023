import java.util.*;
/**
 * The Main class holds all the testers for the Heaps Lab.
 *
 * @author Adrian Liu
 * @version 1/9/2024
 */
public class Main
{   
    /**
     * Creates an array of 11 Integers with values [1,100) and displays
     * as a heap.
     */
    public static void main(String[] args)
    {
        Integer[] arr = new Integer[12];
        for (int i = 1; i < arr.length; i++)
        {
            int rand = (int) (Math.random() * 99.0 + 1);
            arr[i] = rand;
        }

        HeapDisplay disp = new HeapDisplay();
        disp.displayHeap(arr,arr.length-1);   
    }

    /**
     * Tests heapSort which uses remove
     */
    public static void testHeapSortandRemove()
    {
        System.out.println("Now testing heapSort, which uses remove:\n");
        Integer[] heap = new Integer[11];
        int size = 10;
        
        for (int i = 1; i<=size; i++)
        {
            heap[i] = (int)(Math.random() * 99.0 + 1);
        }
        
        System.out.println("Random array: " + java.util.Arrays.toString(heap));
        HeapDisplay disp1 = new HeapDisplay("Random heap ");
        disp1.displayHeap(heap,size);
        HeapUtils.heapSort(heap, size);
        System.out.println("Sorted heap: "+ java.util.Arrays.toString(heap));
        HeapDisplay disp = new HeapDisplay("Sorted heap ");
        disp.displayHeap(heap,size);
    }
    
    /**
     * Tests buildHeap
     */
    public static void testBuildHeap()
    {
        System.out.println("Now testing buildHeap, which uses heapify:\n");
        Integer[] heap = new Integer[11];
        int size = 10;
        
        for (int i = 1; i<=size; i++)
        {
            heap[i] = (int)(Math.random() * 99.0 + 1);
        }
        
        System.out.println("Random array: " + java.util.Arrays.toString(heap));
        
        HeapUtils.buildHeap(heap, size);
        System.out.println("Built heap: " + java.util.Arrays.toString(heap));
        HeapDisplay disp = new HeapDisplay("Heap: ");
        disp.displayHeap(heap,size);
    }
    
    /**
     * Tests insert method
     */
    public static void testInsert()
    {
        System.out.println("Now testing insert:\n");
        Integer[] heap = new Integer[13];
        int size = 10;
        
        for (int i = 1; i<heap.length; i++)
        {
            heap[i] = (int)(Math.random() * 99.0 + 1);
        }
        
        System.out.println("Random: " + java.util.Arrays.toString(heap));
        HeapUtils.buildHeap(heap, size);
        System.out.println("Heap: " + java.util.Arrays.toString(heap));
        
        HeapUtils.insert(heap, 9999, size+1);
        System.out.println("\nInsert 9999: " 
                            + java.util.Arrays.toString(heap));
    }
}
