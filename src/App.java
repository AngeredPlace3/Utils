
import util.collections.*;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Tuple<Integer> tuple = new Tuple<>(ArrayList.of(1,2,3,454)).set(0,100000);
        System.out.println(tuple);
    }
}