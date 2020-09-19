public class StringBufferDemo{
    public static void main(String[] args){
        System.out.println("running StringBufferDemo ...");

        System.out.println("1. add ---------------------");
        add();

        System.out.println("2. update ---------------------");
        update();

        System.out.println("3. delete ---------------------");
        delete();
    }

    // add method
    public static void add(){
        StringBuffer sb = new StringBuffer();
        sb.append("ABC");
        System.out.println("append result : " + sb);
        sb.insert(3, "DE");
        System.out.println("append insert : " + sb);
    }

    // update method
    public static void update(){
        StringBuffer sb = new StringBuffer("ABBAAA");
        // sb.setCharAt(2, "C");
        // System.out.println("update result : " + sb);
        // sb.setCharAt(3, 5, "DE");
        System.out.println("update result : " + sb);
        System.out.println("inverse result : " + sb.reverse());
    }

    // delete method
    public static void delete(){
        StringBuffer sb = new StringBuffer("ABCDEFG");
        //sb.delete(2, "C");
        System.out.println("delete result : " + sb);
        sb.deleteCharAt(2);
        System.out.println("delete result : " + sb);
        sb.delete(0, sb.length());
        System.out.println("clean cache result : " + sb);
    }
}