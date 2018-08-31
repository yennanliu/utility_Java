// credit 
// https://www.geeksforgeeks.org/sorting-in-java/



// A sample Java program to demonstrate working of
// Arrays.sort().
// It by default sorts in ascending order.
import java.util.Arrays;
import java.util.*;
 
public class sort_demo {
    public static void main(String[] args)
    {
    	// -------------  demo 1  -------------
    	// sort array of number 
    	System.out.println(" demo 1 " );
        int[] arr = { 99,13, 7, 6, 45, 21, 9, 101, 102 };
 
        Arrays.sort(arr);
 

        System.out.printf("Modified arr[] : %s",
                          Arrays.toString(arr));

        // -------------  demo 2 ------------- 
        // Create a list of strings
        System.out.println(" " );
        System.out.println(" demo 2 " );
        ArrayList<String> al = new ArrayList<String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");
 
        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(al);
 
        // Let us print the sorted list
        System.out.println("List after the use of"
                           + " Collection.sort() :\n" + al);

        // -------------  demo 3  -------------
        System.out.println(" " );
        System.out.println(" demo 3 " );
    	// sort array of number inversely 
    	// Note that we have Integer here instead of
        // int[] as Collections.reverseOrder doesn't
        // work for primitive types.
        Integer[] arr2 = { 13, 7, 6, 45, 21, 9, 2, 100 };
 
        // Sorts arr[] in descending order
        Arrays.sort(arr2, Collections.reverseOrder());
 
        System.out.printf("Modified arr[] : %s",
                          Arrays.toString(arr2));

        // -------------  demo 4  -------------
        // sort sub array 
        System.out.println(" " );
        System.out.println(" demo 4 " );

        // Our arr contains 8 elements
        int[] arr3 = { 13, 7, 6, 45, 21, 9, 2, 100 };
 
        // Sort subarray from index 1 to 4, i.e.,
        // only sort subarray {7, 6, 45, 21} and
        // keep other elements as it is.
        Arrays.sort(arr3, 1, 5);
 
        System.out.printf("Modified arr[] : %s",
                          Arrays.toString(arr3));





    }
}
