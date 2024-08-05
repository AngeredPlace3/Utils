
import util.collections.*;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue + " "+ queue.size());
        for (int i = 0; i < 10; i++) {
            queue.dequeue();
        }

        System.out.println(queue + " "+ queue.size());
    }
}