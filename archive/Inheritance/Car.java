public class Car extends Machine {
     
     
    @Override
    public void start() {
        System.out.println("Car started (Override method)");
    }

    @Override
    public void stop(){
        System.out.println("Car stoped (Override method)");
    }
 
    public void wipeWindShield() {
        System.out.println("Wiping windshield");
    }
     
    public void showInfo() {
        System.out.println("Car name: " + name);
    }
}