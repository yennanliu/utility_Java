import ocean.Fish;
import ocean.plants.Seaweed;
import com.caveofprogramming.oceangame.Aquarium; 

public class App {
    
    public static void main(String[] args) {
        Fish fish = new Fish();
        Seaweed weed = new Seaweed();
        Aquarium aquarium = new Aquarium();
        // run the import packages 
        fish.main();
        weed.main();
        aquarium.main();
    }
}
