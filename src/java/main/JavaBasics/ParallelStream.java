import java.util.*;
import java.util.stream.Stream; 

public class ParallelStream{
    public static void main(String[] args){
        System.out.println("running ParallelStream ...");

        // create a list as dataset
        List<String> list = Arrays.asList("jim", "tom", "jack", "amy", "betty");
        // METHOD 1) create parallelStream via collection 
        Stream<String> parallelStream = list.parallelStream();
        System.out.println(parallelStream.isParallel());

        // create a stream
        Stream<String>stream =  Stream.of("jim", "tom", "jack", "amy", "betty");
        // METHOD 2) use basemap's parallel method make single stream to parallel stream
        Stream<String> parallel = stream.parallel();
        System.out.println(parallel.isParallel());
    }
}