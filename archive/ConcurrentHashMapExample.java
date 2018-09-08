
// Java program to demonstrate 
// clear() method 
  
import java.util.concurrent.ConcurrentHashMap; 
import java.util.*; 
  
public class ConcurrentHashMapExample { 
  
    public static void main(String[] args) 
    { 
  
        // Creating a ConcurrentHashMap 
        Map<String, String> my_cmmap = new ConcurrentHashMap<String, String>(); 
  
        // Inserting mappings in ConcurrentHashMap 
        // with the help of put() method 
        my_cmmap.put("1", "1"); 
        my_cmmap.put("2", "1"); 
        my_cmmap.put("3", "1"); 
        my_cmmap.put("4", "1"); 
        my_cmmap.put("5", "1"); 
        my_cmmap.put("6", "1"); 
        my_cmmap.put("xxx", "yyy"); 
  
        // Print the ConcurrentHashMap 
        System.out.println("Map before use of clear(): \n"
                           + my_cmmap); 
  
        // Now clear the map using clear() 
        my_cmmap.clear(); 
  
        // Print the clea Map 
        System.out.println("Map after use of clear(): "
                           + my_cmmap); 
    } 
} 