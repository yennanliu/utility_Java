// A sample Java program to demonstrate working of 
// Arrays.sort(). 
// It by default sorts in ascending order. 

/*

modify from https://www.geeksforgeeks.org/sorting-in-java/

*/

import java.util.Arrays; 
import java.util.Collections; 
  
public class sort_demo { 
    public static void main(String[] args) 
    { 
    	// ---------------------- demo 1 ----------------------
    	System.out.println(" ------------ demo 1 ------------ ");
        int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 }; 
  
        Arrays.sort(arr); 
  		System.out.print(""); 
        System.out.printf("Modified arr[] : %s", Arrays.toString(arr)); 
        System.out.print(""); 
        // ---------------------- demo 2 ----------------------
        // dev 
        
        /*
    	System.out.println(" ------------ demo 2 ------------ ");
    	 // Create a list of strings 
        ArrayList<String2> al = new ArrayList<String>(); 
        al.add("Geeks For Geeks"); 
        al.add("Friends"); 
        al.add("Dear"); 
        al.add("Is"); 
        al.add("Superb"); 
  
        Collections.sort(al); 
  		
        // Let us print the sorted list 
        System.out.print(""); 
        System.out.println("List after the use of"
                           + " Collection.sort() :\n" + al); 
        System.out.print(""); 
        */


    } 

} 






