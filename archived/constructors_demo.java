class Machine {

    private String name;
    private int code;

    public Machine(){

        this("ABC", 0);
        System.out.println("1st Constructor running!"); 

    } 

    public Machine(String name){
        this(name, 0);

        System.out.println("2nd Constructor running!"); 
    }

    public Machine(String name, int code){

        System.out.println("3rd Constructor running!");
        this.name = name;
        this.code = code;

    }
}


public class constructors_demo{

    public static void main(String [] args){

        Machine machine1 = new Machine();

        Machine machine2 = new Machine("JECK");

        Machine machine3 = new Machine("ABBA", 10);

    }


}