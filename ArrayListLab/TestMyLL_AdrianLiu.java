import java.util.Iterator;

/**
 * Demonstrates execution of each and every method within MyLinkedList.  
 * 
 * @author Marina Peregrino  
 * @version 12 19, 2019     
 *          Created Skeleton to outline some basic tests for students to create.  
 * 
 * @author Adrian Liu
 * @version 11/3/2023
 */
public class TestMyLL_AdrianLiu
{

    /**
     * Tests each of the methods for the MyArrayList: 
     * 
     * toString
     * size()
     * add(n)
     * add(i, n)
     * 
     * remove
     * set
     * get
     * 
     */
    public static void main (String [] args){ 
        /*
         * Things to consider:
         * What would be different for a Linked List?  
         */

        String studentName = "Adrian"; //Insert your name here.
        System.out.println("Tests MyLL for "+ studentName); 

        // Test that MyArrayList implements the interface
        MyLinkedList nums1 = new MyLinkedList();
        MyLinkedList numsFirst = new MyLinkedList();

        /**
         * test1:  Tests for each of the following: 
         * add(i, n) to an empty list,
         * add(i, n) to an existing list,
         * size,
         * toString 
         */
        boolean test1 = true; 
        if (!test1){
            System.out.println ("Skipping Test #1"); 
        }
        else{
            System.out.println ("#1 Testing: add at first index");
            for (int i=0; i < 5; i++){
                numsFirst.addFirst(i);
                System.out.println ("" + numsFirst + ", size: " + numsFirst.size());
            }
            System.out.println(numsFirst.toString());
            
            
            System.out.println ("Testing: add at last index");
            for (int i=0; i < 5; i++){
                nums1.addLast(i);
                System.out.println ("" + nums1 + ", size: " + nums1.size());
            }
            System.out.println(nums1.toString());
        }
        nums1= null;   //release unused data 
        //////////////////////////////////////////////////////////////////////

        /**
         * test2:  Tests for each of the following: 
         * add(n) to an empty list,
         * add(n) to an existing list,
         * size,
         * toString 
         */
        MyLinkedList nums2 = new MyLinkedList();
        boolean test2 = true; 
        if (!test2){
            System.out.println ("Skipping Test #2"); 
        }
        else{
            System.out.println ("\n#2 Testing: add (appending)");
            for (int i=0; i < 5; i++){
                nums2.add(i);
                System.out.println ("" + nums2);
            }
            System.out.println(nums2.toString());
        }

        /**
         * test3:  Tests for each of the following: 
         * iterator,
         * hasNext,
         * next,
         */
        boolean test3 = true; 
        if (!test3){
            System.out.println ("Skipping Test #3"); 
        }
        else{
            /* */
            System.out.println ("\n#3 Testing: iterator:  ");
            System.out.println ("List:\n" + nums2);
            String s ="";
            MyLinkedList<String> myLL = new MyLinkedList<String>();
            for(int i = 0; i < nums2.size(); i++)
            {
                myLL.add("" + i);
            }
            /*
             * get an iterator 
             * loop through and get values from the iterator 
             * append the values to a String 
            /* */
            Iterator<String> iter = myLL.iterator();
            while(iter.hasNext())
            {
                String val = iter.next();
                s += val + ", ";
            }

            System.out.print(" yields:");
            System.out.println(s);
        }

        nums2= null;  //release unused data 
        //////////////////////////////////////////////////////////////////////

        /**
         * Previous tests were Integer list subsequent tests are String list
         * 
         * Add tests for the methods 
         * append,              
         * insert, 
         * remove, 
         * set, 
         * get
         * 
         * from begin, middle and end of list
         * 
         * test index out of bounds
         */
        MyLinkedList<String> list = new MyLinkedList();

        /**
         * test4:  Tests for each of the following: 
         * set
         * get
         * 
         * 
         */
        boolean test4 = true; 
        if (!test4){
            System.out.println ("Skipping Test #4"); 
        }
        else{
            MyLinkedList<Integer> nums4 = new MyLinkedList();
            for(int i = 0; i < 5; i++)
            {
                nums4.add(i,i);
            }
            System.out.println ("\n#4 Testing: get and set:  ");
            System.out.println ("List:\n" + nums4);

            nums4.add(3,5);
            System.out.println("inserted 5 to index 3:" + nums4);

            for(int i = 0; i < 6; i++)
            {
                nums4.set(i,10+i);
            }
            System.out.println("set all to 10+i: " + nums4);

            System.out.println("\nget first: " + nums4.getFirst());
            System.out.println("get last: " + nums4.getLast());

            nums4.remove(2);
            System.out.println("\nremoved from index 2: " + nums4);

            nums4.removeFirst();
            System.out.println("removed first: " + nums4);
            nums4.removeLast();
            System.out.println("removed last: " + nums4);
        }

        /**
         * test5:  Tests for each of the following: 
         * 
         * 
         * 
         */
        boolean test5 = false; 
        if (!test5){
            System.out.println ("Skipping Test #5"); 
        }
        else{
            System.out.println("\n More tests:");
            throw new RuntimeException("Write code to test MyArrayList");
        }

        /**
         * test6:  Tests exception for index out of bounds 
         * tests each of the methods that use index, 
         * add, remove, set, get
         * Tests when underlying array does have such and index and when it does not.   
         */
        boolean test6 = true; 
        if (!test6){
            System.out.println ("Skipping Test #6"); 
        }
        else{
            System.out.println("\nTest 6: testing index out of bounds exception:");
            MyLinkedList<Integer> nums3 = new MyLinkedList();
            for(int i = 0; i < 5; i++)
            {
                nums3.add(i,i);
            }
            System.out.println("list: " + nums3);
            System.out.println("size:" + nums3.size());
            try 
            {
                nums3.add(7,4);
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e + ": Index out of bounds" );
                System.out.println("I tried to add to index 7");
            }
            try 
            {
                nums3.remove(7);
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("I tried to remove from index 7");
            }
            try 
            {
                nums3.set(7,4);
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("I tried to set at index 7");
            }
            try 
            {
                nums3.get(7);
            } 
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("I tried to get at index 7");
            }
        }
    }
}
