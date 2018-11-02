/*

modify from 
https://www.geeksforgeeks.org/hashmap-entryset-method-in-java/

*/

// Java code to illustrate the entrySet() method 
import java.util.*; 
  
public class Hash_Map_Demo { 
    public static void main(String[] args) 
    { 
        System.out.println(" ------------ demo 1 ------------ ");
        // Creating an empty HashMap 
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>(); 
  
        // Mapping string values to int keys 
        hash_map.put(10, "Geeks"); 
        hash_map.put(15, "4"); 
        hash_map.put(20, "Geeks"); 
        hash_map.put(25, "Welcomes"); 
        hash_map.put(30, "You"); 
        hash_map.put(99, "yo"); 
  
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map); 
  
        // Using entrySet() to get the set view 
        System.out.println("The set is: " + hash_map.entrySet()); 


        // -------------------------------------------------------


        System.out.println(" ------------ demo 2 ------------ ");
                // Creating an empty HashMap 
        HashMap<String, Integer> hash_map2 = new HashMap<String, Integer>(); 
  
        // Mapping int values to string keys 
        hash_map2.put("Geeks", 10); 
        hash_map2.put("4", 15); 
        hash_map2.put("Geeks", 20); 
        hash_map2.put("Welcomes", 25); 
        hash_map2.put("You", 30); 
  
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map2); 
  
        // Using entrySet() to get the set view 
        System.out.println("The set is: " + hash_map2.entrySet());  }

    } 

 